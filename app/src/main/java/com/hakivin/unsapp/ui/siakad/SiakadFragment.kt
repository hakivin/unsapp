package com.hakivin.unsapp.ui.siakad

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.hakivin.unsapp.R

class SiakadFragment : Fragment() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val webView : WebView = root.findViewById(R.id.webView_siakad)
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
        webView.loadUrl("https://siakad.uns.ac.id")

        return root
    }
}