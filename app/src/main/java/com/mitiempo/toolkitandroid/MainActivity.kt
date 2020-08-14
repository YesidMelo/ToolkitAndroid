package com.mitiempo.toolkitandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.IRetrofitParcelable
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.ManejadorProxyRetrofitRx
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hola_mundo.setOnClickListener {

            configurarServicio(Servicios.traerGet)
            configurarServicio(Servicios.traerGetServicio1)
            configurarServicio(Servicios.traerGetServicio2)
            configurarServicio(Servicios.traerGetServicio3)
            configurarServicio(Servicios.traerGetServicio4)

            ManejadorProxyRetrofitRx()
                .conEscuchadorInicioConsulta {
                    runOnUiThread { hola_mundo.isEnabled = false }
                    Log.e("Error","Inicio consultas")
                }
                .conInicioEscuchadorFinConsulta {
                    runOnUiThread { hola_mundo.isEnabled = true }
                    Log.e("Error","Fin consultas")
                }
                .conUrlBase("http://192.168.0.3:3000/")
                .adicionarConsulta(Servicios.traerGet){
                    objeto, codigoServidor ->
                    Log.e("Error","Servicios.traerGet")

                }
                .adicionarConsulta(Servicios.traerGetServicio1){
                    objeto, codigoServidor ->
                    Log.e("Error","Servicios.traerGetServicio1")

                }
                .adicionarConsulta(Servicios.traerGetServicio2){
                    objeto, codigoServidor ->
                    Log.e("Error","Servicios.traerGetServicio2")

                }
                .adicionarConsulta(Servicios.traerGetServicio3){
                    objeto, codigoServidor ->
                    Log.e("Error","Servicios.traerGetServicio3")

                }
                .adicionarConsulta(Servicios.traerGetServicio4){
                    objeto, codigoServidor ->
                    Log.e("Error","Servicios.traerGetServicio4")

                }
                .iniciarConsulta()

        }
    }

    private inner class tmpEnviar : IRetrofitParcelable{}
    private inner class tmpRecibir : IRetrofitParcelable{
        var codigo : String ?= null
        var mensaje : String ?= null
    }


    private fun configurarServicio(servicio : Servicios){
        servicio
            .conObjetoAEnviar(tmpEnviar())
            .conObjetoEsperado(tmpRecibir::class.java)
    }
}
