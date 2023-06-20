package com.red_velvet.flix.ui.nowplayingmovie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentNowPlayingMoviesBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesNowPlayingFragment : BaseFragment<FragmentNowPlayingMoviesBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_now_playing_movies
    override val viewModel: PlayingNowViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        val adapter = MoviesNowPlayingAdapter(emptyList(), viewModel)
        binding.recyclerView.adapter = adapter
    }
}