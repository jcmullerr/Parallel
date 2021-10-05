package Barbearia.Gerenciadores;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Barbearia.Base.Barbeiro;
import Barbearia.Base.Cliente;
import Barbearia.Base.PointOfSale;

public class Barbearia extends Thread{
    private ArrayList<Barbeiro> _barbeiros = new ArrayList<>();
    private GerenciadorDeClientes _gerenciadorDeClientes;
    private PointOfSale _pos;

    public Barbearia(
        GerenciadorDeClientes gerenciadorDeClientes,
        PointOfSale pos
    ) {
        super("Barbearia");
        _gerenciadorDeClientes = gerenciadorDeClientes;
        _pos = pos;
        InicarBarbeiros();
        start();
    }

    private void InicarBarbeiros() {
        var barbeiroUm = new Barbeiro("Primeiro",_pos);
        var barbeiroDois = new Barbeiro("Segundo",_pos);
        var barbeiroTres = new Barbeiro("Terceiro",_pos);

        _barbeiros.add(barbeiroUm);
        _barbeiros.add(barbeiroDois);
        _barbeiros.add(barbeiroTres);
    }

    public void Atender(){
        while(true){

            var barbeiro = _barbeiros
                .stream()
                .filter(x -> !x.getEstaAtendendo())
                .findAny()
                .orElse(null);
        
            if(barbeiro == null)
                continue;
    

            Cliente cliente;
            
            synchronized(_gerenciadorDeClientes){
                cliente = _gerenciadorDeClientes.ObterProximoCliente();
            }

            if(cliente == null)
                continue;

            barbeiro.setCliente(cliente);
        }
    }

    public void run(){
        while(true)
            Atender();
    }


}
