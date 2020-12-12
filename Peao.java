/**
 * Escreva a descrição da classe Peao aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Peao extends Peca {

    /**
     * COnstrutor para objetos da classe Peao
     */
    public Peao(Casa casa, int tipo){
        super(casa, tipo);
    }

    @Override
    public boolean mover(Casa destino){
        
        String direcao = this.deslocamentoDirecao(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());
        int distancia = this.deslocamentoModulo(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());
        boolean sentidopositivo = this.casa.getY() < destino.getY();
        
        String cordestino;
        if (destino.possuiPeca())
            cordestino = destino.getPeca().getCor();
        else
            cordestino = null;

        if(this.getCor().equals("PRETO")){//Caso seja peao preto, essas serao as regras
            //Verificando se é primeira jogada
            if(this.casa.getY() == 6 && distancia <= 2 && !sentidopositivo && direcao.equals("vertical")){
                casa.removerPeca();
                destino.colocarPeca(this);
                casa = destino;
                return true;
            } else //Movimento genérico do peão
            if(distancia == 1 && !sentidopositivo && (direcao.equals("vertical") && !destino.possuiPeca() || (direcao.equals("diagonal") && !this.getCor().equals(cordestino) && destino.possuiPeca())) ){
                casa.removerPeca();
                destino.colocarPeca(this);
                casa = destino;
                return true;
            } else {
                return false;
            }

        } else //Regras para peoes brancos
        //Verificando se é primeira jogada
        if(this.casa.getY() == 1 && distancia <= 2 && sentidopositivo && direcao.equals("vertical")){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            return true;
        } else //Movimento genérico do peão
        
        if(distancia == 1 && sentidopositivo && (direcao.equals("vertical") && !destino.possuiPeca() || (direcao.equals("diagonal") && destino.possuiPeca() && !this.getCor().equals(cordestino) && destino.possuiPeca())) ){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            return true;
        } else {
            return false;
        }
            

    }
    
}