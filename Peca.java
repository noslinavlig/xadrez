

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
    public static final int BISPO_BRANCO = 6;
    public static final int BISPO_PRETO = -6;
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

    //Retorna uma String com o nome da direção do movimento
    private String deslocamentoDirecao(int Px, int Py, int Qx, int Qy){
        if(Px == Qx)
            return "vertical";
        else if(Py == Qy)
            return "horizontal";
        else if(Math.abs(Qx - Px) == Math.abs(Qy - Py))
            return"diagonal" ;
        else
            return "outro";
    }

    //Retorna o número de casas de um movimento
    private int deslocamentoModulo(int Px, int Py, int Qx, int Qy){
        //Se for diagonal, contamos o numero de casas através de um único eixo
        if (Math.abs(Qx - Px) == Math.abs(Qy - Py))
            return Math.abs(Qx - Px);
        //Retorna o número de casas se o movimento for vertical ou horizontal
        else
            return Math.abs(Qx - Px) + Math.abs(Qy - Py);
    }

    //METODO NOVO TESTA MOVIMENTAÇÃO INDICADA
        public boolean movimentoPermitido(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){
            String direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy);
            int distancia = this.deslocamentoModulo(Px, Py, Qx, Qy);
            switch(Math.abs(this.getTipo())){
                case 3:
                    Casa destino = tabuleiro.getCasa(Qx, Qy);
                    boolean sentidopositivo = Py < Qy;                    
                    if(this.getTipo() == -3){//Caso seja peao preto, essas serao as regras

                        //Verificando se é primeira jogada
                        if(Py == 6 && distancia <= 2 && direcao.equals("vertical"))
                            return true;
                        else //Movimento genérico do peão

                        if(distancia == 1 && !sentidopositivo && ((direcao.equals("diagonal")) && destino.possuiPeca() 
                                                                    || direcao.equals("vertical") && !destino.possuiPeca()) )
                            return true;
                        else 
                            return false;

                    } else //Regras para peoes brancos

                        //Verificando se é primeira jogada
                        if(Py == 1 && distancia <= 2 && direcao.equals("vertical")){
                            return true;
                        } else //Movimento genérico do peão
                        if(distancia == 1 && sentidopositivo && ((direcao.equals("diagonal")) && destino.possuiPeca() 
                                                                    || direcao.equals("vertical") && !destino.possuiPeca()) ){
                            return true;
                        }else
                            return false;
                
                case 4:
                    if((direcao.equals("horizontal") || direcao.equals("vertical")) && tabuleiro.caminhoLivre(Px, Py, Qx, Qy, direcao))
                        return true;
                    else 
                        return false;
                case 5:
                    if(distancia == 3 && Px != Qx && Py != Qy)
                        return true;
                    else 
                        return false;
                case 6:
                    if(direcao.equals("diagonal") && tabuleiro.caminhoLivre(Px, Py, Qx, Qy, direcao))
                        return true;
                    else
                        return false;
                        
                case 7:
                    if((direcao.equals("horizontal") || direcao.equals("diagonal") || direcao.equals("vertical"))
                        &&tabuleiro.caminhoLivre(Px, Py, Qx, Qy, direcao))
                        return true;
                    else 
                        return false;
                case 8:
                    if(distancia == 1)
                        return true;
                    else 
                        return false;
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
