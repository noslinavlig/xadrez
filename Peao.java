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
    public Peao(Casa casa, int tipo, Tabuleiro tabuleiro){
        super(casa, tipo, tabuleiro);
    }

    @Override
    public boolean mover(Casa destino){
        
        String direcao = this.deslocamentoDirecao(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());
        int distancia = this.deslocamentoModulo(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY());
        boolean sentidopositivo = this.casa.getY() < destino.getY();
        boolean caminholivre = this.tabuleiro.caminhoLivre(this.casa.getX(), this.casa.getY(), destino.getX(), destino.getY(), direcao);

        boolean restricaopreto = (distancia == 1 && !sentidopositivo && (direcao.equals("vertical") && !destino.possuiPeca() || (direcao.equals("diagonal") && destino.getCor().equals("BRANCO"))));
        boolean restricaobranco = (distancia == 1 && sentidopositivo && (direcao.equals("vertical") && !destino.possuiPeca() || (direcao.equals("diagonal") && destino.getCor().equals("PRETO"))));

        if(this.getCor().equals("PRETO")){//Caso seja peao preto, essas serao as regras
            //Verificando se é primeira jogada
            if(this.casa.getY() == 6 && distancia <= 2 && !sentidopositivo && direcao.equals("vertical") && !destino.possuiPeca() && caminholivre ||  restricaopreto){
                casa.removerPeca();
                destino.colocarPeca(this);
                casa = destino;
                return true;
            } else //Movimento genérico do peão
            if(restricaopreto){
                casa.removerPeca();
                destino.colocarPeca(this);
                casa = destino;
                return true;
            } else {
                return false;
            }

        } else //Regras para peoes brancos
        //Verificando se é primeira jogada
        if(this.casa.getY() == 1 && distancia <= 2 && sentidopositivo && direcao.equals("vertical") && !destino.possuiPeca() && caminholivre || restricaobranco){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            return true;
        } else //Movimento genérico do peão
        
        if(restricaobranco){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            return true;
        } else {
            return false;
        }
            

    }
    
}