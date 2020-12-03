

/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Peca {

    //Inteiros identificadores das pecas
    //damas
    public static final int PEDRA_BRANCA = 1;
    public static final int DAMA_BRANCA = -1;
    public static final int PEDRA_VERMELHA = 2;
    public static final int DAMA_VERMELHA = -2;
    //xadrez
    public static final int PEAO_BRANCO = 3;
    public static final int PEAO_PRETO = -3;
    public static final int TORRE_BRANCA = 4;
    public static final int TORRE_PRETA = -4;
    public static final int CAVALO_BRANCO = 5;
    public static final int CAVALO_PRETO = -5;
    public static final int BISPO_BRANCO = 6;
    public static final int BISPO_PRETO = -6;
    public static final int RAINHA_BRANCA = 7;
    public static final int RAINHA_PRETA = -7;
    public static final int REI_BRANCO = 8;
    public static final int REI_PRETO = -8;
    
    private Casa casa;
    private int tipo;

    public Peca(Casa casa, int tipo) {
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
    }
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }

    //Retorna uma String com o nome da direção do movimento
    private String deslocamentoDirecao(int Px, int Py, int Qx, int Qy){
        if(Px == Qx)
            return "vertical";
        else if(Py == Qy)
            return "horizontal";
        else if(Math.abs(Qx - Px) == Math.abs(Qy - Py))
            return"diagonal" ;
        else
            return "outro";
    }

    //Retorna o número de casas de um movimento
    private int deslocamentoModulo(int Px, int Py, int Qx, int Qy){
        //Se for diagonal, contamos o numero de casas através de um único eixo
        if (Math.abs(Qx - Px) == Math.abs(Qy - Py))
            return Math.abs(Qx - Px);
        //Retorna o número de casas se o movimento for vertical ou horizontal
        else
            return Math.abs(Qx - Px) + Math.abs(Qy - Py);
    }

    //METODO NOVO TESTA MOVIMENTAÇÃO INDICADA
        public boolean movimentoPermitido(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){
            String direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy);
            int distancia = this.deslocamentoModulo(Px, Py, Qx, Qy);
            switch(Math.abs(this.getTipo())){
                case 3:
                    //Caso seja peao preto, essas serao as regras
                    if(this.getTipo() == -3){
                        if(Py == 6)
                            if(distancia <= 2 && direcao.equals("vertical") && this.caminhoLivre(Px, Py, Qx, Qy, tabuleiro)){
                                return true;
                            } else 
                                return false;
                        if(distancia == 1 && Qy < Py && (direcao.equals("vertical"))){
                            return true;
                        } else 
                            return false;
                        } //Regras para peões brancos 
                        else if(Py == 1)
                            if(distancia <= 2 && direcao.equals("vertical") && this.caminhoLivre(Px, Py, Qx, Qy, tabuleiro)){
                                return true;
                            } else 
                                return false;
                        if(distancia == 1 && Qy > Py && (direcao.equals("vertical"))){
                            return true;
                        } else 
                            return false;
                case 4:
                    if((direcao.equals("horizontal") || direcao.equals("vertical")) && this.caminhoLivre(Px, Py, Qx, Qy, tabuleiro))
                        return true;
                    else 
                        return false;
                case 5:
                    if(distancia == 3 && Px != Qx && Py != Qy)
                        return true;
                    else 
                        return false;
                case 6:
                    if(direcao.equals("diagonal") && this.caminhoLivre(Px, Py, Qx, Qy, tabuleiro))
                        return true;
                    else
                        return false;     
                case 7:
                    if((direcao.equals("horizontal") || direcao.equals("diagonal") || direcao.equals("vertical")) && this.caminhoLivre(Px, Py, Qx, Qy, tabuleiro))
                        return true;
                    else 
                        return false;
                case 8:
                    if(distancia == 1)
                        return true;
                    else 
                        return false;
                default: 
                    return false;
            }
           
    }
    
    public boolean caminhoLivre(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){
        Casa caminho;
        char direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy).charAt(0);
        //boolean controle;
        switch(direcao){
            case 'd':
                //Sentido positivo em X e em Y
                if(Qx > Px && Qy > Py){
                    System.out.println("NORDESTE");
                    int i = 1;
                    int j = 1;
                    do{
                        caminho = tabuleiro.getCasa(Px + i, Py + j);
                        
                        i++;
                        j++;
                    } while(!caminho.possuiPeca() && Px + i < 8 && Py + i < 8);
                    if(Px + i <= Qx && Py + i <= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                } //Sentido postitivo de X e negativo de Y
                  else if(Qx > Px && Qy < Py){
                    System.out.println("SUDESTE");
                    int i = 1;
                    int j = 1;
                    do{
                        caminho = tabuleiro.getCasa(Px + i, Py - i);
                        
                        i++;
                       // j++;
                    } while(!caminho.possuiPeca() && Px + i < 8 && Py - i >= 0);
                    if(Px + i <= Qx && Py - i >= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                } //Sentido negativo em X e positivo em Y
                 else if(Qx < Px && Qy > Py){
                    System.out.println("NOROESTE");
                    int i = 1;
                    int j = 1;
                    do{
                        caminho = tabuleiro.getCasa(Px - i, Py + i);
                        
                        i++;
                       // j++;
                    } while(!caminho.possuiPeca() && Px - i >= 0 && Py + i < 8);
                    if(Px - i >= Qx && Py + i <= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                } //Sentido negativo em X e Y
                  else if(Qx < Px && Qy < Py){
                    System.out.println("SUDOESTE");
                    int i = 1;
                    int j = 1;
                    do{
                        caminho = tabuleiro.getCasa(Px - i, Py - i);
                        
                        i++;
                       // j++;
                    } while(!caminho.possuiPeca() && Px - i >= 0 && Py - i >= 0);
                    if(Px - i >= Qx && Py - i >= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                }
                
            case 'v':
                //Sentido positivo em Y
                if(Qy > Py){
                    System.out.println("NORTE");
                    int i = 1;
                    do{
                        caminho = tabuleiro.getCasa(Qx, Py + i);
                        i++;
                    } while(!caminho.possuiPeca() && Py + i < 8);
                    if(Py + i <= Qy){
                        return false;
                    }
                    else
                        return true;
                } 
                //Sentido negativo em Y
                else if(Py > Qy){
                    System.out.println("SUL");
                    int i = 1;
                    do{
                        caminho = tabuleiro.getCasa(Qx, Py - i);
                        i++;
                    } while(!caminho.possuiPeca() && Py - i >= 0);
                    if(Py - i >= Qy){
                        
                        return false;
                    }
                    else
                        return true;
                }
            case 'h':
                //Sentido positivo em X
                if(Qx > Px){
                    System.out.println("LESTE");
                    int i = 1;
                    do{
                        caminho = tabuleiro.getCasa(Px + i, Qy);
                        
                        i++;
                    } while(!caminho.possuiPeca() && Px + i < 8);
                    if(Px + i <= Qx){
                        
                        return false;
                    }
                    else
                        return true;
                } 
                //Sentido negativo em X
                else if(Px > Qx){
                    System.out.println("OESTE");
                    int i = 1;
                    do{
                        caminho = tabuleiro.getCasa(Px - i, Qy);
                        
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
    
    /*
    public boolean analiseCaminho(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){ 
           char direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy).charAt(0);
           System.out.println(direcao);
           Boolean restricao = false;
           switch(direcao){
            case 'h':
           if (Qx > Px){
           for(int i = Px; i< Qx;i++){
             Casa caminho = tabuleiro.getCasa(Px + i, Qy);
             System.out.println(i);
             if(caminho.possuiPeca()){
                restricao = true;
                System.out.println("peca no caminho");
                break;
              }else {
                  restricao = false;
                  System.out.println("sem peca no caminho");
                }
            
            }
        }else if(Qx < Px){
           for(int i = Qx; i >= Px;i--){
                if(i == 0){
                  i = 1;
                  Qx= Qx + 1;
                }
               Casa caminho = tabuleiro.getCasa(Px - 1, Qy);
               System.out.println(i);
             if(caminho.possuiPeca()){
                restricao = true;
                System.out.println("peca no caminho");
                break;
               }else {
                  restricao = false;
                  System.out.println("sem peca no caminho");
                }
            
            }
        }
    
        case 'v': 
           if(Qy > Py){
            for(int i = Py; i < Qy;i++){
                if(i == 0){
                 i = 1;
                  Qy++;
                }
               Casa caminho = tabuleiro.getCasa(Qx, Py + i);
               System.out.println(i);
             if(caminho.possuiPeca()){
                restricao = true;
                System.out.println("peca no caminho");
                break;
              }else {
                  restricao = false;
                  System.out.println("sem peca no caminho");
                 
                }
            }
            }
           else if(Qy < Py){
             for(int i = Py; i >= Qy;i--){
               Casa caminho = tabuleiro.getCasa(Qx,Py - 1);
               System.out.println(i);
             if(caminho.possuiPeca()){
                restricao = true;
                System.out.println("peca no caminho");
                break;
              }else {
                  restricao = false;
                  System.out.println("sem peca no caminho");
                 
                }
            }
           } 
           case 'd':
            if( Qx>Px && Qy>Py){
             for(int i = Px; i<Qx;i++){
               for(int j = Py;i<Qy;j++){
             Casa caminho = tabuleiro.getCasa(i, j);
             System.out.println(i);
             if(caminho.possuiPeca()){
                restricao = true;
                System.out.println("peca no caminho");
                break;
              }else {
                    restricao = false;
                    System.out.println("sem peca no caminho");
                }
              }
             }
            
            } else if(Qx>Px && Qy<Py){
             for(int i = Px; i<Qx;i++){
               for(int j = Py;i>=Qy;j--){
             Casa caminho = tabuleiro.getCasa(i, j);
             System.out.println(i);
             if(caminho.possuiPeca()){
                restricao = true;
                System.out.println("peca no caminho");
                break;
              }else {
                  restricao = false;
                    System.out.println("sem peca no caminho");
                }
              }
             }
             }else if(Qx<Px && Qy>Py){
             for(int i = Px; i>=Qx;i--){
               for(int j = Py;i<Qy;j++){
             Casa caminho = tabuleiro.getCasa(i, j);
             System.out.println(i);
             if(caminho.possuiPeca()){
                restricao = true;
                System.out.println("peca no caminho");
                break;
              }else {
                  restricao = false;
                    System.out.println("sem peca no caminho");
                }
              }
             }
             }else if(Qx<Px && Qy<Py){
             for(int i = Px; i>=Qx;i--){
               for(int j = Py;i>=Qy;j--){
             Casa caminho = tabuleiro.getCasa(i, j);
             System.out.println(i);
             if(caminho.possuiPeca()){
                restricao = true;
                System.out.println("peca no caminho");
                break;
              }else {
                  restricao = false;
                    System.out.println("sem peca no caminho");
                }
              }
             }
            
            }
            
            if (restricao)
             return false;
            else return true;
            
        
        }
  
    
        if(restricao)
         return false;
         else return true;
        }*/
    

    /**
     * Valor    Tipo
     *   0   Branca (Pedra)
     *   1   Branca (Dama)
     *   2   Vermelha (Pedra)
     *   3   Vermelha (Dama)
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
}
