package PapaiNoel;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import PapaiNoel.Gerenciadores.PoloNorte;

public class AppPapaiNoel {
    public static void Execute(){
        var threadpool = Executors.newScheduledThreadPool(1);

        threadpool.scheduleAtFixedRate(() -> {
            var poloNorte = new PoloNorte();
        } , 0, 2, TimeUnit.MILLISECONDS);
    }
}
