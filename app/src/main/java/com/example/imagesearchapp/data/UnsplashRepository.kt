package com.example.imagesearchapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.imagesearchapp.api.UnsplashAPi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UnsplashRepository @Inject constructor(private val unsplashAPi: UnsplashAPi) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashAPi,query)}
        ).liveData
}