package id.herdroid.moviecatalog.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.herdroid.moviecatalog.R
import id.herdroid.moviecatalog.enum.TypeData
import id.herdroid.moviecatalog.ui.fragment.ListFragment

class ViewPagerAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ListFragment.newInstance(TypeData.MOVIES)
            1 -> ListFragment.newInstance(TypeData.TV_SHOWS)
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString(
            when (position) {
                0 -> R.string.movie
                1 -> R.string.tv_show
                else -> R.string.empty_movie
            }
        )
    }

}