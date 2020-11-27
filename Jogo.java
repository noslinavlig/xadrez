
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

        //Adicionar os reis ao tabuleiro 
        Casa casa16 = tabuleiro.getCasa(4, 0);
        Peca peca16 = new Peca(casa16, Peca.REI_BRANCO);
        Casa casa17 = tabuleiro.getCasa(4, 7);
        Peca peca17 = new Peca(casa17, Peca.REI_PRETO);

        //Adicionar as rainhas ao tabuleiro 
        Casa casa18 = tabuleiro.getCasa(3, 0);
        Peca peca18 = new Peca(casa18, Peca.RAINHA_BRANCA);
        Casa casa19 = tabuleiro.getCasa(3, 7);
        Peca peca19 = new Peca(casa19, Peca.RAINHA_PRETA);
            
        //Adicionar os cavalos ao tabuleiro
        
        Casa casa20 = tabuleiro.getCasa(1,0);
        Peca peca20 = new Peca(casa20, Peca.CAVALO_BRANCO);
        Casa casa21 = tabuleiro.getCasa(6,0);
        Peca peca21 = new Peca(casa21, Peca.CAVALO_BRANCO);
        Casa casa22 = tabuleiro.getCasa(1,7);
        Peca peca22 = new Peca(casa22, Peca.CAVALO_PRETO);
        Casa casa23 = tabuleiro.getCasa(6,7);
        Peca peca23 = new Peca(casa23, Peca.CAVALO_PRETO);

        //Adicionar as torres ao tabuleiro
        Casa casa24 = tabuleiro.getCasa(0,0);
        Peca peca24 = new Peca(casa24, Peca.TORRE_BRANCA);
        Casa casa25 = tabuleiro.getCasa(7,0);
        Peca peca25 = new Peca(casa25, Peca.TORRE_BRANCA);
        Casa casa26 = tabuleiro.getCasa(0,7);
        Peca peca26 = new Peca(casa26, Peca.TORRE_PRETA);
        Casa casa27 = tabuleiro.getCasa(7,7);
        Peca peca27 = new Peca(casa27, Peca.TORRE_PRETA);


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
        peca.mover(destino);        
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
