package Barbearia.Base;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PointOfSale {
    private int _cortesEfetuados;

    public PointOfSale(){
        _cortesEfetuados = 0;
    }

    public void Pagar(){
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(700,1001));
            _cortesEfetuados++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
