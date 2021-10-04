package Barbearia.Base;

public class PointOfSale {
    private boolean Livre;

    public boolean isLivre() {
        return Livre;
    }

    public void setLivre(boolean livre) {
        Livre = livre;
    }

    public void Pagar(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
