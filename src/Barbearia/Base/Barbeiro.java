package Barbearia.Base;

public class Barbeiro extends Thread {
    private String _nome;
    private boolean _estaAtendendo;
    private Cliente _cliente;

    public Barbeiro(String nome){
        super(nome);
        _nome = nome;
        _estaAtendendo = false;
        _cliente = null;
    }

    public void setCliente(Cliente cliente) {
        _cliente = cliente;
    }

    public void Run(){
        Atender();
    }

    public void Atender(){
        if(_cliente == null)
            return;
    }

    public boolean getEstaAtendendo() {
        return _estaAtendendo;
    }

    public void set_estaAtendendo(boolean estaAtendendo) {
        _estaAtendendo = estaAtendendo;
    }

    public String getNome() {
        return _nome;
    }

    public void setNome(String nome) {
        _nome = nome;
    }
}
