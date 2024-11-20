package com.example.vesta.domain.modelsUI.info

data class MainBlogUi(
    val akcii: MainBlogObjectUi,
    val akciiSlider: MainBlogObjectUi,
    val novinki: MainBlogObjectUi,
    val novosti: MainBlogObjectUi
) {
    companion object {
        val empty = MainBlogUi(
            akcii = MainBlogObjectUi.empty,
            akciiSlider = MainBlogObjectUi.empty,
            novinki = MainBlogObjectUi.empty,
            novosti = MainBlogObjectUi.empty
        )
    }
}

data class MainBlogObjectUi(
    val name: String,
    val mainBlogObjectData: List<MainBlogObjectDataUi>
) {
    companion object {
        val empty = MainBlogObjectUi(
            name = "",
            mainBlogObjectData = emptyList()
        )
    }
}

data class MainBlogObjectDataUi(
    val blogarticleId: Int,
    val blogarticleImage: String,
    val blogarticleName: String,
) {
    companion object {
        val empty = MainBlogObjectDataUi(
            blogarticleId = 0,
            blogarticleImage = "",
            blogarticleName = "",
        )
    }
}
