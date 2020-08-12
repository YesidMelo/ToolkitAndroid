package com.mitiempo.toolkitpasarelaspago.epayco.Utilidades

import co.epayco.android.Epayco
import co.epayco.android.models.Authentication
import com.mitiempo.toolkitpasarelaspago.epayco.ExcepcionSinllavePrivada
import com.mitiempo.toolkitpasarelaspago.epayco.ExcepcionSinllavePublica

class Autenticacion {

    private var apikeyPublico : String  ?= null
    fun conApikeyPublico(apikeyPublico : String?) : Autenticacion {
        this.apikeyPublico = apikeyPublico
        return this
    }

    private var ApikeyPrivado: String  ?= null
    fun conApikeyPrivado(ApikeyPrivado: String?) : Autenticacion {
        this.ApikeyPrivado= ApikeyPrivado
        return this
    }

    private var idioma = "ES"
    fun conIdioma(idioma : String = "ES"): Autenticacion {
        this.idioma = idioma
        return this
    }

    private var esPrueba = true
    fun esPrueba(esPrueba : Boolean = true) : Autenticacion {
        this.esPrueba = esPrueba
        return this
    }

    private var EscuchadorFallaCreacionEpayco : ((Throwable)->Unit) ?= null
    fun conEscuchadorFallaCreacionEpayco (EscuchadorFallaCreacionEpayco : ((Throwable)->Unit)) : Autenticacion {
        this.EscuchadorFallaCreacionEpayco = EscuchadorFallaCreacionEpayco
        return this
    }

    fun generarEPayco() : Epayco?{

        if (!parametrosValidos()){ return null }

        val auth = Authentication()
        auth.apiKey = apikeyPublico
        auth.privateKey = ApikeyPrivado
        auth.lang = idioma
        auth.test = esPrueba

//        val epayco = Epayco(auth)
        return null
    }

    private fun parametrosValidos() : Boolean{
        if( apikeyPublico.isNullOrEmpty() ){
            EscuchadorFallaCreacionEpayco?.invoke(ExcepcionSinllavePublica())
            return false
        }

        if( ApikeyPrivado.isNullOrEmpty() ){
            EscuchadorFallaCreacionEpayco?.invoke(ExcepcionSinllavePrivada())
            return false
        }

        return true
    }

}