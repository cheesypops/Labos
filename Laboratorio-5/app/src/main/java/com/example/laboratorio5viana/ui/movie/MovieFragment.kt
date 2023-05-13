package com.example.laboratorio5viana.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.laboratorio5viana.R
import com.example.laboratorio5viana.data.movies
import com.example.laboratorio5viana.databinding.FragmentBillboardBinding
import com.example.laboratorio5viana.databinding.FragmentMovieBinding
import com.example.laboratorio5viana.repository.MovieRepository
import com.example.laboratorio5viana.ui.movie.viewmodel.MovieViewModel


class MovieFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = viewModel
    }
}