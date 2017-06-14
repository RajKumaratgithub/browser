package com.dolphin.browser.aa;

import android.net.Uri;

/* renamed from: com.dolphin.browser.aa.a */
public class BaiduGate implements WebContentProxy {
    private static long f2001a;
    private static BaiduGate f2002b;

    static {
        f2001a = 86400000;
    }

    public static BaiduGate m3837a() {
        if (f2002b == null) {
            f2002b = new BaiduGate();
        }
        return f2002b;
    }

    private BaiduGate() {
    }

    public boolean m3838a(String str) {
        if (Uri.parse(str).getHost().equalsIgnoreCase("gate.baidu.com")) {
            return false;
        }
        return true;
    }

    public String m3839b(String str) {
        if (!str.startsWith("http://gate.baidu.com")) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (parse.isHierarchical()) {
            return parse.getQueryParameter("src");
        }
        return null;
    }
}
