package com.example.vesta.data.mapper

import com.example.vesta.data.models.CategoryResponse
import com.example.vesta.data.models.OctStickerData
import com.example.vesta.data.models.OctStickers
import com.example.vesta.data.models.SpecialStickerData
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.OctStickerDataUi
import com.example.vesta.domain.modelsUI.OctStickersUi
import com.example.vesta.domain.modelsUI.SpecialStickerDataUi

fun OctStickers.toUI(): OctStickersUi {
    return OctStickersUi(
        stickerData = stickerData?.toUI()?: OctStickerDataUi.empty,
        specialStickerData = specialStickerData?.toUI()?: SpecialStickerDataUi.empty
    )
}

fun OctStickerData.toUI(): OctStickerDataUi {
    return OctStickerDataUi(
        fonColor = fonColor.orEmpty(),
        link = link.orEmpty(),
        sort = sort.orEmpty(),
        textColor = textColor.orEmpty(),
        title = title.orEmpty()
    )
}

fun SpecialStickerData.toUI(): SpecialStickerDataUi {
    return SpecialStickerDataUi(
        fonColor = fonColor.orEmpty(),
        viewTitle = viewTitle.orEmpty(),
        sort = sort.orEmpty(),
        textColor = textColor.orEmpty(),
        title = title.orEmpty()
    )
}