package bolts;

/* compiled from: UnobservedErrorNotifier */
class ac {
    private Task<?> f1055a;

    public ac(Task<?> task) {
        this.f1055a = task;
    }

    protected void finalize() {
        try {
            Task task = this.f1055a;
            if (task != null) {
                aa a = Task.m2408a();
                if (a != null) {
                    a.m2383a(task, new ad(task.m2442g()));
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void m2391a() {
        this.f1055a = null;
    }
}
