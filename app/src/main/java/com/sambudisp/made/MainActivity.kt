package com.sambudisp.made

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sambudisp.made.AlarmManager.MainAlarmManagerActivity
import com.sambudisp.made.BroadcastReceiver.BroadcastReceiverActivity
import com.sambudisp.made.JobScheduler.JobSchedulerActivity
import com.sambudisp.made.appbarXnavdrawerXbotnav.Main3Activity
import com.sambudisp.made.backgroundThread.MainBgThreadActivity
import com.sambudisp.made.customView.CustomViewActivity
import com.sambudisp.made.localization.Main5Activity
import com.sambudisp.made.navigation.Main2Activity
import com.sambudisp.made.navigationTaskAndBackstack.NavigationTaskBackstackActivity
import com.sambudisp.made.service.ServiceActivity
import com.sambudisp.made.tabLayout.Main4Activity
import com.sambudisp.made.workManager.WorkManagerActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var edtLength: EditText? = null
    private var edtHeight: EditText? = null
    private var edtWidth: EditText? = null
    private var btnCalculate: Button? = null
    private var tvResult: TextView? = null

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
        setupButton()
        saveInstanceState(savedInstanceState)
        goCodeLab()
    }

    private fun goCodeLab() {
        startActivity(Intent(this, NavigationTaskBackstackActivity::class.java))
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult?.text.toString())
    }

    private fun saveInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            val result = savedInstanceState?.getString(STATE_RESULT) as String
            tvResult?.text = result
        }
    }

    private fun setupButton() {
        btnCalculate?.setOnClickListener(this)

    }

    private fun initComponent() {
        edtLength = findViewById(R.id.edt_length)
        edtHeight = findViewById(R.id.edt_height)
        edtWidth = findViewById(R.id.edt_width)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate) {
            val inputLength = edtLength?.text.toString().trim()
            val inputWidth = edtWidth?.text.toString().trim()
            val inputHeight = edtHeight?.text.toString().trim()

            var isEmptyField = false

            if (inputLength.isEmpty()) {
                isEmptyField = true
                edtLength?.error = "Silakan isi kolom ini"
            } else if (inputWidth.isEmpty()) {
                isEmptyField = true
                edtWidth?.error = "Silakan isi kolom ini"
            } else if (inputHeight.isEmpty()) {
                isEmptyField = true
                edtHeight?.error = "Silakan isi kolom ini"
            }

            if (!isEmptyField) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult?.text = volume.toString()
            }
        }
    }
}
