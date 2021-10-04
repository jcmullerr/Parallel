package Barbearia.Base;

public class Barbeiro extends Thread {
    private String _nome;
    private boolean _estaAtendendo;
    private Cliente _cliente;
    private PointOfSale _pos;

    public Barbeiro(String nome, PointOfSale pos){
        super(nome);
        _nome = nome;
        _estaAtendendo = false;
        _cliente = null;
        _pos = pos;
    }

    public void setCliente(Cliente cliente) {
        _cliente = cliente;
        _estaAtendendo = true;
    }

    public void Run(){
        while(true)
            Atender();
    }

    public void Atender(){
        if(_cliente == null)
            return;
        
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        synchronized(_pos){
            _pos.Pagar();
            _estaAtendendo = false;
        }
    }

    public boolean getEstaAtendendo() {
        return _estaAtendendo;
    }

    public String getNome() {
        return _nome;
    }
}
