package id.herdroid.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import id.herdroid.moviecatalog.data.DataEntity
import id.herdroid.moviecatalog.enum.TypeData
import id.herdroid.moviecatalog.utils.DataDummy
import id.herdroid.moviecatalog.utils.DataDummy.dummyMovies
import id.herdroid.moviecatalog.utils.DataDummy.dummyTvShows

class DetailViewModel :ViewModel() {
    var type: TypeData = TypeData.MOVIES
    private lateinit var movId: String

    fun setSelectedData(courseId: String) {
        this.movId = courseId
    }

    fun getData(): DataEntity? {
        val dataEntities = if (type == TypeData.MOVIES) DataDummy.dummyMovies() else DataDummy.dummyTvShows()
        for (element in dataEntities) {
            val item = element
            if (item.movieId == movId) {
                return item
            }
        }
        return null
    }

}
