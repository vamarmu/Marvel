package com.vamarmu.marvel.data.remote.models

import com.google.gson.annotations.SerializedName


data class CharacterResponse (
    /**
     * The unique ID of the character resource.
     */
    @SerializedName("id")
    val id : Int?,

    /**
     * The name of the character.
     */
    @SerializedName("name")
    val name :String?,

    /**
     * A short bio or description of the character.,
     */
    @SerializedName("description")
    val description:String?,

    /**
     *  The representative image for this character.
     */
    @SerializedName("thumbnail")
    val thumbnail : ImageResponse?,

    /**
     * The canonical URL identifier for this resource.
     */
    @SerializedName("resourceUri")
    val resourceUri : String?,

    @SerializedName("comics")
    val comics : ResourceListResponse,

    @SerializedName("stories")
    val stories : ResourceListResponse,

    @SerializedName("events")
    val events : ResourceListResponse,

    @SerializedName("series")
    val series : ResourceListResponse,

    )


data class ResourceListResponse (
    @SerializedName("available")
    val available : Int?,
    @SerializedName("returned")
    val returned : Int?,
    @SerializedName("collectionURI")
    val collectionURI : String?,
    @SerializedName("items")
    val items : List<ResourceSummaryResponse>?
)


data class ResourceSummaryResponse(
    @SerializedName("resourceUri")
    val resourceUri: String?,
    @SerializedName("name")
    val name :String?,
    @SerializedName("type")
    val type : String? = null
)

