package com.akshit.clunochallenge.model

data class ClunoCarDetailResponse(
    val car: Car,
    val images: List<Image>,
    val pricing: Pricing
)

data class Car(
    val make: String,
    val model: String,
    val version: String,
    val engine: String,
    val kw: Int,
    val ps: Int,
    val doors: String,
    val drive: String,
    val fueltype: String,
    val gearingType: String,
    val offerExtColor: String
)

data class Image(
    val title: String,
    val src: String
)

data class Pricing(
    val price: Int,
    val startingFee: Int,
    val deliveryFee: Int,
    val currencySymbol: String
)