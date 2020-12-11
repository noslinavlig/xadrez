
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
        
        for(int i = 0; i<8;i++){
          Casa casa = tabuleiro.getCasa(i,1);
          Peao peao = new Peao(casa, 3);
        }

        for(int i = 0; i<8;i++){
            Casa casa = tabuleiro.getCasa(i,6);
            Peao peao = new Peao(casa, -3);
          }
       
        Casa casa1 = tabuleiro.getCasa(0, 0);
        Torre torre1 = new Torre(casa1, 4);

        Casa casa2 = tabuleiro.getCasa(7, 0);
        Torre torre2 = new Torre(casa2, 4);

        Casa casa3 = tabuleiro.getCasa(0, 7);
        Torre torre3 = new Torre(casa3, -4);

        Casa casa4 = tabuleiro.getCasa(7, 7);
        Torre torre4 = new Torre(casa4, -4);
        

        Casa casa5 = tabuleiro.getCasa(1,0);
        Cavalo cavalo1 = new Cavalo(casa5, 5);

        Casa casa6 = tabuleiro.getCasa(6,0);
        Cavalo cavalo2 = new Cavalo(casa6, 5);

        Casa casa7 = tabuleiro.getCasa(1,7);
        Cavalo cavalo3 = new Cavalo(casa7, -5);

        Casa casa8 = tabuleiro.getCasa(6,7);
        Cavalo cavalo4 = new Cavalo(casa8, -5);
        
        
        
        Casa casa9 = tabuleiro.getCasa(3,0);
        Rainha rainha1 = new Rainha(casa9, Peca.RAINHA_BRANCA);
        
        Casa casa10 = tabuleiro.getCasa(4,0);
        Rei rei1 = new Rei(casa10, Peca.REI_BRANCO);
        
        Casa casa11 = tabuleiro.getCasa(3,7);
        Rainha rainha2 = new Rainha(casa11, Peca.RAINHA_PRETA);
        
        Casa casa12 = tabuleiro.getCasa(4,7);
        Rei rei2 = new Rei(casa12, Peca.REI_PRETO);
         
        
        
        
        
        Casa casa13 = tabuleiro.getCasa(2,0);
        Bispo bispo1 = new Bispo(casa13, 6);

        Casa casa14 = tabuleiro.getCasa(5,0);
        Bispo bispo2 = new Bispo(casa14, 6);

        Casa casa15 = tabuleiro.getCasa(2,7);
        Bispo bispo3 = new Bispo(casa15, -6);
        
        Casa casa16 = tabuleiro.getCasa(5,7);
        Bispo bispo4 = new Bispo(casa16, -6);        
        
    
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
        
        if (this.jogada %2 ==0 && peca.getCor().equals("BRANCO")){
            if(peca.movimentoPermitido(P.getPosicaoX(), P.getPosicaoY(), Q.getPosicaoX(), Q.getPosicaoY(), this.tabuleiro) &&
                 (!destino.possuiPeca() || !destino.getPeca().eBranco())){
                
                peca.mover(destino);
                this.jogada++;
                System.out.println(destino.getPeca().eBranco());
                System.out.println("VEZ DAS PRETAS");
                 

            }
        
        //Testa se a rodada é das pretas e se a peça é preta
        } else if (this.jogada %2 !=0 && peca.getCor().equals("PRETO")){
            if(peca.movimentoPermitido(P.getPosicaoX(), P.getPosicaoY(), Q.getPosicaoX(), Q.getPosicaoY(), this.tabuleiro) &&
                 (!destino.possuiPeca() || destino.getPeca().eBranco())){
                
                peca.mover(destino);
                this.jogada++;
                System.out.println(destino.getPeca().eBranco());
                System.out.println("VEZ DAS BRANCAS");

            }
        }
    
    }
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
