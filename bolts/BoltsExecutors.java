package bolts;

import java.util.concurrent.Executor;

/* renamed from: bolts.g */
class BoltsExecutors implements Executor {
    private ThreadLocal<Integer> f1065a;

    private BoltsExecutors() {
        this.f1065a = new ThreadLocal();
    }

    private int m2398a() {
        Integer num = (Integer) this.f1065a.get();
        if (num == null) {
            num = Integer.valueOf(0);
        }
        int intValue = num.intValue() + 1;
        this.f1065a.set(Integer.valueOf(intValue));
        return intValue;
    }

    private int m2399b() {
        Integer num = (Integer) this.f1065a.get();
        if (num == null) {
            num = Integer.valueOf(0);
        }
        int intValue = num.intValue() - 1;
        if (intValue == 0) {
            this.f1065a.remove();
        } else {
            this.f1065a.set(Integer.valueOf(intValue));
        }
        return intValue;
    }

    public void execute(Runnable runnable) {
        if (m2398a() <= 15) {
            try {
                runnable.run();
            } catch (Throwable th) {
                m2399b();
            }
        } else {
            BoltsExecutors.m2395a().execute(runnable);
        }
        m2399b();
    }
}
