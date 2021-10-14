package Barbearia.Base;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
        start();
    }

    public void setCliente(Cliente cliente) {
        _cliente = cliente;
        _estaAtendendo = true;
    }

    public void run(){
        while(true)
            Atender();
    }

    public void Atender(){
        if(_cliente == null)
            return;

        System.out.println("Cliente "+ _cliente.getNome()+" esta sendo atendido por "+ _nome);
        
        try {
            sleep(ThreadLocalRandom.current().nextInt(700,1001));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        synchronized(_pos){
            _pos.Pagar();
            _cliente = null;
            _estaAtendendo = false;
            System.out.println(_nome + " encerrou o atendimento e esta aguardando novo cliente");
        }
    }

    public boolean getEstaAtendendo() {
        return _estaAtendendo;
    }

    public String getNome() {
        return _nome;
    }
}
