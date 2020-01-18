package com.sambudisp.made.navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.sambudisp.made.R
import kotlinx.android.synthetic.main.fragment_home2.*


class Home2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_category.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_categoryFragment)
        }

        btn_profile.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_profileActivity)
        }

    }


}
