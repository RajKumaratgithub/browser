package com.dolphin.browser.aa;

import com.dolphin.browser.util.Tracker;

/* renamed from: com.dolphin.browser.aa.b */
public class NullContentProxy implements WebContentProxy {
    private static NullContentProxy f2003a;

    public static NullContentProxy m3840a() {
        if (f2003a == null) {
            f2003a = new NullContentProxy();
        }
        return f2003a;
    }

    private NullContentProxy() {
    }

    public boolean m3841a(String str) {
        return false;
    }

    public String m3842b(String str) {
        return Tracker.LABEL_NULL;
    }
}
