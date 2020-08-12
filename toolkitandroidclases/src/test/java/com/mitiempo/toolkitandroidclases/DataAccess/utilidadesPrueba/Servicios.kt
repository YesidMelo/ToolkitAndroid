package com.mitiempo.toolkitandroidclases.DataAccess.utilidadesPrueba

import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.IRetrofitParcelable
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.IServiceParameters

enum class Servicios(
    private val url : String,
    private val metodo : IServiceParameters.Methods
    ) : IServiceParameters {
    servicio_get("", IServiceParameters.Methods.GET)

    ;

    override fun getURL(): String {
        return url + complemento
    }

    override fun getMethods(): IServiceParameters.Methods {
        return metodo
    }

    private var complemento : String = ""
    override fun WithComplement(complement: String): IServiceParameters {
        this.complemento = complement
        return this
    }

    private var objeto_enviar : IRetrofitParcelable?= null
    override fun <T : IRetrofitParcelable> conObjetoAEnviar(objetoAEnviar: T): IServiceParameters {
        this.objeto_enviar = objetoAEnviar
        return this
    }

    override fun  traerObjetoAEnviar(): IRetrofitParcelable? {
        return objeto_enviar
    }

    private var claseEsperada : Class<*> ?= null
    override fun <T : IRetrofitParcelable> conObjetoEsperado(objetoEsperado: Class<T>): IServiceParameters {
        this.claseEsperada = objetoEsperado
        return this
    }

    override fun traerClaseObjetoEsperado(): Class<*>? {
        return claseEsperada
    }

}