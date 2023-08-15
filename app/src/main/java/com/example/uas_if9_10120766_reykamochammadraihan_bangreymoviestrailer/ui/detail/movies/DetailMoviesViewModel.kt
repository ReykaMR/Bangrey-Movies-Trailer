package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.detail.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.MovieRepository
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.response.ResponseMovieDetail
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity.MovieEntity
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.utils.Resource

class DetailMoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovieDetail(id : String): LiveData<Resource<ResponseMovieDetail>> {
        return movieRepository.getMovieDetail(id)
    }

    fun addMovieFavorite(movie : MovieEntity){
        movieRepository.insertMoviesDB(movie)
    }

    fun deleteMovieFavorite(id: String){
        movieRepository.deleteMoviesDB(id)
    }

    fun getMovieFavorite(id: String) : MovieEntity {
        return movieRepository.getMoviesByIdDB(id)
    }

    fun isMovieFavorite(id: String) : LiveData<MovieEntity> {
        return movieRepository.getMoviesByIdDBLiveData(id)
    }
}