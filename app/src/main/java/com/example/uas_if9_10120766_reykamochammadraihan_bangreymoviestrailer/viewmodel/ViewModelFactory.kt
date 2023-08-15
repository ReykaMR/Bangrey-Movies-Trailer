package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.MovieRepository
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.di.Injection
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.detail.movies.DetailMoviesViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.detail.tvshow.DetailTVShowViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.explore.ExploreViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.favorite.movies.MoviesViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.favorite.tvshow.TVShowViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.home.HomeViewModel

class ViewModelFactory private constructor(private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(ExploreViewModel::class.java) -> {
                ExploreViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                TVShowViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMoviesViewModel::class.java) -> {
                DetailMoviesViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailTVShowViewModel::class.java) -> {
                DetailTVShowViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}