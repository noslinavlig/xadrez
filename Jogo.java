
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
        var casa16 = tabuleiro.getCasa(4, 0);
        Peca peca16 = new Peca(casa16, Peca.REI_BRANCO);
        Casa casa17 = tabuleiro.getCasa(4, 7);
        Peca peca17 = new Peca(casa17, Peca.REI_PRETO);

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
