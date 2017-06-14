package bolts;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: bolts.d */
class AndroidExecutors implements Executor {
    private AndroidExecutors() {
    }

    public void execute(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
