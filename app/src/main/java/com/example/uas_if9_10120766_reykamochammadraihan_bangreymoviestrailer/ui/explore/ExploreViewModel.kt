package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.MovieRepository
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.response.ResultMovies
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.response.ResultTVShow
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.utils.Resource

class ExploreViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMoviesSearch(keyword : String): LiveData<Resource<List<ResultMovies>>> {
        return movieRepository.getMoviesSearch(keyword)
    }

    fun getShowSearch(keyword : String): LiveData<Resource<List<ResultTVShow>>> {
        return movieRepository.getShowSearch(keyword)
    }
}