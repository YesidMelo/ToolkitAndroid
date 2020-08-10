package com.mitiempo.toolkitandroidclases.DataAccess

import android.util.Log
import com.mitiempo.toolkitandroidclases.DataAccess.utilidadesPrueba.ObjetoAEnviar
import com.mitiempo.toolkitandroidclases.DataAccess.utilidadesPrueba.ObjetoEsperado
import com.mitiempo.toolkitandroidclases.DataAccess.utilidadesPrueba.Servicios
import org.junit.Test

class TestProxyRetrofit {


    val proxyRetrofit = ProxyRetrofitRx()

    @Test
    fun verificarCabezera(){

        val cabezeraAEnviar = emptyMap<String,String>().toMutableMap()
        cabezeraAEnviar.put("Token","nuevo token")
        proxyRetrofit.conCabezera(cabezeraAEnviar)

        assert(cabezeraAEnviar == proxyRetrofit.traerCabezeraAEnviar())

    }

    @Test
    fun verificacionCreacionServicio(){

        assert(Servicios.servicio_get.getURL().equals(""))
        assert(Servicios.servicio_get.getMethods().equals(IServiceParameters.Methods.GET))

        val complemento = "mi complemento"
        assert(Servicios.servicio_get.WithComplement(complemento).getURL().equals(complemento))

        val objetoAEnviar = ObjetoAEnviar()
        assert(
            Servicios
                .servicio_get
                .conObjetoAEnviar(objetoAEnviar)
                .traerObjetoAEnviar()
                ==
                objetoAEnviar
        )

        val claseEsperada = ObjetoEsperado::class.java
        assert(
            Servicios
                .servicio_get
                .conObjetoEsperado(claseEsperada)
                .traerClaseObjetoEsperado()
                ==
                    claseEsperada
        )

    }

}