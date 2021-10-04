package Barbearia.Gerenciadores;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Barbearia.Base.Cliente;
import Barbearia.Enums.EEstadoCliente;

public class GerenciadorDeClientes {
    private Queue<Cliente> _clientes = new LinkedList<>();

    public Queue<Cliente> getClientes() {
        return _clientes;
    }

    public Cliente ObterProximoCliente(){
        if(_clientes.isEmpty())
            return null;

        var cliente = _clientes.poll();
        
        if(!_clientes.isEmpty())
            ReorganizarClientes();

        return cliente;
    }

    private void ReorganizarClientes() {
        var cliente = ObterProximoClienteParaSeSentar();
        cliente.setEstadoCliente(EEstadoCliente.Sentado);
    }

    private Cliente ObterProximoClienteParaSeSentar() {
        List<Cliente> clientes = (List)_clientes;
        if(clientes.size() < 4)
            return clientes.get(clientes.size()-1);
            
        _clientes = (LinkedList) clientes;
        
        return clientes.get(3);

    }
}
