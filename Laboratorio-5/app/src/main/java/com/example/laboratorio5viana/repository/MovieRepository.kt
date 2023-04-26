package com.example.laboratorio5viana.repository

import com.example.laboratorio5viana.data.models.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies
    fun addMovie(newMovie: MovieModel) = movies.add(newMovie)
}