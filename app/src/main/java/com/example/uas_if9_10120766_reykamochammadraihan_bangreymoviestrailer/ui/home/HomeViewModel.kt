package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.MovieRepository
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.response.ResultMovies
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.response.ResultTVShow
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.utils.Resource

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMoviesPopular(): LiveData<Resource<List<ResultMovies>>> {
        return movieRepository.getMoviesPopular()
    }

    fun getTVShowPopular(): LiveData<Resource<List<ResultTVShow>>> {
        return movieRepository.getTVShowPopular()
    }
}