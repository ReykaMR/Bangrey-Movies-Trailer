@file:Suppress("UNUSED_PARAMETER")

package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.di

import android.content.Context
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.LocalDataSource
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.MovieRepository
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.data.RemoteDataSource
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.MovieDatabase

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val database = MovieDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao())

        return MovieRepository.getInstance(remoteDataSource, localDataSource)
    }
}