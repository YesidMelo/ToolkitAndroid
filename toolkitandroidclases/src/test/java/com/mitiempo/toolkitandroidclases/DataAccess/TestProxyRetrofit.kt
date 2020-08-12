package com.mitiempo.toolkitandroidclases.DataAccess

import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.ExceptionServicio
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.ExceptionURLBase
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.IServiceParameters
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.ProxyRetrofitRx
import com.mitiempo.toolkitandroidclases.DataAccess.utilidadesPrueba.ObjetoAEnviar
import com.mitiempo.toolkitandroidclases.DataAccess.utilidadesPrueba.ObjetoEsperado
import com.mitiempo.toolkitandroidclases.DataAccess.utilidadesPrueba.Servicios
import org.junit.Test

class TestProxyRetrofit {

    val urlBase = "http://192.168.0.3:3000/"
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

    @Test
    fun verificacionServicioCreado(){

        val objetoAEnviar = ObjetoAEnviar()
        objetoAEnviar.unElemento = "Elemento a enviar"
        objetoAEnviar.otroElemento = "otro elemento"

        val claseObjetoEsperado = ObjetoEsperado::class.java

        val servicio = Servicios
            .servicio_get
            .WithComplement("")
            .conObjetoAEnviar(objetoAEnviar)
            .conObjetoEsperado(claseObjetoEsperado)

        proxyRetrofit.conServicio(servicio)

        assert(proxyRetrofit.traerServicioConsultado() == servicio)


    }

    @Test
    fun verificacionPasoParametrosProxyRetrofit(){
        var errorGenerado : Throwable ?= null
        proxyRetrofit
            .conEscuchadorFalla {
                errorGenerado = it
            }
            .realizarConsulta()

        assert(errorGenerado is ExceptionURLBase)

        errorGenerado = null

        proxyRetrofit
            .conUrlBase(urlBase)
            .conEscuchadorFalla {
                errorGenerado = it
            }
            .realizarConsulta()

        assert(errorGenerado is ExceptionServicio)


    }

    @Test
    fun verificandoApiRestPorDefecto(){
        assert(true)
        Thread{
            Thread.sleep(3_000)
            print("hola pepito")
        }.start()

    }
}