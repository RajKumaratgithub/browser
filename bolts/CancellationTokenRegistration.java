package bolts;

import java.io.Closeable;

/* renamed from: bolts.i */
public class CancellationTokenRegistration implements Closeable {
    private final Object f1067a;
    private CancellationTokenSource f1068b;
    private Runnable f1069c;
    private boolean f1070d;

    public void close() {
        synchronized (this.f1067a) {
            if (this.f1070d) {
                return;
            }
            this.f1070d = true;
            this.f1068b.m2403a(this);
            this.f1068b = null;
            this.f1069c = null;
        }
    }
}
