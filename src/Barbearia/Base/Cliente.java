package Barbearia.Base;

import Barbearia.Enums.EEstadoCliente;

public class Cliente extends Thread{

    
    private String Nome;
    private EEstadoCliente EstadoCliente;
    
    public Cliente(String nome, EEstadoCliente estadoCliente) {
        super(nome);
        Nome = nome;
        EstadoCliente = estadoCliente;
    }

    public String getNome() {
        return Nome;
    }

    public void setEstadoCliente(EEstadoCliente estadoCliente) {
        EstadoCliente = estadoCliente;
    }
}
