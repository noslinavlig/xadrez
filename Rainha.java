/**
 * Escreva a descrição da classe Peao aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Rainha extends Peca {

    /**
     * COnstrutor para objetos da classe Peao
     */
    public Rainha(Casa casa, int tipo){
        super(casa, tipo);
    }

    @Override
    public boolean mover(Casa destino, Tabuleiro tabuleiro){

        String direcao = this.deslocamentoDirecao(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());
        boolean condicaogeral = !destino.possuiPeca() || !this.getCor().equals(destino.getCor());
        boolean caminholivre = tabuleiro.caminhoLivre(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY(), direcao);
        System.out.println(caminholivre);
        if( (direcao.equals("vertical") || direcao.equals("diagonal") || direcao.equals("horizontal")) && condicaogeral && caminholivre){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            return true;
        } else 
            return false;
            

    }
    
}