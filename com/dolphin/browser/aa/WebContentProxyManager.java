package com.dolphin.browser.aa;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.dolphin.browser.core.AppContext;
import com.dolphin.browser.util.Log;
import com.dolphin.browser.util.Tracker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mobi.mgeek.TunnyBrowser.BrowserSettings;
import mobi.mgeek.TunnyBrowser.extensions.IExtension;

/* renamed from: com.dolphin.browser.aa.d */
public class WebContentProxyManager implements WebContentProxy {
    private static WebContentProxyManager f2004a;
    private static final List<String> f2005f;
    private static final Map<String, String> f2006g;
    private SharedPreferences f2007b;
    private WebContentProxy f2008c;
    private Boolean f2009d;
    private int f2010e;

    static {
        f2005f = new ArrayList();
        f2006g = new HashMap();
        f2005f.add("dolphin.com");
        f2005f.add("dolphin-browser");
        f2005f.add("m.taobao.com");
        f2005f.add("m.baidu.com");
        f2005f.add("wap.baidu.com");
        f2005f.add("3g.sina.com");
        f2005f.add("3g.youku.com");
        f2005f.add("3g.163.com");
        f2005f.add("3g.ifeng.com");
        f2005f.add("wap.sohu.com");
        f2005f.add("wap.kanshu.com");
        f2005f.add("easou.com");
        f2005f.add("m.vancl.com");
        f2005f.add("m.dangdang.com");
        f2005f.add("m.hiapk.com");
        f2005f.add("wap.ganji");
        f2005f.add("3g.ganji");
        f2005f.add("qidian.cn");
        f2005f.add("mbook.cn");
        f2005f.add("m.appchina.com");
        f2005f.add("wap.eastmoney.com");
        f2005f.add("wap.hexun.com");
        f2005f.add("m.hiapk.com");
        f2005f.add("bbs.hiapk.com");
        f2005f.add("hongxiu.cn/iphone");
        f2005f.add("wap.hongxiu");
        f2005f.add("bbs.gfan.com");
        f2005f.add("3g.gfan");
        f2005f.add("huaban.com");
        f2005f.add("3g.news.cn");
        f2005f.add("wap.people.com.cn");
        f2005f.add("m.xxsy.net");
        f2005f.add("m.apk.hiapk.com");
        f2005f.add("3g.gfan.com");
        f2005f.add("m.anzhi.com");
        f2005f.add("3g.56.com");
        f2005f.add("m.joy.cn");
        f2005f.add("m.trends.com.cn");
        f2005f.add("moko.cc");
        f2005f.add("3g.aili.com");
        f2005f.add("sina.cn");
        f2005f.add("wap.tiexue.net");
        f2005f.add("wap.huanqiu.com");
        f2005f.add("i.ifeng.com");
        f2005f.add("m.360buy.com");
        f2005f.add("m.amazon.cn");
        f2005f.add("m.lashou.com");
        f2005f.add("m.nuomi.com");
        f2005f.add("m.meituan.com");
        f2005f.add("wap.rayli.com.cn");
        f2005f.add("3g.yoka.com");
        f2005f.add("m.bitauto.com");
        f2005f.add("wap.xcar.com.cn");
        f2005f.add("3g.qq.com");
        f2005f.add("3g.kugou.com");
        f2005f.add("3g.jiayuan.com");
        f2005f.add("3g.baihe.com");
        f2005f.add("wap.jstv.com");
        f2005f.add("3g.mop.com");
        f2005f.add("3g.tianya.cn");
        f2005f.add("3g.renren.com");
        f2005f.add("m.douban.com");
        f2005f.add("m.dianping.com");
        f2005f.add("m.google.com");
        f2005f.add("wap.huochepiao.com");
        f2005f.add("touch.qunar.com");
        f2005f.add("wap.8684.com");
        f2005f.add("wap.8684.cn");
        f2005f.add("wap.kuaidi100.com");
        f2005f.add("m.mtime.com");
        f2005f.add("m.qiushibaike.com");
        f2005f.add("map.baidu.com");
        f2005f.add("www.google.com");
        f2005f.add("m.google.com");
        f2005f.add("weibo.cn");
        f2006g.put("www.sina.com.cn", "http://3g.sina.com.cn");
        f2006g.put("sina.com.cn", "http://3g.sina.com.cn");
        f2006g.put("sina.com", "http://3g.sina.com.cn");
        f2006g.put("www.baidu.com", "http://m.baidu.com");
        f2006g.put("baidu.com", "http://m.baidu.com");
        f2006g.put("www.taobao.com", "http://m.taobao.com");
        f2006g.put("taobao.com", "http://m.taobao.com");
        f2006g.put("www.163.com", "http://3g.163.com");
        f2006g.put("163.com", "http://3g.163.com");
        f2006g.put("www.sohu.com", "http://wap.sohu.com");
        f2006g.put("sohu.com", "http://wap.sohu.com");
        f2006g.put("www.ifeng.com", "http://3g.ifeng.com");
        f2006g.put("ifeng.com", "http://3g.ifeng.com");
        f2006g.put("www.youku.com", "http://3g.youku.com");
        f2006g.put("youku.com", "http://3g.youku.com");
        f2006g.put("www.tudou.com", "http://m.tudou.com");
        f2006g.put("tudou.com", "http://m.tudou.com");
        f2006g.put("kanshu.com", "http://wap.kanshu.com");
        f2006g.put("vancl.com", "http://m.vancl.com");
        f2006g.put("hongxiu.cn", "http://wap.hongxiu.com");
        f2006g.put("hongxiu.com", "http://wap.hongxiu.com");
        f2006g.put("dangdang.com", "http://m.dangdang.com");
        f2006g.put("hiapk.com", "http://m.hiapk.com");
        f2006g.put("apk.hiapk.com", "http://m.apk.hiapk.com");
        f2006g.put("ganji.com", "http://wap.ganji.com");
        f2006g.put("ganji.cn", "http://wap.ganji.cn");
        f2006g.put("mbook.com", "http://wap.mbook.com");
        f2006g.put("appchina.com", "http://m.appchina.com");
        f2006g.put("hexun.com", "http://wap.hexun.com");
        f2006g.put("eastmoney.com", "http://wap.eastmoney.com");
        f2006g.put("news.cn", "http://3g.news.cn");
        f2006g.put("people.com.cn", "http://wap.people.com.cn");
        f2006g.put("xxsy.net", "http://m.xxsy.net");
        f2006g.put("gfan.com", "http://3g.gfan.com");
        f2006g.put("anzhi.com", "http://m.anzhi.com");
        f2006g.put("56.com", "http://3g.56.com");
        f2006g.put("joy.cn", "http://m.joy.cn");
        f2006g.put("trends.com.cn", "http://m.trends.com.cn");
        f2006g.put("aili.com", "http://3g.aili.com");
        f2006g.put("tiexue.net", "http://wap.tiexue.net");
        f2006g.put("huanqiu.com", "http://wap.huanqiu.com");
        f2006g.put("360buy.com", "http://m.360buy.com");
        f2006g.put("amazon.cn", "http://m.amazon.cn");
        f2006g.put("lashou.com", "http://m.lashou.com");
        f2006g.put("nuomi.com", "http://m.nuomi.com");
        f2006g.put("meituan.com", "http://m.meituan.com");
        f2006g.put("www.rayli.com.cn", "http://wap.rayli.com.cn");
        f2006g.put("rayli.com.cn", "http://wap.rayli.com.cn");
        f2006g.put("yoka.com", "http://3g.yoka.com");
        f2006g.put("bitauto.com", "http://m.bitauto.com");
        f2006g.put("xcar.com.cn", "http://wap.xcar.com.cn");
        f2006g.put("qq.com", "http://3g.qq.com");
        f2006g.put("kugou.com", "http://3g.kugou.com");
        f2006g.put("jiayuan.com", "http://3g.jiayuan.com");
        f2006g.put("baihe.com", "http://3g.baihe.com");
        f2006g.put("jstv.com", "http://wap.jstv.com");
        f2006g.put("mop.com", "http://3g.mop.com");
        f2006g.put("tianya.cn", "http://3g.tianya.cn");
        f2006g.put("renren.com", "http://3g.renren.com");
        f2006g.put("douban.com", "http://m.douban.com");
        f2006g.put("dianping.com", "http://m.dianping.com");
        f2006g.put("google.com", "http://m.google.com");
        f2006g.put("huochepiao.com", "http://wap.huochepiao.com");
        f2006g.put("qunar.com", "http://touch.qunar.com");
        f2006g.put("8684.com", "http://wap.8684.cn");
        f2006g.put("kuaidi100.com", "http://wap.kuaidi100.com");
        f2006g.put("mtime.com", "http://m.mtime.com");
        f2006g.put("qiushibaike.com", "http://m.qiushibaike.com");
    }

