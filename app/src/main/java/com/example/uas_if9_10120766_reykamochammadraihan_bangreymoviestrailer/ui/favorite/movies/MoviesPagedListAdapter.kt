package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.favorite.movies

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.databinding.ItemMoviesFavoriteBinding
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity.MovieEntity
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.detail.DetailActivity

class MoviesPagedListAdapter :
    PagedListAdapter<MovieEntity, MoviesPagedListAdapter.MoviesViewHolder>(DIFF_CALLBACK)  {
    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieEntity> = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(old: MovieEntity, new: MovieEntity): Boolean {
                return old.movieId == new.movieId
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(old: MovieEntity, new: MovieEntity): Boolean {
                return old == new
            }
        }
    }

    inner class MoviesViewHolder(private val binding: ItemMoviesFavoriteBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movies : MovieEntity){
            with(binding){
                tvItemNameMovies.text = movies.movieTitle
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + movies.moviePoster)
                    .centerCrop()
                    .transform(RoundedCorners(16))
                    .into(imgPosterMovies)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.ID_CONTENT, movies.movieId)
                    intent.putExtra(DetailActivity.TYPE_CONTENT, DetailActivity.TYPE_MOVIES)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemMoviesFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(getItem(position) as MovieEntity)
    }

}