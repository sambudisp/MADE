package com.sambudisp.made.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

import com.sambudisp.made.R
import com.sambudisp.made.intent.IntentActivity

class OpenDialogFragment : Fragment(), View.OnClickListener {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbSaf: RadioButton
    private lateinit var rbMou: RadioButton
    private lateinit var rbLvg: RadioButton
    private lateinit var rbMoyes: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_open_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnChoose = view.findViewById(R.id.btn_choose)
        btnChoose.setOnClickListener(this)
        btnClose = view.findViewById(R.id.btn_close)
        btnClose.setOnClickListener(this)
        rgOptions = view.findViewById(R.id.rg_options)
        rbSaf = view.findViewById(R.id.rb_alex)
        rbLvg = view.findViewById(R.id.rb_lwg)
        rbMou = view.findViewById(R.id.rb_mario)
        rbMoyes = view.findViewById(R.id.rb_moyes)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_close -> ""
            R.id.btn_choose -> ""
            }
        }

    interface OnOptionDialogListener{
        fun onChoosen(text: String?)
    }
}
