package com.mitiempo.toolkitandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.ProxyRetrofitRx
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hola_mundo.setOnClickListener {
            ProxyRetrofitRx()
                .conUrlBase("http://192.168.0.3:3000/")
                .conEscuchadorCodigoRespuesta {
                    Log.e("codigoRespuesta","codigo : ${it}")
                }
                .conEscuchadorFalla {
                    Log.e("Error","Fallo detalle : ",it)
                }
                .conEscuchadorRespuestaExitosa {
                    Log.e("Respuesta","buena .... ")
                }
                .conServicio(Servicios.traerGet)
                .realizarConsulta()
        }
    }
}
