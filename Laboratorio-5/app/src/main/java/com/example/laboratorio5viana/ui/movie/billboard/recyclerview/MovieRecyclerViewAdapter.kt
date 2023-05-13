package com.example.laboratorio5viana.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio5viana.data.models.MovieModel
import com.example.laboratorio5viana.databinding.MovieItemBinding

class MovieRecyclerViewAdapter (private val clickListener: (MovieModel) -> Unit) :
    RecyclerView.Adapter<MovieRecyclerViewHolder>(){

    private val movies = ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    //funcion pa actualizar la info
    fun setData(MoviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(MoviesList)
    }
}