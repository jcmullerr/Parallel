package PapaiNoel.Base;

import java.util.concurrent.ThreadLocalRandom;

import PapaiNoel.Enums.EEstadoPapaiNoel;
import PapaiNoel.Interfaces.IOperation;
import PapaiNoel.Interfaces.IVoidOperation;

public class PapaiNoel extends Thread{
    private EEstadoPapaiNoel _estadoPapaiNoel;
    private IVoidOperation _operacaoRena;
    private IVoidOperation _operacaoElfos;

    public PapaiNoel(
        IVoidOperation operacaoRena, 
        IVoidOperation operacaoElfos
    )
    {
        super("PapaiNoel");
        _estadoPapaiNoel = EEstadoPapaiNoel.Dormindo;
        _operacaoElfos = operacaoElfos;
        _operacaoRena = operacaoRena;
        start();
    }

    public boolean EstaOcupado() {
        return _estadoPapaiNoel != EEstadoPapaiNoel.Acordado;
    }

    public void SetEstado(EEstadoPapaiNoel estado){
        _estadoPapaiNoel = estado;
    }

    public boolean EstaDormindo(){
        return _estadoPapaiNoel == EEstadoPapaiNoel.Dormindo;
    }

    public void Acordar() throws Exception{
        if(!EstaDormindo())
            throw new Exception("O papai noel não esta dormindo");
        
        Thread.sleep(ThreadLocalRandom.current().nextInt(700,1001));
        _estadoPapaiNoel = EEstadoPapaiNoel.Acordado;
    }

    public void AjudarElfos() throws InterruptedException{
        System.out.println("Papai noel esta ajudando os elfos");
        Thread.sleep(ThreadLocalRandom.current().nextInt(700,1001));
    }

    public void DistribuirPresentes() throws InterruptedException{
        System.out.println("Papai noel esta amarrando as renas ao treno");
        Thread.sleep(ThreadLocalRandom.current().nextInt(700,1001));
        System.out.println("Papai noel esta distribuindo presentes");
        Thread.sleep(ThreadLocalRandom.current().nextInt(700,1001));
        System.out.println("Papai noel esta desamarrando as renas do treno");
        Thread.sleep(ThreadLocalRandom.current().nextInt(700,1001));
        _estadoPapaiNoel = EEstadoPapaiNoel.Acordado;
    }
    
    public void run(){
        while(true){
            if(!EstaDormindo())
                try{
                    if(_estadoPapaiNoel == EEstadoPapaiNoel.AjudandoElfos)
                        AjudarElfos();
                    else if(_estadoPapaiNoel == EEstadoPapaiNoel.DistribuindoPresentes)
                        DistribuirPresentes();
                }
                catch(Exception e){
                    System.out.println("Deu ruim");
                    e.printStackTrace();
                }
        }
    }
}
