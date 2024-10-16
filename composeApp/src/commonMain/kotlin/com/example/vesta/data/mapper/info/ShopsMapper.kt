package com.example.vesta.data.models.info

import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.models.CategoryById
import com.example.vesta.data.models.Link
import com.example.vesta.domain.modelsUI.CategoryByIdUi
import com.example.vesta.domain.modelsUI.LinkUi
import com.example.vesta.domain.modelsUI.info.ShopsUi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

fun ShopsResponse.toUI(): ShopsUi {
    return ShopsUi(
        active = active ?: 0,
        address = address.orEmpty(),
        coordinates = coordinates.orEmpty(),
        isWholesale = isWholesale ?: 0,
        map = map.orEmpty(),
        name = name.orEmpty(),
        phoneNumber = phoneNumber.orEmpty(),
        shopId = shopId ?: 0,
        storeId = storeId ?: 0,
        workingHours = workingHours.orEmpty()
    )
}

fun List<ShopsResponse>.toUI(): List<ShopsUi> {
    return map { it.toUI() }
}

