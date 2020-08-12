package com.mitiempo.toolkitandroidclases.DataAccess.retrofit

import io.reactivex.Observable
import retrofit2.http.*

interface TraerDatos {

    @GET
    fun getData(@Url ruta : String) : Observable<Any>

    @POST
    fun postData(@Url ruta : String) : Observable<Any>

    @PUT
    fun putData(@Url ruta : String) : Observable<Any>

    @DELETE
    fun deleteData(@Url ruta : String) : Observable<Any>

    @OPTIONS
    fun optionsData(@Url ruta : String) : Observable<Any>



}