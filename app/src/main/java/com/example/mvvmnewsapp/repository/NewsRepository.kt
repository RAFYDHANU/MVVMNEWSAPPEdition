package com.example.mvvmnewsapp.repository

import com.example.mvvmnewsapp.database.ArticleDatabase
import com.example.mvvmnewsapp.model.Article
import com.example.mvvmnewsapp.network.RetrofitInstance

class NewsRepository (val db:ArticleDatabase) {

    //get semua data untuk di tampilkan di fragment breaking news
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun serachNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    //membuat database baru di lokal database
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    //untuk get semua data yang sudah di bookmark
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    //delete database lokal
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}
