package com.dolphin.browser.ab;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.aa;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* renamed from: com.dolphin.browser.ab.c */
public class AsyncHttpWebService {
    String f2013a;
    String f2014b;
    Header[] f2015c;
    aa f2016d;
    HttpEntity f2017e;
    String f2018f;
    AsyncHttpResponseHandler f2019g;
    String f2020h;

    public AsyncHttpWebService() {
        this.f2014b = "GET";
    }

    public AsyncHttpWebService m3854a() {
        AsyncHttpWebService asyncHttpWebService = new AsyncHttpWebService(null);
        asyncHttpWebService.f2012b = this;
        return asyncHttpWebService;
    }

    public AsyncHttpWebService m3856a(String str) {
        this.f2013a = str;
        return this;
    }

    public AsyncHttpWebService m3857b(String str) {
        this.f2014b = str;
        return this;
    }

    public AsyncHttpWebService m3855a(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this.f2019g = asyncHttpResponseHandler;
        return this;
    }

    public AsyncHttpWebService m3858c(String str) {
        this.f2020h = str;
        return this;
    }
}
