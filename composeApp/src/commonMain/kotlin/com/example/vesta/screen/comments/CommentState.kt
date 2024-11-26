package com.example.vesta.screen.comments

import com.example.vesta.domain.modelsUI.blog.BlogByIdUi

data class CommentState(
    val newsData: BlogByIdUi,
){
    companion object{
        val InitState = CommentState(
            newsData = BlogByIdUi.empty
        )
    }
}
