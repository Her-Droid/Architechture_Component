package id.herdroid.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import id.herdroid.moviecatalog.data.DataEntity
import id.herdroid.moviecatalog.utils.DataDummy

class MovieViewModel : ViewModel(){
    fun getMovies(): List<DataEntity> {
        return DataDummy.dummyMovies()
    }
}