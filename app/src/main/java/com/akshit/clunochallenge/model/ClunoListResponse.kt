package com.akshit.clunochallenge.model

class ClunoListResponse {
    var items: List<ClunoListItem> = listOf()
}

data class ClunoListItem(
    val id: String,
    val car: CarItem,
    val teaser: CarItemTeaser,
    val pricing: CarItemPricing
)

data class CarItem(
    val make: String,
    val model: String
)

data class CarItemTeaser(val teaserImage: String)

data class CarItemPricing(
    val price: Int,
    val currencySymbol: String
)
