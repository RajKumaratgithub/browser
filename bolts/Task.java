package bolts;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: bolts.x */
final class Task implements Continuation<Object, Void> {
    final /* synthetic */ Object f1122a;
    final /* synthetic */ ArrayList f1123b;
    final /* synthetic */ AtomicBoolean f1124c;
    final /* synthetic */ AtomicInteger f1125d;
    final /* synthetic */ ab f1126e;

    Task(Object obj, ArrayList arrayList, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, ab abVar) {
        this.f1122a = obj;
        this.f1123b = arrayList;
        this.f1124c = atomicBoolean;
        this.f1125d = atomicInteger;
        this.f1126e = abVar;
    }

    public /* synthetic */ Object m2459a(Task task) {
        return m2460b(task);
    }

    public Void m2460b(Task<Object> task) {
        if (task.m2440e()) {
            synchronized (this.f1122a) {
                this.f1123b.add(task.m2442g());
            }
        }
        if (task.m2439d()) {
            this.f1124c.set(true);
        }
        if (this.f1125d.decrementAndGet() == 0) {
            if (this.f1123b.size() != 0) {
                if (this.f1123b.size() == 1) {
                    this.f1126e.m2387b((Exception) this.f1123b.get(0));
                } else {
                    this.f1126e.m2387b(new AggregateException(String.format("There were %d exceptions.", new Object[]{Integer.valueOf(this.f1123b.size())}), this.f1123b));
                }
            } else if (this.f1124c.get()) {
                this.f1126e.m2390c();
            } else {
                this.f1126e.m2388b(null);
            }
        }
        return null;
    }
}
