package com.vamarmu.marvel.data.remote.models

import com.google.gson.annotations.SerializedName

data class DataWrapperResponse<T> (

    /**
     * The HTTP status code of the returned result.
     */
    @SerializedName("code")
    val code : Int?,

    /**
     * A string description of the call status.
     */
    @SerializedName("status")
    val status :String?,

    /**
     * The copyright notice for the returned result.,
     */
    @SerializedName("copyright")
    val copyright:String?,

    /**
     * The attribution notice for this result.
     * Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.
     */
    @SerializedName("attributionText")
    val attributionText : String?,

    /**
     * The results returned by the call.
     */
    @SerializedName("data")
    val data : DataContainerResponse<T>?

)


