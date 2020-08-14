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

    private var mapaConsultas : MutableMap<IServiceParameters,(Any?)->Unit> = emptyMap<IServiceParameters,(Any?)->Unit>().toMutableMap()
    fun adicionarConsulta(servicio : IServiceParameters,consultaAAdicionar:(Any?)->Unit) : ManejadorProxyRetrofitRx{
        this.mapaConsultas.put(servicio,consultaAAdicionar)
        return this
    }

    fun iniciarConsulta(){
        Thread{
            EscuchadorInicioConsulta?.invoke()
            Thread.sleep(5000)
            EscuchadorFinConsulta?.invoke()
        }.start()
    }
}