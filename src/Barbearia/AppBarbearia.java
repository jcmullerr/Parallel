package Barbearia;

import Barbearia.Base.PointOfSale;
import Barbearia.Geradores.GeradorDeClientes;
import Barbearia.Gerenciadores.Barbearia;
import Barbearia.Gerenciadores.GerenciadorDeClientes;

public class AppBarbearia {
    public static void Execute() throws InterruptedException{
        GerenciadorDeClientes gerenciadorDeClientes = new GerenciadorDeClientes();
        var pos = new PointOfSale();

        var barbearia = new Barbearia(gerenciadorDeClientes,pos);
        var ger = new GeradorDeClientes(gerenciadorDeClientes.getClientes());
    }
}
