package id.herdroid.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import id.herdroid.moviecatalog.data.MovieEntity
import id.herdroid.moviecatalog.utils.DataDummy

class MovieViewModel : ViewModel(){
    fun getMovies(): List<MovieEntity> {
        return DataDummy.dummyMovies()
    }
}