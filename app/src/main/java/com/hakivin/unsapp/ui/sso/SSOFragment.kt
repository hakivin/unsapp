package com.hakivin.unsapp.ui.sso

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.hakivin.unsapp.R

class SSOFragment : Fragment() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_share, container, false)
        val webView : WebView = root.findViewById(R.id.webView_sso)
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
        webView.loadUrl("https://sso.uns.ac.id/module.php/core/as_login.php?AuthId=default-sp&ReturnTo=https%3A%2F%2Fsso.uns.ac.id%2Fmodule.php%2Funs%2Findex.php")
        return root
    }
}