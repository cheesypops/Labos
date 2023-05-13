package com.example.laboratorio5viana.ui.movie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio5viana.MovieReviewerApplication
import com.example.laboratorio5viana.data.models.MovieModel
import com.example.laboratorio5viana.data.qualification
import com.example.laboratorio5viana.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMovies() = repository.getMovies()
    private fun addMovies(movie: MovieModel) = repository.addMovie(movie)

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createMovies(){
        if(!validateData()){
            status.value = WRONG_DATA

            return
        }
        val newMovie = MovieModel(
            name.value.toString(),
            category.value.toString(),
            description.value.toString(),
            qualification.value.toString()
        )
        addMovies(newMovie)
        status.value = MOVIE_CREATED

    }

    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    fun clearstatus(){
        status.value = BASE_STATE
    }

    fun setSelectedMovie(movie: MovieModel){
        name.value = movie.name
        category.value = movie.category
        description.value = movie.description
        qualification.value = movie.qualification
    }

    companion object{

        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED ="Movie created"
        const val WRONG_DATA = "Wrong data"
        const val BASE_STATE = ""
    }
}