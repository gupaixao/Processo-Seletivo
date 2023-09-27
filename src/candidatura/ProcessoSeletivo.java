package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Gustavo", "Marcia", "Felipe","Julia", "Paulo", "Augusto"};
        for (String candidato: candidatos) {
             entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
            System.out.println("Contato Realizados com Sucesso");

        }while(continuarTentando && tentativasRealizadas<3);

        if (!atendeu)
                  System.out.println("Conseguimos contato com o  " + candidato + "Na " + tentativasRealizadas + " Tentativa");
        else          
                  System.out.println("Não conseguimos contato com o  " + candidato + " Número maximo de tentativas " + tentativasRealizadas + " Realizada");
    }

   //metrodo auxiliar
   static boolean atender() {
    return new Random().nextInt(3)==1;
   }

     static void imprimirSelecionados() {
        String [] candidatos = {"Gustavo", "Marcia", "Felipe","Julia", "Paulo", "Augusto"};

        System.out.println("Imprimindo a lista de candidatos informandos o indice do elemento");

        for(int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidatos de nº " + (indice+1) + " é o " + candidatos[indice]);
        }    
        
        System.out.println("Forma abrevida de interação for each");

        for (String candidato: candidatos) {
            System.out.println("O candidatos selecionado foi " + candidato);
        }
    }
    static void selecaoCandidatos() {
        String [] candidatos = {"Gustavo", "Marcia", "Felipe","Julia", "Paulo", "Augusto", "Pedro", "Junior"};
        int candidatosSelecionados = 0;
        int candidatosAtual=0;
        double salarioBase=2000.0;
        while (candidatosSelecionados <5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPrentendido = valorPrentendido();

            System.out.println("O candidato " + candidato + "Solicitou este valor de saário " + salarioPrentendido );
            if(salarioBase >= salarioPrentendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga ");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }

    }
    static double valorPrentendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);

    }
    static void analisarCandidato(double salarioPrentendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPrentendido) {
            System.out.println("Ligar para o Candidato");
    }else if (salarioBase==salarioPrentendido)
            System.out.println("Ligar para o candidato com contra proposta");
        else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }

    }

}    