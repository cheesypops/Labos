package com.example.laboratorio5viana.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.laboratorio5viana.R
import com.example.laboratorio5viana.data.models.MovieModel
import com.example.laboratorio5viana.databinding.FragmentCreateMovieBinding
//import com.example.laboratorio5viana.databinding.FragmentMovieBinding


class CreateMovieFragment : Fragment() {

    private lateinit var binding: FragmentCreateMovieBinding

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setviewModel()
        setObserver()
    }

    private fun setviewModel(){
        binding.viewmodel = viewModel
    }

    private fun setObserver(){
        viewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("TAG_APP", status)
                    Log.d("TAG_APP", viewModel.getMovies().toString())

                    viewModel.clearstatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }

                status.equals((MovieViewModel.WRONG_DATA)) -> {
                    Log.d("TAG_APP", status)
                    viewModel.clearstatus()
                }
            }
        }
    }



}