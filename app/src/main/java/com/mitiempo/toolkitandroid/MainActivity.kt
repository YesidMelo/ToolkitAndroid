package com.mitiempo.toolkitandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mitiempo.toolkitandroidclases.DataAccess.retrofit.IRetrofitParcelable
import com.mitiempo.toolkitandroidclases.Utilidades.Permisos.Permisos
import com.mitiempo.toolkitandroidclases.Utilidades.Permisos.SolicitantePermisos
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var solicitante_permisos : SolicitantePermisos ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hola_mundo.setOnClickListener {
            solicitante_permisos = SolicitantePermisos(this)
                .adicionarPermisoASolicitar(Permisos.CAMERA)
                .adicionarPermisoASolicitar(Permisos.ACCESS_FINE_LOCATION)
                .conEscuchadorTengoLosPermisosHabilitados{
                    Log.e("Error","tengo todos los permisos")
                }
                .conEscuchadorNoTengoLosPermisosHabilitados {
                    Log.e("Error","no tengo todos los permisos")
                }
                .solicitarPermisos()

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        solicitante_permisos?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
