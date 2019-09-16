package com.hakivin.unsapp.ui.gallery

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hakivin.unsapp.R
import kotlinx.android.synthetic.main.app_bar_main.*

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val webView : WebView = root.findViewById(R.id.webView)
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