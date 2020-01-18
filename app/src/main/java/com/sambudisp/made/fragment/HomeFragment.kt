package com.sambudisp.made.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var btnGoCaterogy: Button? = null
    private var btnShowDialog: Button? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGoCaterogy = view.findViewById(R.id.btn_go_category)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
        btnGoCaterogy?.setOnClickListener {

        }

        btnShowDialog?.setOnClickListener {

        }


    }


}
