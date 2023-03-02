import java.util.Scanner;

/**
 * Esta classe representa um jogador, ela suporta as ações do mesmo
 */
public class JogoDaVelha_Jogador {

    private JogoDaVelha_Mapa mapa;
    private char letra = 'O';

    public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
    }

    /**
     * Esta função controla o sistema de escolha de jogo do jogador.
     * @param teclado objeto Scanner.
     * @return True se a jogada foi válida, False caso contrário.
     */
    public boolean joga(Scanner teclado) {
        System.out.println("Jogador ..");
        System.out.println("linha:");
        int l = teclado.nextInt();
        System.out.println("coluna:");
        int c = teclado.nextInt();
        //Verificar jogada
        if ((l < 0 || l > 2) || (c < 0 || c > 2)){
            System.out.println("Jogada inválida!");
            return false;
        }
        return mapa.jogar(l, c, letra);
    }

    public char getLetra() {
        return this.letra;
    }

}
