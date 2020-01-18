package com.sambudisp.made.tabLayout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sambudisp.made.R
import kotlinx.android.synthetic.main.fragment_tab1.*

class Tab1Fragment : Fragment() {

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(index: Int): Tab1Fragment {
            val fragment = Tab1Fragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var index = 1
        if (getArguments() != null) {
            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
        }
        section_label.text = "Tab Yang ke => $index"
    }


}
