package Barbearia;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Barbearia.Base.PointOfSale;
import Barbearia.Geradores.GeradorDeClientes;
import Barbearia.Gerenciadores.Barbearia;
import Barbearia.Gerenciadores.GerenciadorDeClientes;

public class AppBarbearia {
    public static void Execute() throws InterruptedException{
        GerenciadorDeClientes gerenciadorDeClientes = new GerenciadorDeClientes();
        var pos = new PointOfSale();
        ScheduledExecutorService threadpool = Executors.newScheduledThreadPool(1);

        threadpool.scheduleWithFixedDelay(() -> {
            var barbearia = new Barbearia(gerenciadorDeClientes,pos);
            var ger = new GeradorDeClientes(gerenciadorDeClientes.getClientes());
        } , 0, 1, TimeUnit.SECONDS);
    }
}
