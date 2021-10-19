package PapaiNoel.Gerenciadores;

import java.util.ArrayList;

import PapaiNoel.Base.Elfo;
import PapaiNoel.Base.PapaiNoel;
import PapaiNoel.Base.Rena;
import PapaiNoel.Enums.EEstadoPapaiNoel;
import PapaiNoel.Interfaces.IOperation;
import PapaiNoel.Interfaces.IVoidOperation;

public class PoloNorte extends Thread{
    private ArrayList<Elfo> _elfosEmDuvida;
    private ArrayList<Elfo> _elfos;
    private ArrayList<Rena> _renas;
    private ArrayList<Rena> _renasDisponiveis;
    private IOperation<Elfo> _operacaoDeAdicaoElfo = (e) -> {
        if(_elfosEmDuvida.size() == 3)
            return false;
        
        _elfosEmDuvida.add(e);
        return true;
    };
    private IOperation<Rena> _operacaoDeAdicaoRena = (e) -> {
        if(_renasDisponiveis.size() == 9)
            return false;
        
        _renasDisponiveis.add(e);
        return true;
    };
    private IVoidOperation _operacaoDarFeriasAsRenas = () -> {
        for(Rena rena : _renasDisponiveis)
            rena.EntrarDeFerias();
            
        _renasDisponiveis.clear();
    };
    private IVoidOperation _operacaoEnviarElfosDeVoltaAoTrabalho = () -> {
        _elfosEmDuvida.clear();
    };
    private PapaiNoel _papaiNoel;

    public PoloNorte() {
        super("PoloNorte");
        _papaiNoel = new PapaiNoel(
            _operacaoDarFeriasAsRenas,
            _operacaoEnviarElfosDeVoltaAoTrabalho
        );
        CriarElfos();
        CriarRenas();
        start();
    }

    public void run(){
        while(true){
            try{
                if(_renasDisponiveis.size() == 9)
                    AlterarStatusPapaiNoel(EEstadoPapaiNoel.DistribuindoPresentes);
                else if(_elfosEmDuvida.size() == 3)
                    AlterarStatusPapaiNoel(EEstadoPapaiNoel.AjudandoElfos);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private void AlterarStatusPapaiNoel(
        EEstadoPapaiNoel estado
    ) throws Exception
    {
        synchronized(_papaiNoel){
            if(_papaiNoel.EstaDormindo())
                _papaiNoel.Acordar();
            
            while(_papaiNoel.EstaOcupado())
                sleep(100);
            
            _papaiNoel.SetEstado(estado);
        }
    }

    private void CriarRenas() {
        _renas = new ArrayList<>();
        _renasDisponiveis = new ArrayList<>();
        for(var i = 1; i<=10; i++)  
            _renas.add(
                new Rena(
                    "Rena " + i,
                    _operacaoDeAdicaoRena
                )
            );
    }

    private void CriarElfos() {
        _elfos = new ArrayList<>();
        _elfosEmDuvida = new ArrayList<>();
        for(var i = 1; i < 10; i ++)
            _elfos.add(
                new Elfo(
                    "Elfo "+ i,
                    _operacaoDeAdicaoElfo
                )
            );
    }
}
