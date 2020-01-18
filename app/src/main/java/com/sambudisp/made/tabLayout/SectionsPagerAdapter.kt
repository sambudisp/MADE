package com.sambudisp.made.tabLayout

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sambudisp.made.R

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3)

    override fun getItem(position: Int): Fragment {
       /* var fragment: Fragment? = null
        when (position) {
            0 -> fragment = Tab1Fragment()
            1 -> fragment = Tab2Fragment()
        }
        return fragment as Fragment*/

        val fragment = Tab1Fragment.newInstance(position + 1)
        return fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 3
    }
}