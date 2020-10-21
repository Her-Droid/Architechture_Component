package id.herdroid.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import id.herdroid.moviecatalog.data.TvShowEntity
import id.herdroid.moviecatalog.utils.DataDummy

class TvShowViewModel : ViewModel(){
    fun getTvShows(): List<TvShowEntity>{
        return DataDummy.dummyTvShows()
    }
}