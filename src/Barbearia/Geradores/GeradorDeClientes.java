package Barbearia.Geradores;

import java.util.ArrayList;
import java.util.Queue;
import java.util.UUID;

import Barbearia.Base.Cliente;
import Barbearia.Enums.EEstadoCliente;

public class GeradorDeClientes extends Thread{
    private Queue<Cliente> _clientes;

    public GeradorDeClientes(Queue<Cliente> clientes) {
        super("Gerador");
        _clientes = clientes;
        start();
    }

    public void run(){
        while(true){
            try {
                if(_clientes.size() == 20)
                    continue;

                synchronized(this){
                    var cliente = CriarCliente(UUID.randomUUID().toString());

                    _clientes.add(
                        cliente
                    );
                    System.out.println("Cliente novo chegou - " + cliente.getNome());
                }
                

                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Cliente CriarCliente(String numeroCliente) {
        var nomeCliente = "Cliente " + numeroCliente;

        if(_clientes.size() <= 4)
            return new Cliente(nomeCliente,EEstadoCliente.Sentado);
        
        return new Cliente(nomeCliente,EEstadoCliente.EmPe);
    }
}
