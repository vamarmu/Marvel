package com.vamarmu.marvel.data.remote.models

import com.google.gson.annotations.SerializedName

data class  DataContainerResponse<T>(
    /**
     * The requested offset (number of skipped results) of the call.
     */
    @SerializedName("offset")
    var offset : Int? ,

    /**
     * The requested result limit.
     */
    @SerializedName("limit")
    var limit :Int?,

    /**
     * The total number of resources available given the current filter set.
     */
    @SerializedName("total")
    var total : Int?,

    /**
     * The total number of results returned by this call.
     */
    @SerializedName("count")

    var count: Int?,
    /**
     * The list of characters returned by the call.
     */
    @SerializedName("results")
    var results : List<T>
)
