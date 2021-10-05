import java.util.Scanner;

import Barbearia.AppBarbearia;

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
                default :
                    throw new Exception("Ainda nao tem essa opcao");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
