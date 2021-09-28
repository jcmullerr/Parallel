package Barbearia.Geradores;

import java.util.ArrayList;

import Barbearia.Base.Cliente;
import Barbearia.Enums.EEstadoCliente;

public class GeradorDeClientes extends Thread{
    private Queue<Cliente> clientes;

    public GeradorDeClientes(Queue<Cliente> clientes) {
        super("Gerador");
        this.clientes = clientes;
    }

    public void run(){
        while(true){
            try {
                synchronized(clientes){
                    if(clientes.size() == 20)
                        continue;

                    int numeroCliente = clientes.size() + 1;

                    Cliente cliente = CriarCliente(numeroCliente);
                    clientes.add(
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

    private Cliente CriarCliente(int numeroCliente) {
        String nomeCliente = "Cliente" + numeroCliente;

        if(numeroCliente <= 4)
            return new Cliente(nomeCliente,EEstadoCliente.Sentado);
        
        return new Cliente(nomeCliente,EEstadoCliente.Sentado);
    }
}
