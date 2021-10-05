package Barbearia.Base;

public class PointOfSale {
    private int _cortesEfetuados;

    public PointOfSale(){
        _cortesEfetuados = 0;
    }

    public void Pagar(){
        try {
            Thread.sleep(1000);
            _cortesEfetuados++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
