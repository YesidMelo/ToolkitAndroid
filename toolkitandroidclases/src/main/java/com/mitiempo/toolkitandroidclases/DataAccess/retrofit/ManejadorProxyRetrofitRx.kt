package com.mitiempo.toolkitandroidclases.DataAccess.retrofit

import androidx.appcompat.app.AppCompatActivity

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
                    }
                    .conEscuchadorRespuestaExitosaConServicio { objeto, servicio ,codigoServidor ->
                        mapaConsultas[servicio]?.invoke(objeto,codigoServidor)
                        mapaConsultas.remove(servicio)
                    }
                    .conServicio(fila.key)
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


}