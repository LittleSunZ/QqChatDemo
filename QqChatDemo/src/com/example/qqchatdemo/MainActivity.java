package com.example.qqchatdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	protected static final String TAG = "MainActivity";
	private WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webview = (WebView) findViewById(R.id.webview);
		//这个uin就是公众号，拿招行的测试，4008205555
		webview.loadUrl("http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=4008205555");

		// 启用支持javascript
		WebSettings settings = webview.getSettings();
		settings.setJavaScriptEnabled(true);
		webview.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				// 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
				view.loadUrl(url);
				Log.i(TAG, "url:"+url);
				//mqqwpa://im/chat?chat_type=crm&uin=800095555&version=1&src_type=web&web_src=http:://wpa.b.qq.com
				//会返回这样一串url,直接复制当跳转url就OK。
				return true;
			}
		});

	}

	public void toChat(View v){
		//这种方式打开400开头公众号是没用的,这种方式打开800开头的公众号有效
//		String url="mqqwpa://im/chat?chat_type=wpa&uin=4008205555";  
//		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));  

		//这个是解决400公众号
		String url="mqqwpa://im/chat?chat_type=crm&uin=800095555&version=1&src_type=web&web_src=http:://wpa.b.qq.com";  
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
		
	}
}
