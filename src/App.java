import java.util.Scanner;

import Barbearia.AppBarbearia;
import PapaiNoel.AppPapaiNoel;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Qual o sistema que voce gostaria de executar ?");
            System.out.println("(1) - Babearia");
            System.out.println("(2) - PapaiNoel");

            var sc = new Scanner(System.in);
            var opcao = sc.nextInt();

            switch(opcao){
                case 1 : 
                    AppBarbearia.Execute();
                    break;
                case 2 :
                    AppPapaiNoel.Execute();
                    break;
                default :
                    throw new Exception("Deve escolher uma opcao entre 1 e 2");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
