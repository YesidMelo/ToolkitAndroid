package com.mitiempo.toolkitandroidclases.DataAccess

class ProxyRetrofitRx {

//    region manejadorCabezera
    private var cabezera = emptyMap<String,String>().toMutableMap()
    fun conCabezera(cabezera : MutableMap<String,String>) : ProxyRetrofitRx{
        this.cabezera = cabezera
        return this
    }

    fun traerCabezeraAEnviar() : MutableMap<String,String>{
        return cabezera
    }
//    endregion

//region
    private var servicio : IServiceParameters ?= null
    fun conServicio(servicio : IServiceParameters) : ProxyRetrofitRx{
        this.servicio = servicio
        return this
    }

    fun traerServicioConsultado() : IServiceParameters?{
        return servicio
    }
//endregion



}