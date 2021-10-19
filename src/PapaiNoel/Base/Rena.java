package PapaiNoel.Base;

import java.util.Random;

import PapaiNoel.Interfaces.IOperation;

public class Rena extends Thread {
    private IOperation<Rena> _operacao;
    private boolean _estaDeFerias;

    public Rena(String nome, IOperation<Rena> operation) {
        super(nome);
        _operacao = operation;
        _estaDeFerias = true;
        start();
    }

    public void EntrarDeFerias(){
        _estaDeFerias = true;
    }

    public void run(){
        while(true)
            if(_estaDeFerias){
                _estaDeFerias = DeveContinuarDeFerias();
                EntrarNaFilaDeDisponiveis();
            }
    }

    private void EntrarNaFilaDeDisponiveis() {
        if(!_estaDeFerias)
            _operacao.Operar(this);
    }

    private boolean DeveContinuarDeFerias() {
        return new Random().nextInt(100000) < 999000;
    }
}
