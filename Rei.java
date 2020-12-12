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
    public Rei(Casa casa, int tipo){
        super(casa, tipo);
    }

    @Override
    public boolean mover(Casa destino){

        int distancia = this.deslocamentoModulo(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());

        String cordestino;
        if (destino.possuiPeca())
            cordestino = destino.getPeca().getCor();
        else
            cordestino = null;

        if(distancia == 1 && (!destino.possuiPeca() || !this.getCor().equals(cordestino)) ){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            return true;
        } else 
            return false;
            

    }
    
}