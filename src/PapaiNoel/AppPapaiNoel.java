package PapaiNoel;

import PapaiNoel.Gerenciadores.PoloNorte;

public class AppPapaiNoel {
    public static void Execute() throws InterruptedException{
        var poloNorte = new PoloNorte();
        poloNorte.run();
    }
}
