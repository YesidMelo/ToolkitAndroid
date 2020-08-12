package com.mitiempo.toolkitandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mitiempo.toolkitpasarelaspago.epayco.ManejadorEpayco
import com.mitiempo.toolkitpasarelaspago.epayco.Utilidades.Autenticacion
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hola_mundo.setOnClickListener {
            ManejadorEpayco()
                .conApikeyPrivado("")
                .conApikeyPublico("")
                .esPrueba(true)
                .conIdioma("ES")
                .conEscuchadorFalla {
                    Log.e("Error","",it)
                }
                .generarEpayco {
                    Log.e("Error","Genero epayco")
                }
        }
    }
}
