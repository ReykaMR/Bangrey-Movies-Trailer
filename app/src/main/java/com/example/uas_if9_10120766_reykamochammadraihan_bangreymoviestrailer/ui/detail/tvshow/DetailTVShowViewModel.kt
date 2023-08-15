package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.MovieRepository
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.response.ResponseTVShowDetail
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity.TVShowEntity
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.utils.Resource

class DetailTVShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTVShowDetail(id : String): LiveData<Resource<ResponseTVShowDetail>> {
        return movieRepository.getTVShowDetail(id)
    }

    fun addShowFavorite(show : TVShowEntity){
        movieRepository.insertTVShowDB(show)
    }

    fun deleteShowFavorite(id: String){
        movieRepository.deleteTVShowDB(id)
    }

    fun getShowFavorite(id: String) : TVShowEntity {
        return movieRepository.getTVShowByIdDB(id)
    }

    fun isShowFavorite(id: String) : LiveData<TVShowEntity> {
        return movieRepository.getTVShowByIdDBLiveData(id)
    }
}