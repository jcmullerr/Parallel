package Barbearia.Base;

import Barbearia.Enums.EEstadoCliente;

public class Cliente extends Thread{

    public Cliente(String nome, EEstadoCliente estadoCliente) {
        super(nome);
        Nome = nome;
        EstadoCliente = estadoCliente;
    }

    private String Nome;
    private EEstadoCliente EstadoCliente;

    public String getNome() {
        return Nome;
    }

    public EEstadoCliente getEstadoCliente() {
        return EstadoCliente;
    }

    public void setEstadoCliente(EEstadoCliente estadoCliente) {
        EstadoCliente = estadoCliente;
    }
}
