package com.sambudisp.made.backgroundThread

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.activity_main_bg_thread.*
import kotlinx.coroutines.*
import java.lang.ref.WeakReference

class MainBgThreadActivity : AppCompatActivity(), MyAsyncCallback {

    companion object {
        private const val INPUT_STRING = "Halo Ini Demo AsyncTask!!"
        private const val LOG_ASYNC = "DemoAsync"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bg_thread)

        //Dengan Background service
        /*val demo = DemoAsync(this)
        demo.execute(INPUT_STRING)*/

        //Dengan coroutine
        tv_status.setText(R.string.status_pre)
        tv_desc.text = INPUT_STRING

        GlobalScope.launch(Dispatchers.IO) {
            //background thread
            val input = INPUT_STRING
            var output: String? = null
            Log.d(LOG_ASYNC, "status : doInBackground")
            try {
                // Input stringnya ditambahkan dengan string "Selamat Belajar!!"
                output = "$input Selamat Belajar!!"
                delay(2000)
                //pindah ke Main thread untuk update UI
                withContext(Dispatchers.Main) {
                    tv_status.setText(R.string.status_post)
                    tv_desc.text = output
                }
            } catch (e: Exception) {
                Log.d(LOG_ASYNC, e.message.toString())
            }
        }

    }

    override fun onPreExecute() {
        tv_status.setText(R.string.status_pre)
        tv_desc.text = INPUT_STRING
    }

    override fun onPostExecute(text: String) {
        tv_status.setText(R.string.status_post)
        tv_desc.text = text
    }

    private class DemoAsync(val myListener: MyAsyncCallback) : AsyncTask<String, Void, String>() {
        companion object {
            private val LOG_ASYNC = "DemoAsync"
        }

        private val listener: WeakReference<MyAsyncCallback>

        init {
            this.listener = WeakReference(myListener)
        }

        override fun onPreExecute() {
            super.onPreExecute()
            Log.d(LOG_ASYNC, "status : onPreExecute")
            val myListener = listener.get()
            myListener?.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String {
            Log.d(LOG_ASYNC, "status : doInBackground")

            var output: String? = null

            try {
                val input = params[0]
                output = "$input Selamat Belajar!!"
                Thread.sleep(2000)
            } catch (e: Exception) {
                Log.d(LOG_ASYNC, e.message.toString())
            }

            return output.toString()
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            Log.d(LOG_ASYNC, "status : onPostExecute")

            val myListener = this.listener.get()
            myListener?.onPostExecute(result)
        }

    }
}

internal interface MyAsyncCallback {
    fun onPreExecute()
    fun onPostExecute(text: String)
}
