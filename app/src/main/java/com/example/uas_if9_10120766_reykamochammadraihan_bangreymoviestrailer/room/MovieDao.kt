package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity.MovieEntity
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity.TVShowEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM moviesentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: MovieEntity)

    @Query("SELECT * FROM moviesentities WHERE movieId = :movieId")
    fun getMoviesById(movieId: String): MovieEntity

    @Query("SELECT * FROM moviesentities WHERE movieId = :movieId")
    fun getMoviesByIdDBLiveData(movieId: String): LiveData<MovieEntity>

    @Query("DELETE FROM moviesentities WHERE movieId = :movieId")
    fun deleteMovies(movieId: String)

    @Query("SELECT * FROM tvshowentities")
    fun getTVShow(): DataSource.Factory<Int, TVShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShow(show: TVShowEntity)

    @Query("SELECT * FROM tvshowentities WHERE showId = :showId")
    fun getTVShowById(showId: String): TVShowEntity

    @Query("SELECT * FROM tvshowentities WHERE showId = :showId")
    fun getTVShowByIdDBLiveData(showId: String): LiveData<TVShowEntity>

    @Query("DELETE FROM tvshowentities WHERE showId = :showId")
    fun deleteTVShow(showId: String)
}