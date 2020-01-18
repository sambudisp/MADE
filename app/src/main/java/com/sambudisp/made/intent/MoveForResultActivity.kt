package com.sambudisp.made.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import com.sambudisp.made.R

class MoveForResultActivity : AppCompatActivity() {

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        initComponent()
        setupButton()
    }

    private fun setupButton() {
        btnChoose?.setOnClickListener {
            if (rgNumber.checkedRadioButtonId != 0){
                var value = 0
                when (rgNumber.checkedRadioButtonId){
                    R.id.rb_1 -> value = 1
                    R.id.rb_2 -> value = 2
                    R.id.rb_3 -> value = 3
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }

    private fun initComponent() {
        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)
    }
}
