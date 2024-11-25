package com.example.vesta.data.models.info

fun CityResponse.toUI(): CityUi {
    return CityUi(
        storeId = storeId?:0,
        name = name.orEmpty(),
        url = url.orEmpty(),
        ssl = ssl.orEmpty(),
        phone = phone.orEmpty()
    )
}

fun List<CityResponse>.toUI(): List<CityUi> {
    return map { it.toUI() }
}

