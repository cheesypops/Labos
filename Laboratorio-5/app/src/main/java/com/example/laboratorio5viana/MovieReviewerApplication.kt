package com.example.laboratorio5viana

import android.app.Application
import com.example.laboratorio5viana.data.movies
import com.example.laboratorio5viana.repository.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy{
        MovieRepository(movies)
    }
}