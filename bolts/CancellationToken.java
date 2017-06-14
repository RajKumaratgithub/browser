package bolts;

import java.util.Locale;

/* renamed from: bolts.h */
public class CancellationToken {
    private final CancellationTokenSource f1066a;

    public boolean m2400a() {
        return this.f1066a.m2404a();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f1066a.m2404a())});
    }
}
