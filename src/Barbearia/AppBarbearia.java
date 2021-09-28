package Barbearia;

import java.util.ArrayList;

import Barbearia.Base.Cliente;
import Barbearia.Base.PointOfSale;
import Barbearia.Geradores.GeradorDeClientes;

public class AppBarbearia {
    public static void Execute() throws InterruptedException{
        Queue<Cliente> clientes = new ArrayList<>();
        PointOfSale pos = new PointOfSale();
        GeradorDeClientes ger = new GeradorDeClientes(clientes);

        ger.start();
        ger.join();
    }
}
