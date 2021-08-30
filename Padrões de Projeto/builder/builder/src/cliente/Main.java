package cliente;

import builder.Director;
import Instrumentos.Violao;
import interfaces.Builder;
import java.util.Scanner;

/*
 *
 */

/**
 *
 * @author Laranja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        double pagamento = 0;
        int tipoViolao;
        
        System.out.println("Escolha um violão:"
                + "\n1 - Violão Clássico"
                + "\n2 - Violão Folk"
                + "\n3 - Violão Flet"
                + "\n4 - Violao Jumbo"
                + "\n5 - Violão 7 Cordas"
                + "\n6 - Violão 12 Cordas"
                + "\n7 - Violão Zero"
                + "\n8 - Violão Duplo Zero"
                + "\n9 - Violão Triplo Zero");
    
        System.out.print("Violão: ");
        tipoViolao = scan.nextInt();
        
        Violao violao = escolherViolao(tipoViolao);
        
        if(violao == null){
            System.out.println("Opção invalida! Comece o processo de compra novamente!");
            System.exit(0);
        }
        
        System.out.println("\n--------------------------------");
        System.out.println("Detalhes produto: \n" + violao.detalhesProduto());
        System.out.println("--------------------------------\n");
        
        System.out.println("O preço do violão é: " + violao.getPreco() + "!");
        System.out.println("Efetue o pagamento para pegar seu produto");
        System.out.print("Pagar: R$ ");
        pagamento = scan.nextFloat();
        
        if(pagamento >= violao.getPreco()){
            if(pagamento > violao.getPreco())
                System.out.println("Troco: R$ " + (pagamento - violao.getPreco()));
            System.out.println("Compra executada com sucesso! Volte sempre!");
        } else{
            System.out.println("Não foi possivel completar a compra!");
        }
    }
    
    private static Violao escolherViolao(int tipoViolao){
        Builder builder = null;
        
        switch(tipoViolao){
            case 1:
                builder = Director.constructClassico();
                break;
            case 2: 
                builder = Director.constructFolk();
                break;
            case 3: 
                builder = Director.constructFlet();
                break;
            case 4: 
                builder = Director.constructJumbo();
                break;
            case 5: 
                builder = Director.constructSeteCordas();
                break;
            case 6:
                builder = Director.constructDozeCordas();
                break;
            case 7:
                builder = Director.constructZero();
                break;
            case 8:
                builder = Director.constructDuploZero();
                break;
            case 9: 
                builder = Director.constructTriploZero();
                break;
        }
        
        
        return (builder != null) ?  builder.getViolao() : null;
    }
}
