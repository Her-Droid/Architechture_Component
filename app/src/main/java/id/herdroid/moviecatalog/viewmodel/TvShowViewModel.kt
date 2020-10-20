package id.herdroid.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import id.herdroid.moviecatalog.data.DataEntity
import id.herdroid.moviecatalog.utils.DataDummy

class TvShowViewModel : ViewModel(){
    fun getTvShows(): List<DataEntity>{
        return DataDummy.dummyTvShows()
    }
}