package com.red_velvet.flix.ui.upcomingmovies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentUpComingBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesUpComingFragment : BaseFragment<FragmentUpComingBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_up_coming
    override val viewModel: UpComingViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        val adapter = MoviesUpComingAdapter(emptyList(), viewModel)
        binding.recyclerView.adapter = adapter
    }
}