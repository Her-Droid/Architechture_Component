package id.herdroid.moviecatalog.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import id.herdroid.moviecatalog.R
import id.herdroid.moviecatalog.data.DataEntity
import id.herdroid.moviecatalog.enum.TypeData
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
            val courseId = extras.getString(MOVIE_ID)
            if (courseId != null) {
                viewModel.setSelectedData(courseId)
                viewModel.getData()?.let { item ->
                    populateItem(item)
                }
            }
        }
    }

    private fun populateItem(data: DataEntity) {
        movie_detail.text = data.description
        movie_release_date.text = resources.getString(R.string.release_date, data.releaseDate)
        Glide.with(this).load(data.imagePath)
            .into(ivPoster)
    }

    companion object {
        const val MOVIE_ID = "id"
    }

}
