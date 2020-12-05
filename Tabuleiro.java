
/**
 * O Tabuleiro do jogo. 
 * Respons�vel por armazenar as 64 casas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Tabuleiro {

    private Casa[][] casas;

    public Tabuleiro() {
        casas = new Casa[8][8];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Casa casa = new Casa(x, y);
                casas[x][y] = casa;
            }
        }
    }
    /**
     * @param x linha
     * @param y coluna
     * @return Casa na posicao (x,y)
     */
    
    public Casa getCasa(int x, int y) {
        return casas[x][y];
    }

    public boolean caminhoLivre(int Px, int Py, int Qx, int Qy, String direcao){
        Casa caminho;
        boolean positivoX = Qx > Px;
        boolean positivoY = Qy > Py;
        switch(direcao){
            case "diagonal":
                //Sentido positivo em X e em Y
                if(positivoX && positivoY){

                    int i = 1;
                    do{
                        caminho = this.getCasa(Px + i, Py + i);
                        
                        i++;
                    } while(!caminho.possuiPeca() && Px + i < 8 && Py + i < 8);
                    if(Px + i <= Qx && Py + i <= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                } else //Sentido postitivo de X e negativo de Y
                if(positivoX && !positivoY){

                    int i = 1;
                    do{
                        caminho = this.getCasa(Px + i, Py - i);
                        i++;
                    } while(!caminho.possuiPeca() && Px + i < 8 && Py - i >= 0);
                    if(Px + i <= Qx && Py - i >= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                } else //Sentido negativo em X e positivo em Y
                if(!positivoX &&  positivoY){

                    int i = 1;
                    do{
                        caminho = this.getCasa(Px - i, Py + i);
                        
                        i++;
                    } while(!caminho.possuiPeca() && Px - i >= 0 && Py + i < 8);
                    if(Px - i >= Qx && Py + i <= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                } else //Sentido negativo em X e Y
                if(!positivoX && !positivoY){

                    int i = 1;
                    do{
                        caminho = this.getCasa(Px - i, Py - i);
                        
                        i++;
                    } while(!caminho.possuiPeca() && Px - i >= 0 && Py - i >= 0);
                    if(Px - i >= Qx && Py - i >= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                }
                
            case "vertical":
                //Sentido positivo em Y
                if(positivoY){

                    int i = 1;
                    do{
                        caminho = this.getCasa(Qx, Py + i);
                        i++;
                    } while(!caminho.possuiPeca() && Py + i < 8);
                    if(Py + i <= Qy){
                        return false;
                    }
                    else
                        return true;
                } else //Sentido negativo em Y
                if(!positivoY){

                    int i = 1;
                    do{
                        caminho = this.getCasa(Qx, Py - i);
                        i++;
                    } while(!caminho.possuiPeca() && Py - i >= 0);
                    if(Py - i >= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                }
            case "horizontal":
                //Sentido positivo em X
                if(positivoX){

                    int i = 1;
                    do{
                        caminho = this.getCasa(Px + i, Qy);
                        i++;
                    } while(!caminho.possuiPeca() && Px + i < 8);
                    if(Px + i <= Qx){
                        return false;
                    }
                    else
                        return true;
                } else //Sentido negativo em X
                if(!positivoX){

                    int i = 1;
                    do{
                        caminho = this.getCasa(Px - i, Qy);
                        i++;
                    } while(!caminho.possuiPeca() && Px - i >= 0);
                    if(Px - i >= Qx){ 
                        return false;
                    }
                    else
                        return true;
                }
            default:
                return false;
        }
    }

}
