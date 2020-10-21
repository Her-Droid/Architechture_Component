package id.herdroid.moviecatalog.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.herdroid.moviecatalog.R
import id.herdroid.moviecatalog.data.MovieEntity
import id.herdroid.moviecatalog.data.TvShowEntity
import id.herdroid.moviecatalog.enum.TypeData
import id.herdroid.moviecatalog.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.list_movies.view.*
import kotlinx.android.synthetic.main.list_tvshows.view.*

class TvShowAdapter (private val context: Context, private var dataTvShow: List<TvShowEntity>, private val type: TypeData):
        RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {
     inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        fun bindItem(tvShowEntity: TvShowEntity) {
            itemView.run {
                tvShowEntity.also {
                    Glide.with(itemView.context).load(tvShowEntity.imagePath)
                            .into(iv_tvShow)
                    tvShow_title.text = it.title
                    tvShow_description.text = it.description
                    tvShow_date.text = itemView.resources.getString(R.string.release_date, tvShowEntity.releaseDate)
                }
                setOnClickListener {
                    context.startActivity(

                            Intent(context, DetailActivity::class.java)
                                    .putExtra(DetailActivity.TVSHOW_ID, tvShowEntity.tvShowId)
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_tvshows, parent, false))
    }

    override fun onBindViewHolder(holder: TvShowAdapter.ViewHolder, position: Int) {
        val movies = dataTvShow[position]
        holder.bindItem(movies)
    }

    override fun getItemCount(): Int {
        return dataTvShow.size
    }
}