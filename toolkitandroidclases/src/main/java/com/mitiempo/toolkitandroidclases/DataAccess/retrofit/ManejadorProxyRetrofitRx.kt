package com.mitiempo.toolkitandroidclases.DataAccess.retrofit

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ManejadorProxyRetrofitRx {

    private var EscuchadorInicioConsulta : (()->Unit) ?= null
    fun conEscuchadorInicioConsulta(EscuchadorInicioConsulta : (()->Unit)) : ManejadorProxyRetrofitRx{
        this.EscuchadorInicioConsulta = EscuchadorInicioConsulta
        return this
    }

    private var EscuchadorFinConsulta : (()->Unit) ?= null
    fun conInicioEscuchadorFinConsulta(EscuchadorFinConsulta : (()->Unit)) : ManejadorProxyRetrofitRx{
        this.EscuchadorFinConsulta = EscuchadorFinConsulta
        return this
    }

    private var mapaConsultas : MutableMap<IServiceParameters,(Any?,Int)->Unit> = emptyMap<IServiceParameters,(Any?,Int)->Unit>().toMutableMap()
    fun adicionarConsulta(servicio : IServiceParameters,consultaAAdicionar:(Any?,Int)->Unit) : ManejadorProxyRetrofitRx{
        this.mapaConsultas.put(servicio,consultaAAdicionar)
        return this
    }

    private var EscuchadorFalla : ((Throwable,IServiceParameters?,Int?)->Unit) ?= null
    fun conEscuchadorFalla(EscuchadorFalla : ((Throwable,IServiceParameters?,Int?)->Unit)) : ManejadorProxyRetrofitRx{
        this.EscuchadorFalla = EscuchadorFalla
        return this
    }

    private var urlBase : String ?= null
    fun conUrlBase(urlBase : String) : ManejadorProxyRetrofitRx{
        this.urlBase = urlBase
        return this
    }

    private var cabezera = emptyMap<String,String>().toMutableMap()
    fun adicionarParametroACabecera(llave : String,valor : String) : ManejadorProxyRetrofitRx{
        cabezera.put(llave,valor)
        return this
    }

    fun iniciarConsulta(){
        Thread{

            if(!tieneTodosLosParametros()){ return@Thread }

            EscuchadorInicioConsulta?.invoke()

            for (fila in mapaConsultas.entries){

                ProxyRetrofitRx()
                    .conUrlBase(urlBase!!)
                    .conEscuchadorFalla { error, servicio,codigoServidor ->
                        EscuchadorFalla?.invoke(error,servicio,codigoServidor)
                        mapaConsultas.remove(servicio)
                    }
                    .conEscuchadorRespuestaExitosaConServicio { objeto, servicio ,codigoServidor ->
                        generarIRetrofitParcelable(objeto,servicio,codigoServidor)
                        mapaConsultas.remove(servicio)
                    }
                    .conServicio(fila.key)
                    .conCabezera(cabezera)
                    .realizarConsulta()

            }

            while (mapaConsultas.isNotEmpty())
            {
                Thread.sleep(500)
            }

            EscuchadorFinConsulta?.invoke()

        }.start()
    }

    private fun tieneTodosLosParametros() : Boolean{
        val listaConsulta = mapaConsultas.keys.toMutableList()
        if(urlBase == null ){

            EscuchadorFalla?.invoke(ExceptionURLBase(),listaConsulta[0],0)
            return false
        }
        if (mapaConsultas.isEmpty()){
            EscuchadorFalla?.invoke(ExceptionServicio(),null,null)
            return false
        }
        return true
    }

    private fun generarIRetrofitParcelable(objeto : Any,servicio : IServiceParameters,codigoServidor : Int) {

        if(esUnicoObjeto(objeto,servicio,codigoServidor)){ return }
        if(esListaObjetos(objeto,servicio,codigoServidor)){ return }
        mapaConsultas[servicio]?.invoke(null,codigoServidor)

    }

    private fun esUnicoObjeto(objeto : Any,servicio : IServiceParameters,codigoServidor : Int) : Boolean{
        return try {
            val gson = Gson()
            val objetoJson = gson.toJson(objeto)
            val respuesta = gson.fromJson(objetoJson,servicio.traerClaseObjetoEsperado())
            mapaConsultas[servicio]?.invoke(respuesta,codigoServidor)
            true
        }catch (e : Exception){
            false
        }
    }

    private fun esListaObjetos(objeto : Any,servicio : IServiceParameters,codigoServidor : Int) : Boolean{
        return try {
            val gson = Gson()
            val objetoJson = gson.toJson(objeto)

            val tipo = object :TypeToken<MutableList<Any>>(){}.type
            val listaCruda = gson.fromJson(objetoJson,tipo) as MutableList<*>
            val listaCasteada = emptyList<Any>().toMutableList()

            for(objetoCrudo in listaCruda){
                val objJson = gson.toJson(objetoCrudo)
                val objetoCasteado = gson.fromJson(objJson,servicio.traerClaseObjetoEsperado())
                listaCasteada.add(objetoCasteado)
            }

            mapaConsultas[servicio]?.invoke(listaCasteada,codigoServidor)

            true
        }catch (e : Exception){
            false
        }
    }

}