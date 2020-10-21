package id.herdroid.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import id.herdroid.moviecatalog.data.MovieEntity
import id.herdroid.moviecatalog.data.TvShowEntity
import id.herdroid.moviecatalog.enum.TypeData
import id.herdroid.moviecatalog.utils.DataDummy

class DetailViewModel :ViewModel() {
    var typeMovie: TypeData = TypeData.MOVIES
    var typeTV: TypeData = TypeData.TV_SHOWS
    private lateinit var movId: String

    fun setSelectedData(courseId: String) {
        this.movId = courseId
    }

    fun getMovie(): MovieEntity? {
        val dataEntities =  DataDummy.dummyMovies()
        for (element in dataEntities) {
            if (element.movieId == movId) {
                return element
            }
        }
        return null
    }

    fun getTv(): TvShowEntity? {
        val dataEntities =  DataDummy.dummyTvShows()
        for (element in dataEntities) {
            if (element.tvShowId == movId) {
                return element
            }
        }
        return null
    }
}
