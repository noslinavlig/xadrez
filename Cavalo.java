/**
 * Escreva a descrição da classe Bispo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Cavalo extends Peca{

    /**
     * COnstrutor para objetos da classe Bispo
     */
    public Cavalo(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
        super(casa, tipo, tabuleiro);
    }
    
    @Override
    public boolean mover(Casa destino){

        boolean condicaogeral = !destino.possuiPeca() || !this.getCor().equals(destino.getCor());         
        int distancia = this.deslocamentoModulo(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());
        boolean galope = this.casa.getX() != destino.getX() && this.casa.getY() != destino.getY();
        
        if(distancia == 3 && condicaogeral && galope){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            return true;
        } else 
            return false;
            

    }
}

