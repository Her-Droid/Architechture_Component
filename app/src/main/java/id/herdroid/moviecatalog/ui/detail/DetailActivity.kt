package id.herdroid.moviecatalog.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import id.herdroid.moviecatalog.R
import id.herdroid.moviecatalog.data.DataEntity
import id.herdroid.moviecatalog.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_movies.*
import kotlinx.android.synthetic.main.list_movies.movie_description
import kotlinx.android.synthetic.main.list_movies.view.*

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

      intent.extras?.let{
          val id = it.getLong(MOVIE_ID)
          viewModel.id = id.toString()
          viewModel.getData()?.let { data ->
              populateItem(data)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
}