    private WebContentProxyManager() {
        this.f2007b = PreferenceManager.getDefaultSharedPreferences(AppContext.getInstance());
        int i = this.f2007b.getInt("content_proxy_mode", 0);
        this.f2009d = Boolean.valueOf(this.f2007b.getBoolean("content_proxy_shownotice", false));
        m3844a(i);
    }

    public static synchronized WebContentProxyManager m3843a() {
        WebContentProxyManager webContentProxyManager;
        synchronized (WebContentProxyManager.class) {
            if (f2004a == null) {
                f2004a = new WebContentProxyManager();
            }
            webContentProxyManager = f2004a;
        }
        return webContentProxyManager;
    }

    private void m3844a(int i) {
        Log.m17320d("WebContentProxyManager", "set mode %d", Integer.valueOf(i));
        switch (i) {
            case BrowserSettings.VOLUME_BUTTON_ACTION_NONE /*0*/:
                this.f2008c = NullContentProxy.m3840a();
                break;
            case IExtension.CLICK_RESULT_NEED_SHOW_DIALOG /*1*/:
                this.f2008c = BaiduGate.m3837a();
                break;
        }
        this.f2010e = i;
    }

    public boolean m3848a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!m3850b()) {
            return false;
        }
        Uri parse = Uri.parse(str);
        Object host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        host = host.toLowerCase();
        if (WebContentProxyManager.m3846e(str.toString())) {
            return false;
        }
        if (!"http".equalsIgnoreCase(parse.getScheme()) || m3845d(host)) {
            return false;
        }
        if (host.startsWith("www.")) {
            host = host.substring(4);
        }
        if (f2006g.containsKey(host)) {
            return true;
        }
        if (this.f2008c.m3835a(str)) {
            return true;
        }
        return false;
    }

    private boolean m3845d(String str) {
        for (String contains : f2005f) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public String m3849b(String str) {
        return TextUtils.isEmpty(str) ? str : WebContentProxyManager.m3847f(this.f2008c.m3836b(str));
    }

    public String m3851c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        CharSequence b = m3849b(str);
        if (TextUtils.isEmpty(b)) {
            b = WebContentProxyManager.m3847f(str);
        }
        return b;
    }

    private static boolean m3846e(String str) {
        return str.contains("fromproxy=1");
    }

    private static String m3847f(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("fromproxy=1");
        if (indexOf == -1) {
            return str;
        }
        indexOf--;
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.replace(indexOf, ("fromproxy=1".length() + indexOf) + 1, Tracker.LABEL_NULL);
        return stringBuilder.toString();
    }

    public boolean m3850b() {
        if (this.f2010e == 0) {
            return false;
        }
        if (com.dolphin.browser.core.BrowserSettings.getInstance().getUserAgent() == 1) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppContext.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return true;
        }
        return false;
    }
}
