package com.mitiempo.toolkitandroid

import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.IRetrofitParcelable
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.IServiceParameters

enum class Servicios(
    private val url: String,
    private val metodo : IServiceParameters.Methods
) : IServiceParameters {
    traerGet("",IServiceParameters.Methods.GET),
    traerGetServicio1("Servicio1",IServiceParameters.Methods.GET),
    traerGetServicio2("Servicio2",IServiceParameters.Methods.GET),
    traerGetServicio3("Servicio3",IServiceParameters.Methods.GET),
    traerGetServicio4("Servicio4",IServiceParameters.Methods.GET),
    ;

    override fun getURL(): String {
        return url + complemento
    }

    override fun getMethods(): IServiceParameters.Methods {
        return metodo
    }

    private var complemento = ""
    override fun WithComplement(complement: String): IServiceParameters {
        this.complemento = complement
        return this
    }

    private var objetoAEnviar : IRetrofitParcelable ?= null
    override fun <T : IRetrofitParcelable> conObjetoAEnviar(objetoAEnviar: T): IServiceParameters {
        this.objetoAEnviar = objetoAEnviar
        return this
    }

    override fun traerObjetoAEnviar(): IRetrofitParcelable? {
        return objetoAEnviar
    }

    private var claseObjetoEsperado : Class<*> ?= null
    override fun <T : IRetrofitParcelable> conObjetoEsperado(objetoEsperado: Class<T>): IServiceParameters {
        this.claseObjetoEsperado = objetoEsperado
        return this
    }

    override fun traerClaseObjetoEsperado(): Class<*>? {
        return claseObjetoEsperado
    }
}