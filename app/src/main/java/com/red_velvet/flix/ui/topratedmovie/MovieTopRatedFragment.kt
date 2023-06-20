package com.red_velvet.flix.ui.topratedmovie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentTopRatedMoviesBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieTopRatedFragment : BaseFragment<FragmentTopRatedMoviesBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_top_rated_movies
    override val viewModel: MovieTopRatedViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        val adapter = MoviesTopRatedAdapter(emptyList(), viewModel)
        binding.recyclerView.adapter = adapter
    }
}