public class JogoDaVelha_PC {

    private JogoDaVelha_Mapa mapa;
    private char letra = 'X';

    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa){
        this.mapa = mapa;
    }

    public boolean joga(){
        int l = mapa.sortear(0, 2);
        int c = mapa.sortear(0, 2);
        while (!mapa.jogar(l, c, letra)){
            l = mapa.sortear(0, 2);
            c = mapa.sortear(0, 2);
        }
        System.out.println("PC[" + l + "," + c + "]");
        return true;
    }

    public char getLetra() {
        return this.letra;
    }
    
}
