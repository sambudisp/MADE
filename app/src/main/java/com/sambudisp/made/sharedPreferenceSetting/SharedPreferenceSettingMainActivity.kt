package com.sambudisp.made.sharedPreferenceSetting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sambudisp.made.R

class SharedPreferenceSettingMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_setting_main)

        supportFragmentManager.beginTransaction().add(R.id.setting_holder, PreferenceFragment()).commit()

    }
}
