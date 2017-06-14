package com.dolphin.browser.account;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dolphin.browser.account.c */
public class AccountGroup {
    private List<Account> f2024a;

    public AccountGroup() {
        this.f2024a = new ArrayList();
    }

    public void m3869a(Account account) {
        this.f2024a.add(account);
    }

    public Account m3868a(int i) {
        return (Account) this.f2024a.get(i);
    }

    public int m3867a() {
        return this.f2024a.size();
    }
}
