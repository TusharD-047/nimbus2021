package com.codewithroronoa.crypto.markets

data class mark(val markets: ArrayList<marketsAll>)
data class marketsAll(
    val exchange_id : String,
    val symbol: String,
    val price_unconverted : Float,
    val price: Float,
    val change_24h: Float,
    val spread : Float,
    val volume_24h: Double
    ) {
}