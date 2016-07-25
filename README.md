# Android 打开QQ企业临时会话

打开800开头的企业QQ方式
```
String url="mqqwpa://im/chat?chat_type=wpa&uin=企业QQ";  
startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));  
```
打开400的方式<br/>
拿招行的4008205555测试
```
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
```
拿到url跳转
```
String url="mqqwpa://im/chat?chat_type=crm&uin=800095555&version=1&src_type=web&web_src=http:://wpa.b.qq.com";  
startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
```
