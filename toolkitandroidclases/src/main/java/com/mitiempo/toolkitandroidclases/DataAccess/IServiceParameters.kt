package com.mitiempo.toolkitandroidclases.DataAccess

interface IServiceParameters {

    enum class Methods{
        GET,
        POST,
        PUT,
        DELETE,
        OPTIONS,
    }

    fun getURL() : String
    fun getMethods() : Methods
    fun WithComplement(complement: String = ""): IServiceParameters
    fun <T : IRetrofitParcelable>conObjetoAEnviar(objetoAEnviar : T) : IServiceParameters
    fun traerObjetoAEnviar() : IRetrofitParcelable?
    fun <T : IRetrofitParcelable>conObjetoEsperado(objetoEsperado : Class<T>) : IServiceParameters
    fun traerClaseObjetoEsperado () : Class<*>?

}