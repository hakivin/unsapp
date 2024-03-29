package com.hakivin.unsapp.ui.slideshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hakivin.unsapp.R

class SlideshowFragment : Fragment() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val webView: WebView = root.findViewById(R.id.webView_siakad_old)
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
                return true
            }
        }
        webView.loadUrl("https://siakad-old.uns.ac.id")
        return root
    }
}