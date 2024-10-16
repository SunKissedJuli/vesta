package com.example.vesta.data.models.info

fun SityResponse.toUI(): SityUi {
    return SityUi(
        storeId = storeId?:0,
        name = name.orEmpty(),
        url = url.orEmpty(),
        ssl = ssl.orEmpty(),
    )
}

fun List<SityResponse>.toUI(): List<SityUi> {
    return map { it.toUI() }
}

