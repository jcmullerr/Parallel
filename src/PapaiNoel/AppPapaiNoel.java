package PapaiNoel;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import PapaiNoel.Gerenciadores.PoloNorte;

public class AppPapaiNoel {
    public static void Execute() throws InterruptedException{

        var threadpool = Executors.newScheduledThreadPool(1);

        threadpool.scheduleWithFixedDelay(() -> {
            var poloNorte = new PoloNorte();
        } , 0, 1, TimeUnit.SECONDS);
    }
}
