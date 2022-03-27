package com.mishelk.mvvm_project.data

data class Quote(
    val quoteTExt: String,
    val author: String)
{

    override fun toString(): String {
        return "$quoteTExt - $author"
    }

}