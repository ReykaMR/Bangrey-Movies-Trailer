package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.MovieRepository
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity.TVShowEntity

class TVShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getAllTVShow() : LiveData<PagedList<TVShowEntity>> = LivePagedListBuilder(movieRepository.getAllTVShowDB(), 4).build()
}