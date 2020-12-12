/**
 * Escreva a descrição da classe Peao aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Rei extends Peca {

    /**
     * COnstrutor para objetos da classe Peao
     */
    public Rei(Casa casa, int tipo, Tabuleiro tabuleiro){
        super(casa, tipo, tabuleiro);
    }

    @Override
    public boolean mover(Casa destino){

        int distancia = this.deslocamentoModulo(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());

        boolean cordiferente = !this.getCor().equals(destino.getCor());

        if(distancia == 1 && (!destino.possuiPeca() || cordiferente) ){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            return true;
        } else 
            return false;
            

    }
    
}