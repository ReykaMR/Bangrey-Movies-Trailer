package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.favorite.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.MovieRepository
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity.MovieEntity

class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getAllMovies() : LiveData<PagedList<MovieEntity>> = LivePagedListBuilder(movieRepository.getAllMoviesDB(), 4).build()

}