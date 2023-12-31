package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.detail.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.databinding.FragmentDetailTvshowBinding
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity.TVShowEntity
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.detail.GenreAdapter
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.utils.EspressoIdlingResource
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.utils.Resource
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.R
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.viewmodel.ViewModelFactory

class DetailTVShowFragment(idContent: String?) : Fragment() {
    private var idContent : String = idContent.toString()
    private lateinit var viewModel: DetailTVShowViewModel
    private lateinit var fragmentDetailTVShowBinding: FragmentDetailTvshowBinding
    private lateinit var tvShowEntity: TVShowEntity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        fragmentDetailTVShowBinding = FragmentDetailTvshowBinding.inflate(layoutInflater, container, false)
        return fragmentDetailTVShowBinding.root
    }

    override fun onResume() {
        super.onResume()
        fragmentDetailTVShowBinding.shimmerFrameLayout.startShimmer()
    }

    override fun onPause() {
        fragmentDetailTVShowBinding.shimmerFrameLayout.stopShimmer()
        super.onPause()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[DetailTVShowViewModel::class.java]
        val genreAdapter = GenreAdapter()
        EspressoIdlingResource.increment()
        viewModel.getTVShowDetail(idContent).observe(viewLifecycleOwner, { tv ->
            EspressoIdlingResource.decrement()
            if (tv.status == Resource.Status.SUCCESS) {
                tvShowEntity = TVShowEntity(idContent, tv.data?.name!!, "https://image.tmdb.org/t/p/w500" + tv.data?.posterPath)
                fragmentDetailTVShowBinding.shimmerFrameLayout.stopShimmer()
                fragmentDetailTVShowBinding.shimmerFrameLayout.visibility = View.GONE
                fragmentDetailTVShowBinding.containerDetailTvshow.visibility = View.VISIBLE
                context?.let {
                    Glide.with(it)
                            .load("https://image.tmdb.org/t/p/w500" + tv.data?.posterPath)
                            .centerCrop()
                            .transform(RoundedCorners(16))
                            .into(fragmentDetailTVShowBinding.imgDetailShow)
                }
                genreAdapter.setGenre(tv.data?.genres)
                genreAdapter.notifyDataSetChanged()
                fragmentDetailTVShowBinding.tvTitleShow.text = tv.data?.name
                fragmentDetailTVShowBinding.tvTaglineShow.text = tv.data?.tagline
                fragmentDetailTVShowBinding.ratingBarShow.rating = (tv.data?.voteAverage?.div(2))?.toFloat()!!
                fragmentDetailTVShowBinding.tvReleasedShow.text = tv.data?.firstAirDate
                fragmentDetailTVShowBinding.tvHomepageShow.text = tv.data?.homepage
                fragmentDetailTVShowBinding.tvOverviewShow.text = tv.data?.overview
            } else if (tv.status == Resource.Status.ERROR) {
                Toast.makeText(context, "Error : " + tv.message, Toast.LENGTH_LONG).show()
            }
        })

        with(fragmentDetailTVShowBinding.rvGenreShow) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = genreAdapter
        }

        checkIsFavorite()
        fragmentDetailTVShowBinding.fabFavoriteTvshow.setOnClickListener {
            @Suppress("SENSELESS_COMPARISON")
            if(viewModel.getShowFavorite(idContent) == null){
                viewModel.addShowFavorite(tvShowEntity)
                Toast.makeText(requireContext(), "Added To Favorite", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteShowFavorite(idContent)
                Toast.makeText(requireContext(), "Deleted From Favorite", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkIsFavorite(){
        viewModel.isShowFavorite(idContent).observe(viewLifecycleOwner, { movies ->
            if(movies == null){
                fragmentDetailTVShowBinding.fabFavoriteTvshow.setImageResource(R.drawable.ic_baseline_favorite_border_24dp)
            } else {
                fragmentDetailTVShowBinding.fabFavoriteTvshow.setImageResource(R.drawable.ic_baseline_favorite_24dp)
            }
        })
    }
}