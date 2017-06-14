package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

/* renamed from: bolts.j */
public class CancellationTokenSource implements Closeable {
    private final Object f1071a;
    private final List<CancellationTokenRegistration> f1072b;
    private ScheduledFuture<?> f1073c;
    private boolean f1074d;
    private boolean f1075e;

    public boolean m2404a() {
        boolean z;
        synchronized (this.f1071a) {
            m2401b();
            z = this.f1074d;
        }
        return z;
    }

    public void close() {
        synchronized (this.f1071a) {
            if (this.f1075e) {
                return;
            }
            m2402c();
            for (CancellationTokenRegistration close : this.f1072b) {
                close.close();
            }
            this.f1072b.clear();
            this.f1075e = true;
        }
    }

    void m2403a(CancellationTokenRegistration cancellationTokenRegistration) {
        synchronized (this.f1071a) {
            m2401b();
            this.f1072b.remove(cancellationTokenRegistration);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(m2404a())});
    }

    private void m2401b() {
        if (this.f1075e) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void m2402c() {
        if (this.f1073c != null) {
            this.f1073c.cancel(true);
            this.f1073c = null;
        }
    }
}
