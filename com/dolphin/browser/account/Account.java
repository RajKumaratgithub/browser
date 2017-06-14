package com.dolphin.browser.account;

import android.content.Context;
import com.dolphin.browser.DolphinService.Account.AccountManager;
import com.dolphin.browser.core.AppContext;
import com.dolphin.browser.express.web.C0007R;
import com.dolphin.browser.express.web.C0007R.string;
import com.dolphin.browser.p018t.p019a.FacebookManager;
import com.dolphin.browser.p081r.R;
import com.dolphin.browser.util.Tracker;
import mgeek.provider.Browser;
import mobi.mgeek.TunnyBrowser.BrowserSettings;
import mobi.mgeek.TunnyBrowser.extensions.IExtension;

/* renamed from: com.dolphin.browser.account.a */
public class Account {
    private AccountType f2021a;
    private Context f2022b;

    public Account(AccountType accountType) {
        this.f2022b = AppContext.getInstance();
        this.f2021a = accountType;
    }

    public Account(int i) {
        this.f2022b = AppContext.getInstance();
        AccountType accountType = AccountType.Unknown;
        if (i == 1) {
            accountType = AccountType.Facebook;
        } else if (i == 2) {
            accountType = AccountType.Twitter;
        }
        this.f2021a = accountType;
    }

    public AccountType m3860a() {
        return this.f2021a;
    }

    public String m3861b() {
        int i = 0;
        string com_dolphin_browser_express_web_R_string;
        if (this.f2021a == AccountType.DolphinConnect) {
            com_dolphin_browser_express_web_R_string = R.f7037l;
            i = C0007R.string.dolphin_sync;
        } else if (this.f2021a == AccountType.Facebook) {
            com_dolphin_browser_express_web_R_string = R.f7037l;
            i = C0007R.string.facebook;
        } else if (this.f2021a == AccountType.Twitter) {
            com_dolphin_browser_express_web_R_string = R.f7037l;
            i = C0007R.string.twitter;
        }
        if (i == 0) {
            return null;
        }
        return this.f2022b.getString(i);
    }

    public int m3862c() {
        if (this.f2021a == AccountType.Facebook) {
            return 1;
        }
        if (this.f2021a == AccountType.Twitter) {
            return 2;
        }
        return -1;
    }

    public String m3863d() {
        if (this.f2021a == AccountType.DolphinConnect) {
            return m3859h();
        }
        int i;
        string com_dolphin_browser_express_web_R_string;
        if (m3864e()) {
            com_dolphin_browser_express_web_R_string = R.f7037l;
            i = C0007R.string.logged_in;
        } else {
            com_dolphin_browser_express_web_R_string = R.f7037l;
            i = C0007R.string.not_logged_in;
        }
        return this.f2022b.getString(i);
    }

    private String m3859h() {
        int i = C0007R.string.login_null;
        string com_dolphin_browser_express_web_R_string = R.f7037l;
        com.dolphin.browser.DolphinService.Account.Account g = AccountManager.m2946a().m2980g();
        if (g != null) {
            string com_dolphin_browser_express_web_R_string2;
            switch (g.m2942j()) {
                case BrowserSettings.VOLUME_BUTTON_ACTION_NONE /*0*/:
                    com_dolphin_browser_express_web_R_string2 = R.f7037l;
                    i = C0007R.string.login_dolphin;
                    break;
                case Browser.HISTORY_PROJECTION_FOLDER_INDEX /*10*/:
                    com_dolphin_browser_express_web_R_string2 = R.f7037l;
                    i = C0007R.string.login_google;
                    break;
                case Browser.HISTORY_PROJECTION_ORDER_INDEX /*11*/:
                    com_dolphin_browser_express_web_R_string2 = R.f7037l;
                    i = C0007R.string.login_facebook;
                    break;
                default:
                    com_dolphin_browser_express_web_R_string = R.f7037l;
                    break;
            }
        }
        return this.f2022b.getString(i);
    }

    public boolean m3864e() {
        if (this.f2021a == AccountType.DolphinConnect) {
            if (AccountManager.m2946a().m2978e()) {
                return false;
            }
            return true;
        } else if (this.f2021a == AccountType.Facebook) {
            return FacebookManager.m14784a().m14814h();
        } else {
            return false;
        }
    }

    public String m3865f() {
        switch (Account.f2023a[this.f2021a.ordinal()]) {
            case IExtension.CLICK_RESULT_NEED_SHOW_DIALOG /*1*/:
                return AccountManager.m2946a().m2980g().m2937g();
            case BrowserSettings.VOLUME_BUTTON_ACTION_SWITCH_TAB /*2*/:
                return FacebookManager.m14784a().m14812f();
            default:
                return Tracker.LABEL_NULL;
        }
    }

    public String m3866g() {
        if (!m3864e()) {
            return null;
        }
        if (this.f2021a == AccountType.DolphinConnect) {
            return AccountManager.m2946a().m2980g().m2943k();
        }
        if (this.f2021a == AccountType.Facebook) {
            return FacebookManager.m14784a().m14810d();
        }
        return null;
    }
}
