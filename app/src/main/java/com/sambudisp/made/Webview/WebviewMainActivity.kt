package com.sambudisp.made.Webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.activity_webview_main.*

class WebviewMainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview_main)

        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                //Toast.makeText(this@WebviewMainActivity, "Web Dicoding berhasil dimuat", Toast.LENGTH_LONG).show()
                view.loadUrl("javascript:alert('Web Dicoding berhasil dimuat')")
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                Toast.makeText(this@WebviewMainActivity, message, Toast.LENGTH_LONG).show()
                result?.confirm()
                return true
            }
        }

        webView.loadUrl("https://www.dicoding.com")
    }
}
