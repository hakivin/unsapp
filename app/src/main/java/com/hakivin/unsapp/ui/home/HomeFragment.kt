package com.hakivin.unsapp.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.hakivin.unsapp.R

class HomeFragment : Fragment() {
    lateinit var progressBar : ProgressBar
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val webView: WebView = root.findViewById(R.id.webView_home)
        webView.settings.javaScriptEnabled = true
        webView.settings.builtInZoomControls = true
        webView.setOnKeyListener { v, keyCode, event ->
            if (webView.canGoBack())
                webView.goBack()
            true
        }
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                showLoading(true)
                return true
            }
        }
        progressBar = root.findViewById(R.id.pb_home)
        showLoading(true)
        progressBar.isIndeterminate = false
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                progressBar.progress = progress
                if (progress == 100){
                    Handler().postDelayed({
                        showLoading(false)
                    }, 1000L)
                }
            }

        }
        webView.loadUrl("https://uns.ac.id")
        return root
    }

    private fun showLoading(state : Boolean){
        if (state)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.GONE

    }
}