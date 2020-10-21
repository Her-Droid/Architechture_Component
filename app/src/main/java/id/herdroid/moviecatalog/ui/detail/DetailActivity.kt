package id.herdroid.moviecatalog.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import id.herdroid.moviecatalog.R
import id.herdroid.moviecatalog.data.MovieEntity
import id.herdroid.moviecatalog.data.TvShowEntity
import id.herdroid.moviecatalog.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(MOVIE_ID)
            if (movieId != null) {
                viewModel.setSelectedData(movieId)
                viewModel.getMovie()?.let { item ->
                    populateItem(item)
                }
            }
            else{
                val tvshowId = extras.getString(TVSHOW_ID)
                if (tvshowId != null) {
                    viewModel.setSelectedData(tvshowId)
                    viewModel.getTv()?.let { item ->
                        populateItem(item)
                    }
                }
            }
        }
    }

    private fun populateItem(data: MovieEntity) {
        movie_detail.text = data.description
        movie_release_date.text = resources.getString(R.string.release_date, data.releaseDate)
        Glide.with(this).load(data.imagePath)
            .into(ivPoster)
    }

    private fun populateItem(data: TvShowEntity) {
        movie_detail.text = data.description
        movie_release_date.text = resources.getString(R.string.release_date, data.releaseDate)
        Glide.with(this).load(data.imagePath)
                .into(ivPoster)
    }

    companion object {
        const val MOVIE_ID = "movie_id"
        const val TVSHOW_ID = "tvshow_id"
    }

}
