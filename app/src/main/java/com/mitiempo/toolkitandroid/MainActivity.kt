package com.mitiempo.toolkitandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.IRetrofitParcelable
import com.mitiempo.toolkitandroidclases.Utilidades.Permisos.Permisos
import com.mitiempo.toolkitandroidclases.Utilidades.Permisos.SolicitantePermisos
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hola_mundo.setOnClickListener {
            SolicitantePermisos(this)
                .adicionarPermisoASolicitar(Permisos.CAMERA)
                .adicionarPermisoASolicitar(Permisos.ACCESS_FINE_LOCATION)
                .conEscuchadorTengoLosPermisosHabilitados{

                }
                .conEscuchadorNoTengoLosPermisosHabilitados {

                }
                .solicitarPermisos()

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
