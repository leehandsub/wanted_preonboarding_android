package com.example.wanted_pre_onboarding_android.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "article"
)

data class Article(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val author: String,
    val title: String,
    //val description: String,
    //val url: String,
    @ColumnInfo(name = "url_to_image") val urlToImage: String,
    @ColumnInfo(name = "published_at") val publishedAt: String,
    val content: String,
    val like: Boolean = false,
)
