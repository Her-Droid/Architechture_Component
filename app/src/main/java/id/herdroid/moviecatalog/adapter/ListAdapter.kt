package id.herdroid.moviecatalog.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.herdroid.moviecatalog.R
import id.herdroid.moviecatalog.data.DataEntity
import id.herdroid.moviecatalog.enum.TypeData
import id.herdroid.moviecatalog.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.list_movies.view.*
import android.util.Log.i as i1

class ListAdapter (private val context: Context, private var data: List<DataEntity>, private val type: TypeData):
        RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    companion object{
        private const val TAG = "DetailActivity"
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data: DataEntity) {
            itemView.run {
                data.also {
                    Glide.with(itemView.context).load(data.imagePath)
                            .into(iv_movies)
                    movie_title.text = it.title
                    movie_description.text = it.description
                    movie_date.text = itemView.resources.getString(R.string.release_date, data.releaseDate)
                }
                setOnClickListener {
                    context.startActivity(

                    Intent(context, DetailActivity::class.java)
                        .putExtra(DetailActivity.MOVIE_ID, data.movieId)
                    )
                    Log.d("id", data.movieId)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_movies, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = data[position]
        holder.bindItem(movies)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

