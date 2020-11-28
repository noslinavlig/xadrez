
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
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

        }

    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        switch(Math.abs(peca.getTipo())){
            case 3:
                
            
            // se for primeira jogada
              if(origemY == 1) {
                  //restringindo o primeiro movimento restringindo a diagonal
                if(destinoY <= origemY + 2 && destinoY > 0 && origemX == destinoX)
                    peca.mover(destino);
                
              } else if (destinoY == origemY + 1 && origemX == destinoX) {
                  peca.mover(destino);
              }
              break;
            case 4:
                if(destinoX == origemX || destinoY == origemY)
                    peca.mover(destino);
                break;
            case 5:
                if(Math.abs(destinoY - origemY) + Math.abs(destinoX - origemX) == 3 && origemX != destinoX && origemY != destinoY)
                    peca.mover(destino);
                break;
            case 7:
                if((Math.abs(destinoX - origemX) == Math.abs(destinoY - origemY)) ||
                    destinoX == origemX || destinoY == origemY)
                    peca.mover(destino);
                break;
            case 8:
                if(Math.abs(destinoY - origemY) + Math.abs(destinoX - origemX) == 1 || Math.abs(destinoY - origemY) == 1 && Math.abs(destinoX - origemX) == 1)
               peca.mover(destino);
               break;
        
        }
    }
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
