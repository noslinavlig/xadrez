
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Peca {

    //Inteiros identificadores das pecas
    //damas
    public static final int PEDRA_BRANCA = 0;
    public static final int DAMA_BRANCA = 1;
    public static final int PEDRA_VERMELHA = 2;
    public static final int DAMA_VERMELHA = 3;
    //xadrez
    public static final int PEAO_BRANCO = 4;
    public static final int PEAO_PRETO = 5;
    public static final int TORRE_BRANCA = 6;
    public static final int TORRE_PRETA = 7;
    public static final int CAVALO_BRANCO = 8;
    public static final int CAVALO_PRETO = 9;
    /*
    * Bispo aqui
    */
    public static final int RAINHA_BRANCA = 12;
    public static final int RAINHA_PRETA = 13;
    public static final int REI_BRANCO = 14;
    public static final int REI_PRETO = 15;
    
    private Casa casa;
    private int tipo;

    public Peca(Casa casa, int tipo) {
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
    }
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }

    /**
     * Valor    Tipo
     *   0   Branca (Pedra)
     *   1   Branca (Dama)
     *   2   Vermelha (Pedra)
     *   3   Vermelha (Dama)
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
}
