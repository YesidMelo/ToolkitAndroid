package com.mitiempo.toolkitandroidclases.Utilidades.Permisos

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SolicitantePermisos(private val context: Context) {

    private var EscuchadorNoTengoLosPermisosHabilitados : (()->Unit) ?= null
    fun conEscuchadorNoTengoLosPermisosHabilitados(EscuchadorNoTengoLosPermisosHabilitados : (()->Unit)) : SolicitantePermisos{
        this.EscuchadorNoTengoLosPermisosHabilitados = EscuchadorNoTengoLosPermisosHabilitados
        return this
    }

    private var EscuchadorTengoLosPermisosHabilitados : (()->Unit) ?= null
    fun conEscuchadorTengoLosPermisosHabilitados(EscuchadorTengoLosPermisosHabilitados : (()->Unit)) : SolicitantePermisos{
        this.EscuchadorTengoLosPermisosHabilitados = EscuchadorTengoLosPermisosHabilitados
        return this
    }

    private var permisosASolicitarUsuario = emptyList<Permisos>().toMutableList()
    fun adicionarPermisoASolicitar(permiso : Permisos) : SolicitantePermisos{
        this.permisosASolicitarUsuario.add(permiso)
        return this
    }

    fun solicitarPermisos(){

        if (permisosASolicitarUsuario.isEmpty()){ return }

        if (tengoTodosLosPermisosDelUsuarioHabilitados()){
            EscuchadorTengoLosPermisosHabilitados?.invoke()
            return
        }

        solicitarPermisosFaltantes()


    }

//    region verificar permisos faltantes
    private var listaASolicitar = emptyArray<Permisos>().toMutableList()
    private fun tengoTodosLosPermisosDelUsuarioHabilitados() : Boolean{
        for(permiso in permisosASolicitarUsuario){

            if(tengoEstePermisoHabilitado(permiso)){
                continue
            }

            listaASolicitar.add(permiso)

        }
        return listaASolicitar.isEmpty()
    }

    private fun tengoEstePermisoHabilitado(permiso: Permisos) : Boolean{
        return ContextCompat.checkSelfPermission(context,permiso.traerNombrePermisoManifiest()) == PackageManager.PERMISSION_GRANTED
    }

//    endregion


    private fun solicitarPermisosFaltantes(){

        val listaString = emptyArray<String>().toMutableList()
        listaASolicitar.forEach {
            permiso ->
            listaString.add(permiso.traerNombrePermisoManifiest())
        }

        ActivityCompat.requestPermissions(context as AppCompatActivity,listaString.toTypedArray(),Permisos.ACCESS_FINE_LOCATION.traerRequestCode())
    }


}