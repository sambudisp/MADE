package com.sambudisp.made.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sambudisp.made.R
import com.sambudisp.made.model.Person
import kotlinx.android.synthetic.main.activity_move_with_object.*

class MoveWithObjectActivity : AppCompatActivity() {

    private var tvParcelableResult : TextView? = null

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        initComponent()
        getParsingData()
    }

    private fun initComponent() {
        tvParcelableResult = findViewById(R.id.tv_parcelable_result)
    }

    private fun getParsingData() {
        val person = intent.getParcelableExtra(EXTRA_PERSON) as Person
        val text = "Nama : ${person.name}, \nUmur : ${person.age}, \nEmail : ${person.email}"
        tvParcelableResult?.text = text
    }
}
