public class Rei extends Peca {


    public Rei(Casa casa, int tipo){
        super(casa, tipo);
    }

    @Override
    public boolean movimentoPermitido(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){
            String direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy);
            int distancia = this.deslocamentoModulo(Px, Py, Qx, Qy);
            if(distancia == 1)
                        return true;
                    else 
                        return false;
}
}
