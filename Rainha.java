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
    public Rainha(Casa casa, int tipo, Tabuleiro tabuleiro){
        super(casa, tipo, tabuleiro);
    }

    @Override
    public boolean mover(Casa destino){

        String direcao = this.deslocamentoDirecao(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());
        boolean condicaogeral = !destino.possuiPeca() || !this.getCor().equals(destino.getCor());
        boolean caminholivre = this.tabuleiro.caminhoLivre(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY(), direcao);
        
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