package com.example.vesta.data.mapper.user

import com.example.vesta.data.models.Link
import com.example.vesta.data.models.user.CurrentUser
import com.example.vesta.data.models.user.TokenResponse
import com.example.vesta.domain.modelsUI.LinkUi
import com.example.vesta.domain.modelsUI.user.CurrentUserUi
import com.example.vesta.domain.modelsUI.user.TokenUi

fun CurrentUser.toUI(): CurrentUserUi {
    return CurrentUserUi(
        addressId = address_id ?: 0,
        bonusCard = bonus_card.orEmpty(),
        cart = cart.orEmpty(),
        code = code.orEmpty(),
        customField = custom_field.orEmpty(),
        customerGroupId = customer_group_id ?: 0,
        customerId = customer_id ?: 0,
        dateAdded = date_added.orEmpty(),
        email = email.orEmpty(),
        fax = fax.orEmpty(),
        firstName = firstname.orEmpty(),
        ip = ip.orEmpty(),
        languageId = language_id ?: 1,
        lastName = lastname.orEmpty(),
        middleName = middlename.orEmpty(),
        newsletter = newsletter ?: 0,
        password = password.orEmpty(),
        priorityPickupId = priority_pickup_id ?: 0,
        safe = safe ?: 0,
        salt = salt.orEmpty(),
        status = status ?: 0,
        storeId = store_id ?: 0,
        telephone = telephone.orEmpty(),
        token = token.orEmpty()
    )
}