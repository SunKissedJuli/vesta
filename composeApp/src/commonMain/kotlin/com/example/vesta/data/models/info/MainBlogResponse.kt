package com.example.vesta.data.models.info

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class MainBlogResponse(
    @SerialName("akcii") val akcii: MainBlogObject?,
    @SerialName("akcii_slider") val akciiSlider: MainBlogObject?,
    @SerialName("novinki") val novinki: MainBlogObject?,
    @SerialName("novosti") val novosti: MainBlogObject?
)

@Serializable
class MainBlogObject(
    @SerialName("name") val name: String?,
    @SerialName("setting") val mainBlogObjectData: List<MainBlogObjectData>?
)

@Serializable
class MainBlogObjectData(
    @SerialName("blogarticle_id") val blogarticleId: Int?,
    @SerialName("blogarticle_name") val blogarticleName: String?,
    @SerialName("blogarticle_image") val blogarticleImage: String?,
)