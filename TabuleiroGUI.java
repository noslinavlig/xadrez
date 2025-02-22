
import java.awt.Color;
import javax.swing.JPanel;

/**
 * Interface Grafica do Tabuleiro do jogo.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class TabuleiroGUI extends JPanel {

    private JanelaPrincipal janela;
    private CasaGUI[][] casas;

    /**
     * Creates new form Tabuleiro
     */
    public TabuleiroGUI() {
        // Construtor sem par�metros requerido pela especifica�?o JavaBeans.
    }

    public TabuleiroGUI(JanelaPrincipal janela) {
        this.janela = janela;
        initComponents();
        criarCasas();
    }

    /**
     * Preenche o tabuleiro com 64 casas
     */
    private void criarCasas() {
        casas = new CasaGUI[8][8];
        // De cima para baixo
        for (int y = 7; y >= 0; y--) {
            // Da esquerda para a direita
            for (int x = 0; x < 8; x++) {
                Color cor = calcularCor(x, y);
                CasaGUI casa = new CasaGUI(x, y, cor, this);
                casas[x][y] = casa;
                add(casa);
            }
        }
    }

    private Color calcularCor(int x, int y) {
        // linha par
        if (x % 2 == 0) {
            // coluna �mpar
            if (y % 2 == 0) {
                return CasaGUI.COR_ESCURA;
            }
            // coluna �mpar
            else {
                return CasaGUI.COR_CLARA;
            }
        }
        // linha �mpar
        else {
            // coluna par
            if (y % 2 == 0) {
                return CasaGUI.COR_CLARA;
            }
            // coluna �mpar
            else {
                return CasaGUI.COR_ESCURA;
            }
        }

        // codigo acima em uma linha
        // return (i%2 + j%2)%2 == 0 ? CasaGUI.COR_ESCURA : CasaGUI.COR_CLARA;
    }

    public void atualizar(Jogo jogo) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                CasaGUI casaGUI = casas[x][y];
                
                Tabuleiro tabuleiro = jogo.getTabuleiro();
                Casa casa = tabuleiro.getCasa(x, y);
                if (casa.possuiPeca()) {
                    Peca peca = casa.getPeca();

                    switch (peca.getTipo()) {
                        //xadrez
                        case Peca.PEAO_BRANCO:
                            casaGUI.desenharPeaoBranco();
                            break;
                        case Peca.PEAO_PRETO:
                            casaGUI.desenharPeaoPreto();
                            break;
                        case Peca.REI_BRANCO:
                            casaGUI.desenharReiBranco();
                            break;
                        case Peca.REI_PRETO:
                            casaGUI.desenharReiPreto();
                            break;
                        case Peca.RAINHA_BRANCA:
                            casaGUI.desenharRainhaBranca();
                            break;
                        case Peca.RAINHA_PRETA:
                            casaGUI.desenharRainhaPreta();
                            break;
                        case Peca.TORRE_BRANCA:
                            casaGUI.desenharTorreBranca();
                            break;
                        case Peca.TORRE_PRETA:
                            casaGUI.desenharTorrePreta();
                            break;
                        case Peca.CAVALO_BRANCO:
                            casaGUI.desenharCavaloBranco();
                            break;
                        case Peca.CAVALO_PRETO:
                            casaGUI.desenharCavaloPreto();
                            break;
                         case Peca.BISPO_BRANCO:
                            casaGUI.desenharBispoBranco();
                            break;
                        case Peca.BISPO_PRETO:
                            casaGUI.desenharBispoPreto();
                            break;  
                            
                        //damas
                        case Peca.PEDRA_BRANCA:
                            casaGUI.desenharPedraBranca();
                            break;
                        case Peca.DAMA_BRANCA:
                            casaGUI.desenharDamaBranca();
                            break;
                        case Peca.PEDRA_VERMELHA:
                            casaGUI.desenharPedraVermelha();
                            break;
                        case Peca.DAMA_VERMELHA:
                            casaGUI.desenharDamaVermelha();
                            break;
                    }
                }
                else {
                    casaGUI.apagarPeca();
                }
            }
        }
    }

    public JanelaPrincipal getJanela() {
        return janela;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(8, 8));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
