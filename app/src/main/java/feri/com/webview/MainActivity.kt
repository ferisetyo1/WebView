package feri.com.webview

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , AdvancedWebView.Listener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mWebView.setListener(this, this);
        mWebView.setMixedContentAllowed(false);
        mWebView.loadUrl("file:///android_asset/index.html");
    }

    @SuppressLint("NewApi")
    override fun onResume() {
        super.onResume()
        mWebView.onResume()
        // ...
    }

    @SuppressLint("NewApi")
    override fun onPause() {
        mWebView.onPause()
        // ...
        super.onPause()
    }

    override fun onDestroy() {
        mWebView.onDestroy()
        // ...
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        mWebView.onActivityResult(requestCode, resultCode, intent)
        // ...
    }

    override fun onBackPressed() {
        if (!mWebView.onBackPressed()) {
            return
        }
        // ...
        super.onBackPressed()
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {}

    override fun onPageFinished(url: String?) {}

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {}

    override fun onDownloadRequested(url: String?, suggestedFilename: String?, mimeType: String?, contentLength: Long, contentDisposition: String?, userAgent: String?) {}

    override fun onExternalPageRequest(url: String?) {}
}