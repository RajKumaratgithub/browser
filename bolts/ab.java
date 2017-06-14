package bolts;

/* compiled from: TaskCompletionSource */
public class ab<TResult> {
    private final Task<TResult> f1054a;

    public ab() {
        this.f1054a = new Task();
    }

    public Task<TResult> m2384a() {
        return this.f1054a;
    }

    public boolean m2389b() {
        return this.f1054a.m2446l();
    }

    public boolean m2386a(TResult tResult) {
        return this.f1054a.m2431b((Object) tResult);
    }

    public boolean m2385a(Exception exception) {
        return this.f1054a.m2430b(exception);
    }

    public void m2390c() {
        if (!m2389b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void m2388b(TResult tResult) {
        if (!m2386a((Object) tResult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void m2387b(Exception exception) {
        if (!m2385a(exception)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
