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
    val mainBlogObjectData: MainBlogObjectDataUi
) {
    companion object {
        val empty = MainBlogObjectUi(
            name = "",
            mainBlogObjectData = MainBlogObjectDataUi.empty
        )
    }
}

data class MainBlogObjectDataUi(
    val blogCategories: List<String>,
    val blogs: List<BlogUi>,
    val category: String,
    val height: String,
    val limit: String,
    val limitDescription: String,
    val name: String,
    val order: String,
    val sort: String,
    val status: String,
    val title: String,
    val width: String
) {
    companion object {
        val empty = MainBlogObjectDataUi(
            blogCategories = emptyList(),
            blogs = emptyList(),
            category = "",
            height = "",
            limit = "",
            limitDescription = "",
            name = "",
            order = "",
            sort = "",
            status = "",
            title = "",
            width = ""
        )
    }
}

data class BlogUi(
    val blogarticleDescription: String,
    val blogarticleId: Int,
    val blogarticleImage: String,
    val blogarticleName: String,
    val blogarticleStatus: Int,
    val blogarticleViewed: Int,
    val blogcategoryId: Int,
    val blogcategoryMetaTitle: String,
    val blogcategoryName: String,
    val dateAdded: String,
    val storeId: Int
) {
    companion object {
        val empty = BlogUi(
            blogarticleDescription = "",
            blogarticleId = 0,
            blogarticleImage = "",
            blogarticleName = "",
            blogarticleStatus = 0,
            blogarticleViewed = 0,
            blogcategoryId = 0,
            blogcategoryMetaTitle = "",
            blogcategoryName = "",
            dateAdded = "",
            storeId = 0
        )
    }
}