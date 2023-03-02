/**
 * Esta classe representa um objeto mapa, ela gerencia as operações que são
 * diirecionadas ao mesmo, como imprimir, jogar, limpar, etc...
 */
public class JogoDaVelha_Mapa{

    private char[][] mapa = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};

    /**
     * Sorteia um numero inteiro entre o valor inicial e o valor final.
     *
     * @param inicio O valor mínimo.
     * @param fim    O valor máximo.
     * @return O valor sorteado.
     */
    public int sortear(int inicio, int fim){
        return inicio + (int)(Math.random() * ((fim - inicio) + 1));
    }

    /**
     * Limpa o mapa.
     */
    public void limpaMapa(){
        //Linhas
        for (int i = 0; i < mapa.length; i++){
            //Colunas
            for (int j = 0; j < mapa.length; j++){
                mapa [i][j] = ' ';
            }
        }
    }

    /**
     * Imprime o mapa para o usuário.
     *
     * @param jogada O round em que está o jogo.
     */
    public void desenha(int jogada){
        String linha = "-------------";
        //Linhas
        for (int i = 0; i < mapa.length; i++){
            if (i == 0){
                System.out.println(linha + " .. jogada: " + jogada);
            } else {
                System.out.println(linha);
            }
            //Colunas
            for (int j = 0; j < mapa.length; j++){
                if (j == 0){
                    System.out.print("| " + mapa[i][j] + " ");
                } else if (j == mapa.length-1){
                    System.out.println(mapa[i][j] + " |");
                } else {
                    System.out.print("| " + mapa[i][j] + " | ");
                }
            }
        }
        System.out.println(linha.concat(linha));
    }

    /**
     * Jogar/definir uma jogada no mapa.
     *
     * @param l       A linha.
     * @param c       A coluna.
     * @param jogador O caractere do jogador
     * @return True se a jogada é valida, false caso contrário.
     */
    public boolean jogar(int l, int c, char jogador){
        if (mapa[l][c] != ' ') {
            return false;
        }
        else {
            mapa[l][c] = jogador;
            return true;
        }
    }

    /**
     * Verifica se algum jogador ganhou.
     *
     * @param jogador O jogador
     * @return True se o jogador ganhou, false se não ganhou.
     */
    public boolean ganhou(char jogador){
        //Verificando linhas e colunas
        for (int i = 0; i < mapa.length; i ++){
            if (mapa[i][0] == jogador && mapa[i][1] == jogador && mapa[i][2] == jogador){
                return true;
            }
            if (mapa[0][i] == jogador && mapa[1][i] == jogador && mapa[2][i] == jogador){
                return true;
            }
        }
        //Verificando diagonais
        if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador){
            return true;
        }

        if (mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador){
            return true;
        }
        return false;
    }

    /**
     * Verificar se está empatado
     *
     * @return True se empatou, false se não empatou.
     */
    public boolean empatou(){
        for (int i = 0; i < mapa.length; i++){
            for (int j = 0; j < mapa.length; j++){
                if (mapa[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

}