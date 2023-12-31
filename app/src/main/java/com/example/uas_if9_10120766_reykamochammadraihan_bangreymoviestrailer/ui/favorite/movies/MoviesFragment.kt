package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.favorite.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.databinding.FragmentMoviesBinding
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.viewmodel.ViewModelFactory

class MoviesFragment : Fragment() {
    private lateinit var viewModel: MoviesViewModel
    private lateinit var fragmentMoviesBinding : FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

        val moviesAdapterPopular = MoviesPagedListAdapter()
        viewModel.getAllMovies().observe(viewLifecycleOwner,{ movies ->
            if(movies.isNotEmpty()){
                fragmentMoviesBinding.animationView.visibility = View.GONE
            } else {
                fragmentMoviesBinding.animationView.visibility = View.VISIBLE
            }
            moviesAdapterPopular.submitList(movies)
            moviesAdapterPopular.notifyDataSetChanged()
        })

        with(fragmentMoviesBinding.rvMovies) {
            layoutManager = GridLayoutManager(context,2)
            setHasFixedSize(true)
            adapter = moviesAdapterPopular
        }
    }
}