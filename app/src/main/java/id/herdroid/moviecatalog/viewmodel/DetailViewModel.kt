package id.herdroid.moviecatalog.viewmodel
import androidx.lifecycle.ViewModel
import id.herdroid.moviecatalog.data.DataEntity
import id.herdroid.moviecatalog.enum.TypeData
import id.herdroid.moviecatalog.utils.DataDummy

class DetailViewModel :ViewModel() {
    var type: TypeData = TypeData.MOVIES
    lateinit var id: String


    fun getData(): DataEntity? {
        val list =
            if (type == TypeData.MOVIES) DataDummy.dummyMovies() else DataDummy.dummyTvShows()
        for (i in 0 until list.size) {
            val item = list[i]
            if (item.movieId == id) {
                return item
            }
        }
        return null
    }
}
