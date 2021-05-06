

/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
 public abstract class Peca {

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
    public static final int BISPO_BRANCO = 6;
    public static final int BISPO_PRETO = -6;
    public static final int RAINHA_BRANCA = 7;
    public static final int RAINHA_PRETA = -7;
    public static final int REI_BRANCO = 8;
    public static final int REI_PRETO = -8;
    
    protected Casa casa;
    protected int tipo;
    protected Tabuleiro tabuleiro;

    public Peca(Casa casa, int tipo, Tabuleiro tabuleiro) {
        this.tabuleiro= tabuleiro;
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
    }
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    

    public abstract boolean mover(Casa destino);

    protected String deslocamentoDirecao(int Px, int Py, int Qx, int Qy){
        if(Px == Qx)
            return "vertical";
        else if(Py == Qy)
            return "horizontal";
        else if(Math.abs(Qx - Px) == Math.abs(Qy - Py))
            return"diagonal" ;
        else
            return "outro";
    }

    protected int deslocamentoModulo(int Px, int Py, int Qx, int Qy){
        //Se for diagonal, contamos o numero de casas através de um único eixo
        if (Math.abs(Qx - Px) == Math.abs(Qy - Py))
            return Math.abs(Qx - Px);
        //Retorna o número de casas se o movimento for vertical ou horizontal
        else
            return Math.abs(Qx - Px) + Math.abs(Qy - Py);
    }
    
    public int getTipo() {
        return tipo;
    }

    public String getCor(){
        if (this.getTipo() < 0)
            return "PRETO";
        else   
            return "BRANCO";
    }
    
}

