import java.util.Scanner;

/**
 * Esta classe é a classe de entrada, ela inicializa as regras e gerencia o jogo.
 */
public class JogoDaVelha {

    private static final JogoDaVelha_Mapa jogoMapa = new JogoDaVelha_Mapa();
    private static final JogoDaVelha_PC jogoPC = new JogoDaVelha_PC(jogoMapa);
    private static final JogoDaVelha_Jogador jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

    /**
     * Esta é a classe princpal, ela é a que inicia a aplicação.
     */
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        boolean flag = true;
        do {
            jogar(teclado);
            System.out.println("Deseja jogar novamente (s/n)?");
            char opc = teclado.next().charAt(0);
            if (opc == 'n'){
                flag = false;
            } else {
                jogoMapa.limpaMapa();
            }
        } while (flag);
    }

    /**
     * Esta função controla os rounds, enquanto ninguem ganhar ou empatar será
     * escolhido alguém para jogar.
     * @param teclado
     */
    private static void jogar(Scanner teclado){
        int count = 0;
        int aleatorio = (int)(Math.random() * 2);

        while (true){
            jogoMapa.desenha(count);
            if (jogoMapa.empatou()){
                System.out.println("... EMPATOU!");
                break;
            }
            if (aleatorio % 2 == 0){
                while (!jogoJogador.joga(teclado)){
                    System.out.println("Jogue novamente!");
                }
                if (jogoMapa.ganhou(jogoJogador.getLetra())){
                    jogoMapa.desenha(++count);
                    System.out.println("...Jogador ganhou!");
                    break;
                }
            } else {
                jogoPC.joga();
                if (jogoMapa.ganhou(jogoPC.getLetra())){
                    jogoMapa.desenha(++count);
                    System.out.println("...PC ganhou!");
                    break;
                }
            }
            aleatorio++;
            count++;
        }  
    }

}
