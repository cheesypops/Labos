package com.example.laboratorio5viana.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio5viana.data.models.MovieModel
import com.example.laboratorio5viana.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(Movie: MovieModel, clickListener: (MovieModel)->Unit){
        binding.tittleMovie.text = Movie.name
        binding.score.text = Movie.qualification

        binding.movieCard.setOnClickListener{
            clickListener(Movie)
        }
    }
}