public class Peao extends Peca{

public Peao(Casa casa, int tipo){
   super(casa, tipo);
 
}

@Override
public boolean movimentoPermitido(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){
    String direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy);
    int distancia = this.deslocamentoModulo(Px, Py, Qx, Qy);
           
              
        Casa destino = tabuleiro.getCasa(Qx, Qy);
        boolean sentidopositivo = Py < Qy;                    
            if(this.getTipo() == -3){//Caso seja peao preto, essas serao as regras

                        //Verificando se é primeira jogada
                        if(Py == 6 && distancia <= 2 && !sentidopositivo && direcao.equals("vertical"))
                            return true;
                        else //Movimento genérico do peão

                        if(distancia == 1 && !sentidopositivo && ((direcao.equals("diagonal")) && destino.possuiPeca() 
                                                                    || direcao.equals("vertical") && !destino.possuiPeca()) )
                            return true;
                        else 
                            return false;

                    } else //Regras para peoes brancos

                        //Verificando se é primeira jogada
                        if(Py == 1 && distancia <= 2 && sentidopositivo && direcao.equals("vertical")){
                            return true;
                        } else //Movimento genérico do peão
                        if(distancia == 1 && sentidopositivo && ((direcao.equals("diagonal")) && destino.possuiPeca() 
                                                                    || direcao.equals("vertical") && !destino.possuiPeca()) ){
                            return true;
                        }else
                            return false;
}


 


}