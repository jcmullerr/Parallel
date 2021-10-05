package Barbearia.Geradores;

import java.util.ArrayList;
import java.util.Queue;

import Barbearia.Base.Cliente;
import Barbearia.Enums.EEstadoCliente;

public class GeradorDeClientes extends Thread{
    private Queue<Cliente> _clientes;
    private int _totalClientes = 0;

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

                var numeroCliente = _totalClientes + 1;

                var cliente = CriarCliente(numeroCliente);

                _clientes.add(
                    cliente
                );
                _totalClientes ++;
                
                System.out.println("Cliente novo chegou - " + cliente.getNome());

                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Cliente CriarCliente(int numeroCliente) {
        var nomeCliente = "Cliente" + numeroCliente;

        if(numeroCliente <= 4)
            return new Cliente(nomeCliente,EEstadoCliente.Sentado);
        
        return new Cliente(nomeCliente,EEstadoCliente.EmPe);
    }
}
