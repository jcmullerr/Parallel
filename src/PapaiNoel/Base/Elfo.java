package PapaiNoel.Base;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.text.html.HTMLDocument.BlockElement;

import PapaiNoel.Interfaces.IOperation;

public class Elfo extends Thread{
    private IOperation<Elfo> _operacao;
    private boolean _estaEmDuvida;

    public Elfo(String nome, IOperation<Elfo> operacao) {
        super(nome);
        _operacao = operacao;
        _estaEmDuvida = false;
        start();
    }

    public void EntrarNaFilaDeDuvidas(){
        _estaEmDuvida = _operacao.Operar(this);
    }

    @Override
    public void run() {
        while(true){
            if(_estaEmDuvida)
                continue;
            
            try {
                sleep(ThreadLocalRandom.current().nextInt(700,1001));
                if(DeveEntrarEmDuvida())
                    EntrarNaFilaDeDuvidas();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean DeveEntrarEmDuvida() {
        return new Random().nextInt(100) > 65;
    }
}
