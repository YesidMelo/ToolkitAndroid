package com.mitiempo.toolkitpasarelaspago.epayco

import co.epayco.android.Epayco
import com.mitiempo.toolkitpasarelaspago.epayco.Utilidades.Autenticacion

class ManejadorEpayco {

    private var apikeyPublico : String  ?= null
    fun conApikeyPublico(apikeyPublico : String) : ManejadorEpayco {
        this.apikeyPublico = apikeyPublico
        return this
    }

    private var ApikeyPrivado: String  ?= null
    fun conApikeyPrivado(ApikeyPrivado: String) : ManejadorEpayco {
        this.ApikeyPrivado= ApikeyPrivado
        return this
    }

    private var idioma = "ES"
    fun conIdioma(idioma : String = "ES"): ManejadorEpayco {
        this.idioma = idioma
        return this
    }

    private var esPrueba = true
    fun esPrueba(esPrueba : Boolean = true) : ManejadorEpayco {
        this.esPrueba = esPrueba
        return this
    }

    private var EscuchadorFalla : ((Throwable)->Unit) ?= null
    fun conEscuchadorFalla (EscuchadorFalla : ((Throwable)->Unit)) : ManejadorEpayco {
        this.EscuchadorFalla = EscuchadorFalla
        return this
    }

    fun generarEpayco(escuchadorEpayco : (Epayco?)-> Unit ) : ManejadorEpayco {

        var epaycoGeneradoCorrectamente = false

        val epayco = Autenticacion()
            .conApikeyPrivado(ApikeyPrivado)
            .conApikeyPrivado(apikeyPublico)
            .conIdioma(idioma)
            .conEscuchadorFallaCreacionEpayco {
                EscuchadorFalla?.invoke(it)
                epaycoGeneradoCorrectamente = false
            }
            .esPrueba(esPrueba)
            .generarEPayco()

        if(!epaycoGeneradoCorrectamente){
            return this
        }


        escuchadorEpayco.invoke(epayco)
        return this
    }
}