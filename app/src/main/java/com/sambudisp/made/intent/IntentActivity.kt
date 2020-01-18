package com.sambudisp.made.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sambudisp.made.R
import com.sambudisp.made.model.Person

class IntentActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE = 100
    }

    private var btnMoveIntent: Button? = null
    private var btnMoveForResult: Button? = null
    private var tvResultReturn: TextView? = null
    private lateinit var person : Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        initComponent()
        setupData()
        setupButton()
    }

    private fun setupData() {
        person = Person(
            "DicodingAcademy",
            5,
            "academy@dicoding.com")
    }

    private fun setupButton() {
        btnMoveIntent?.setOnClickListener {
            val intent = Intent(this, MoveWithObjectActivity::class.java)
            intent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
            startActivity(intent)
        }

        btnMoveForResult?.setOnClickListener {
            val intent = Intent(this, MoveForResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    private fun initComponent() {
        btnMoveIntent = findViewById(R.id.btn_move_activity)
        btnMoveForResult = findViewById(R.id.btn_move_for_result_activity)
        tvResultReturn = findViewById(R.id.tv_result_return)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResultReturn?.text = "Hasil : $selectedValue"
            }
        }
    }
}
