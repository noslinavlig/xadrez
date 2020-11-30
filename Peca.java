
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
    public static final int PEDRA_BRANCA = 1;
    public static final int DAMA_BRANCA = -1;
    public static final int PEDRA_VERMELHA = 2;
    public static final int DAMA_VERMELHA = -2;
    //xadrez
    public static final int PEAO_BRANCO = 3;
    public static final int PEAO_PRETO = -3;
    public static final int TORRE_BRANCA = 4;
    public static final int TORRE_PRETA = -4;
    public static final int CAVALO_BRANCO = 5;
    public static final int CAVALO_PRETO = -5;
    /*
    * Bispo aqui
    */
    public static final int RAINHA_BRANCA = 7;
    public static final int RAINHA_PRETA = -7;
    public static final int REI_BRANCO = 8;
    public static final int REI_PRETO = -8;
    
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

    //METODO NOVO TESTA MOVIMENTAÇÃO INDICADA
    public boolean movimentoPermitido(int Px, int Py, int Qx, int Qy){
        switch(Math.abs(this.getTipo())){
            case 3:
                if(Py == 1)
                    if(Qy - Py <= 2 && Px == Qx){
                        return true;
                    } else 
                        return false;
                if(Qy - Py < 2 && Px == Qx)
                    return true;
                else return false;
            default:
                return false;
            }
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
