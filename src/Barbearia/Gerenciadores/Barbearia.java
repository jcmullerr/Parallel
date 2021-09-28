package Barbearia.Gerenciadores;

import java.util.ArrayList;
import java.util.Queue;

import Barbearia.Base.Barbeiro;
import Barbearia.Base.Cliente;

public class Barbearia extends Thread{
    private ArrayList<Barbeiro> _barbeiros = new ArrayList<>();
    private Queue<Cliente> _clientes = new LinkedList<>();

    public Barbearia(Queue<Cliente> clientes) {
        super("Barbearia");
        _clientes = clientes;
        _barbeiros.add(new Barbeiro("Primeiro"));
        _barbeiros.add(new Barbeiro("Segundo"));
        _barbeiros.add(new Barbeiro("Terceiro"));
    }

    public void Atender(){
        while(true){

            Barbeiro barbeiro = _barbeiros
            .stream()
            .filter(x -> x.getEstaAtendendo())
            .findAny()
            .orElse(null);
        
            if(barbeiro == null)
                continue;

            Cliente cliente = _clientes.poll();
            barbeiro.setCliente(cliente);
        }
    }

    public void run(){
        Atender();
    }


}
