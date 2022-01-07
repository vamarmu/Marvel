package com.vamarmu.domain

data class MarvelImage(
    val path : String?,
    val extension: String?
)

enum class AspectRatioImage{
    portrait_small,
    portrait_medium	,
    portrait_xlarge,
    portrait_fantastic,
    portrait_uncanny,
    portrait_incredible,
    standard_small,
    standard_medium,
    standard_large,
    standard_xlarge,
    standard_fantastic,
    standard_amazing,
    landscape_small,
    landscape_medium,
    landscape_large,
    landscape_xlarge,
    landscape_amazing,
    landscape_incredible
}
