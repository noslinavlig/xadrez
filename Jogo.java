
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
        //Adicionar peões brancos no tabuleiro
        for (int i = 0; i < 8; i++) {
            Casa casai = tabuleiro.getCasa(i, 1);
            Peca pecai = new Peca(casai, Peca.PEAO_BRANCO);
        }

        //Adicionar peões pretos no tabuleiro
        for (int j = 0; j < 8; j++) {
        int i = j + 8;
        Casa casai = tabuleiro.getCasa(j, 6);
        Peca pecai = new Peca(casai, Peca.PEAO_PRETO);
        
        //Adicionar as rainhas ao tabuleiro 
        var casa14 = tabuleiro.getCasa(3, 0);
        Peca peca14 = new Peca(casa14, Peca.RAINHA_BRANCA);
        Casa casa15 = tabuleiro.getCasa(3, 7);
        Peca peca15 = new Peca(casa15, Peca.RAINHA_PRETA);

        //Adicionar os reis ao tabuleiro 
        var casa16 = tabuleiro.getCasa(4, 0);
        Peca peca16 = new Peca(casa16, Peca.REI_BRANCO);
        Casa casa17 = tabuleiro.getCasa(4, 7);
        Peca peca17 = new Peca(casa17, Peca.REI_PRETO);
            
        //Adicionar os cavalos ao tabuleiro
        Casa casa18 = tabuleiro.getCasa(1,0);
        Peca peca18 = new Peca(casa18, Peca.CAVALO_BRANCO);
        Casa casa19 = tabuleiro.getCasa(6,0);
        Peca peca19 = new Peca(casa19, Peca.CAVALO_BRANCO);
        Casa casa20 = tabuleiro.getCasa(1,7);
        Peca peca20 = new Peca(casa20, Peca.CAVALO_PRETO);
        Casa casa21 = tabuleiro.getCasa(6,7);
        Peca peca21 = new Peca(casa21, Peca.CAVALO_PRETO);
        
        //Adicionar as torres ao tabuleiro
        Casa casa22 = tabuleiro.getCasa(0,0);
        Peca peca22 = new Peca(casa22, Peca.TORRE_BRANCA);
        Casa casa23 = tabuleiro.getCasa(7,0);
        Peca peca23 = new Peca(casa23, Peca.TORRE_BRANCA);
        Casa casa24 = tabuleiro.getCasa(0,7);
        Peca peca24 = new Peca(casa24, Peca.TORRE_PRETA);
        Casa casa25 = tabuleiro.getCasa(7,7);
        Peca peca25 = new Peca(casa25, Peca.TORRE_PRETA);
        
        //Adicionar os bispos ao tabuleiro
        Casa casa26 = tabuleiro.getCasa(2,0);
        Peca peca26 = new Peca(casa26, Peca.BISPO_BRANCO);
        Casa casa27 = tabuleiro.getCasa(5,0);
        Peca peca27 = new Peca(casa27, Peca.BISPO_BRANCO);
        Casa casa28 = tabuleiro.getCasa(2,7);
        Peca peca28 = new Peca(casa28, Peca.BISPO_PRETO);
        Casa casa29 = tabuleiro.getCasa(5,7);
        Peca peca29 = new Peca(casa29, Peca.BISPO_PRETO);

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
        //Testa se é a rodada das brancas, e se a peça é branca
        if (this.jogada %2 ==0 && peca.getTipo() > 0){
            //Verifica se o movimento é permitido baseado no tipo da peca, e se a casa destino esta vazia ou com uma peca de outra cor
            if(peca.movimentoPermitido(P.getPosicaoX(), P.getPosicaoY(), Q.getPosicaoX(), Q.getPosicaoY()) && (!destino.possuiPeca() || destino.getPeca().getTipo() < 0)){
                peca.mover(destino);
                this.jogada++;
            }
        //Testa se a rodada é das pretas e se a peça é preta
        } else if (this.jogada %2 != 0 && peca.getTipo() < 0){
            //Verifica se o movimento é permitido baseado no tipo da peca, e se a casa destino esta vazia ou com uma peca de outra cor
            if(peca.movimentoPermitido(P.getPosicaoX(), P.getPosicaoY(), Q.getPosicaoX(), Q.getPosicaoY()) && (!destino.possuiPeca() || destino.getPeca().getTipo() > 0)){
                peca.mover(destino);
                this.jogada++;
        }
        }


        /*
        switch(Math.abs(peca.getTipo())){
            case 3:
                
            
            // se for primeira jogada
              if(x.getPosicaoY() == 1){ 
                  //restringindo o primeiro movimento restringindo a diagonal
                if(y.getPosicaoY() <= x.getPosicaoY() + 2 && y.getPosicaoY() > 0 && x.getPosicaoX() == y.getPosicaoX())
                    peca.mover(destino);
                } 
               else if (y.getPosicaoY() == x.getPosicaoY() + 1 && x.getPosicaoX() == y.getPosicaoX())
                  peca.mover(destino);
              
              break;
            case 4:
                if(y.getPosicaoX() == x.getPosicaoX() || y.getPosicaoY() == x.getPosicaoY())
                    peca.mover(destino);
                break;
            case 5:
                if(Math.abs(y.getPosicaoY() - x.getPosicaoY()) + Math.abs(y.getPosicaoX() - x.getPosicaoX()) == 3 && x.getPosicaoX() != y.getPosicaoX() && x.getPosicaoY() != y.getPosicaoY())
                    peca.mover(destino);
                break;
            case 7:
                if((Math.abs(y.getPosicaoX() - x.getPosicaoX()) == Math.abs(y.getPosicaoY() - x.getPosicaoY())) ||
                    y.getPosicaoX() == x.getPosicaoX() || y.getPosicaoY() == x.getPosicaoY())
                    peca.mover(destino);
                break;
            case 8:
                if(Math.abs(y.getPosicaoY() - x.getPosicaoY()) + Math.abs(y.getPosicaoX() - x.getPosicaoX()) == 1 || Math.abs(y.getPosicaoY() - x.getPosicaoY()) == 1 && Math.abs(y.getPosicaoX() - x.getPosicaoX()) == 1)
                    peca.mover(destino);
                break;
        }*/    
    }
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
