package com.mitiempo.toolkitandroidclases.DataAccess.retrofit

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ProxyRetrofitRx {

//    region manejadorCabezera
    private var cabezera = emptyMap<String,String>().toMutableMap()
    fun conCabezera(cabezera : MutableMap<String,String>) : ProxyRetrofitRx {
        this.cabezera = cabezera
        return this
    }

    fun traerCabezeraAEnviar() : MutableMap<String,String>{
        return cabezera
    }
//    endregion

//region servicio a consultar
    private var servicio : IServiceParameters?= null
    fun conServicio(servicio : IServiceParameters) : ProxyRetrofitRx {
        this.servicio = servicio
        return this
    }

    fun traerServicioConsultado() : IServiceParameters?{
        return servicio
    }

//endregion

//region UrlBase
    private var urlBase : String = ""
    fun conUrlBase (urlBase : String) : ProxyRetrofitRx {
        this.urlBase = urlBase
        return this
    }

    fun traerUrlBase() : String{
        return urlBase
    }
//endregion

    fun realizarConsulta() {
        if(!estanTodosLosParametros()){ return }


        val client = generarCabezera()
        val rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

        val requestInterface = generarRequestInterface(client,rxJava2CallAdapterFactory)

        ejecutarCompositeDisposable(requestInterface)

    }



    private fun estanTodosLosParametros() : Boolean{
        if (urlBase.isEmpty()){
            escuchadorFalla?.invoke(ExceptionURLBase(),servicio!!,0)
            return false
        }

        if(servicio == null ){
            escuchadorFalla?.invoke(ExceptionServicio(),servicio!!,0)
            return false
        }

        return true
    }



    private var escuchadorFalla : ((Throwable,IServiceParameters,Int) -> Unit) ?= null
    fun conEscuchadorFalla(escuchadorFalla : ((Throwable,IServiceParameters,Int) -> Unit)) : ProxyRetrofitRx {
        this.escuchadorFalla = escuchadorFalla
        return this
    }

    private var codigoServidor = 0
    private fun generarCabezera() : OkHttpClient{
        val httpClient = OkHttpClient
            .Builder()
            .addInterceptor {

                val original = it.request()
                val request = original.newBuilder()

                for(fila in cabezera.entries){
                    request.addHeader(fila.key,fila.value)
                }
                codigoServidor = it.proceed(request.build()).code()

                return@addInterceptor it.proceed(request.build())
            }.build()
        return httpClient
    }



    private fun generarRequestInterface(client : OkHttpClient, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory) : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(urlBase)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

    private fun ejecutarCompositeDisposable(requestInterface : Retrofit){

        val traerDatos = requestInterface.create(TraerDatos::class.java)
        val myCompositeDisposable = CompositeDisposable()
        myCompositeDisposable
            .add(
                generarMetodoConsulta(traerDatos)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(manejadorRespuesta())
            )

    }

    private fun generarMetodoConsulta(traerDatos : TraerDatos):Observable<Any>{
        return when(servicio!!.getMethods()){
            IServiceParameters.Methods.GET -> { traerDatos.getData(servicio!!.getURL()) }
            IServiceParameters.Methods.POST -> { traerDatos.getData(servicio!!.getURL()) }
            IServiceParameters.Methods.PUT -> { traerDatos.getData(servicio!!.getURL()) }
            IServiceParameters.Methods.DELETE -> { traerDatos.getData(servicio!!.getURL()) }
            IServiceParameters.Methods.OPTIONS -> { traerDatos.getData(servicio!!.getURL()) }
        }
    }

    private fun manejadorRespuesta() : DisposableObserver<Any>{
        return object : DisposableObserver<Any>(){
            override fun onComplete() {

            }

            override fun onNext(t: Any) {
                EscuchadorRespuestaExitosaConServicio?.invoke(t,servicio!!,codigoServidor)
            }

            override fun onError(e: Throwable) {
                escuchadorFalla?.invoke(e,servicio!!,codigoServidor)
            }

        }
    }

    private var EscuchadorRespuestaExitosaConServicio : ((Any,IServiceParameters,Int)->Unit) ?= null
    fun conEscuchadorRespuestaExitosaConServicio(EscuchadorRespuestaExitosaConServicio : ((Any,IServiceParameters,Int)->Unit)) : ProxyRetrofitRx{
        this.EscuchadorRespuestaExitosaConServicio = EscuchadorRespuestaExitosaConServicio
        return this
    }

}