package id.herdroid.moviecatalog.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.herdroid.moviecatalog.R
import id.herdroid.moviecatalog.adapter.MovieAdapter
import id.herdroid.moviecatalog.data.MovieEntity
import id.herdroid.moviecatalog.enum.TypeData
import id.herdroid.moviecatalog.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_tvshow.*


class MoviesFragment : Fragment() {

    private var type: TypeData = TypeData.MOVIES
    lateinit var movieList : List<MovieEntity>

    companion object {
        const val MOVIE_TYPE = "type"

        @JvmStatic
        fun newInstance(type: TypeData) =
            MoviesFragment().apply {
                arguments = Bundle().apply {
                    putInt(MOVIE_TYPE, type.ordinal)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            type = TypeData.values()[it.getInt(MOVIE_TYPE)]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
           val movie = ViewModelProviders.of(this).get(MovieViewModel::class.java)
            movieList = movie.getMovies()
            val recyclerView = rv_movie
            context?.run {
                recyclerView.adapter = MovieAdapter(this, movieList, type)
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                recyclerView.setHasFixedSize(true)
            }
        }
    }
}
