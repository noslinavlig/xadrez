public class Cavalo extends Peca {


    public Cavalo (Casa casa, int tipo){
        super(casa, tipo);
    }

    @Override
    public boolean movimentoPermitido(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){
            String direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy);
            int distancia = this.deslocamentoModulo(Px, Py, Qx, Qy);
            if(distancia == 3 && Px != Qx && Py != Qy)
            return true;
         else 
            return false;
    }
}