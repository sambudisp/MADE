package com.sambudisp.made.customView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.activity_custom_view.*

class CustomViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        setMyButtonEnable()

        my_custom_edt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })
        my_custom_button.setOnClickListener { Toast.makeText(this@CustomViewActivity, my_custom_edt.text, Toast.LENGTH_SHORT).show() }
    }

    private fun setMyButtonEnable() {
        val result = my_custom_edt.text
        my_custom_button.isEnabled = result != null && result.toString().isNotEmpty()
    }
}
