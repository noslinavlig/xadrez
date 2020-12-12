
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;
    private int jogada;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
        this.jogada = 0;
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    private void criarPecas() {
        
        int i, j;
        Casa casa;
        for (i = 0; i < 8; i++){
            for(j = 0; j < 8; j++){
                switch(j){
                    case 0, 7:
                        switch(i){/*
                            case 0: case 7:
                                casa = tabuleiro.getCasa(i, j);
                                Torre torre;
                                if(j == 0)
                                    torre = new Torre(casa, Peca.TORRE_BRANCA);
                                else
                                    torre = new Torre(casa, Peca.TORRE_PRETA); 
                            break;
                            case 1: case 6:
                                casa = tabuleiro.getCasa(i, j);
                                Cavalo cavalo;
                                if(j == 0)
                                    cavalo = new Cavalo(casa, Peca.CAVALO_BRANCO);
                                else
                                    cavalo = new Cavalo(casa, Peca.CAVALO_PRETO);
                            break;
                            case 2: case 5:
                                casa = tabuleiro.getCasa(i, j);
                                Bispo bispo;
                                if(j == 0)
                                    bispo = new Bispo(casa, Peca.BISPO_BRANCO);
                                else
                                    bispo = new Bispo(casa, Peca.BISPO_PRETO);
                            break;*/
                            case 3:
                                casa = tabuleiro.getCasa(i, j);
                                Rainha rainha;
                                if(j == 0)
                                    rainha = new Rainha(casa, Peca.RAINHA_BRANCA);
                                else
                                    rainha = new Rainha(casa, Peca.RAINHA_PRETA);
                            break;
                            case 4:
                                casa = tabuleiro.getCasa(i, j);
                                Rei rei;
                                if(j == 0)
                                    rei = new Rei(casa, Peca.REI_BRANCO);
                                else
                                    rei = new Rei(casa, Peca.REI_PRETO);
                            break;

                        }
                        break;
                    case 1:
                        Peao peao;
                        casa = tabuleiro.getCasa(i, j);
                        peao = new Peao(casa, Peca.PEAO_BRANCO);
                        break;
                    case 6:
                        casa = tabuleiro.getCasa(i, j);
                        peao = new Peao(casa, Peca.PEAO_PRETO);
                        break;
                    default:
                        break;
                }
            }
        }    
        
    
    }
    
    /**
     * Comanda uma Pe�a na posicao (x.getPosicaoX(), x.getPosicaoY()) fazer um movimento 
     * para (y.getPosicaoX(), y.getPosicaoY()).
     * 
     * @param x.getPosicaoX() linha da Casa de origem.
     * @param x.getPosicaoY() coluna da Casa de origem.
     * @param y.getPosicaoX() linha da Casa de destino.
     * @param y.getPosicaoY() coluna da Casa de destino.
     */

     //METODO NOVO SUBSTITUI moverPeca()
    public void fazerJogada(CasaGUI P, CasaGUI Q) {

        Casa origem = tabuleiro.getCasa(P.getPosicaoX(), P.getPosicaoY());
        Casa destino = tabuleiro.getCasa(Q.getPosicaoX(), Q.getPosicaoY());
        Peca peca = origem.getPeca();
        
        if (this.jogada %2 ==0 && peca.getCor().equals("BRANCO") && peca.mover(destino, this.tabuleiro)){
                this.jogada++;
        
        //Testa se a rodada é das pretas e se a peça é preta
        } else if (this.jogada %2 !=0 && peca.getCor().equals("PRETO") && peca.mover(destino, this.tabuleiro)){
                this.jogada++;
        }
    
    }
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
