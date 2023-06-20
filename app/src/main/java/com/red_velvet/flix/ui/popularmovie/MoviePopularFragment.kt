package com.red_velvet.flix.ui.popularmovie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentPopularMoviesBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviePopularFragment : BaseFragment<FragmentPopularMoviesBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_popular_movies
    override val viewModel: MoviePopularViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        val adapter = MoviePopularAdapter(emptyList(), viewModel)
        binding.recyclerView.adapter = adapter
    }
}