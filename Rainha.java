public class Rainha extends Peca {


    public Rainha(Casa casa, int tipo){
        super(casa, tipo);
    }

    @Override
    public boolean movimentoPermitido(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){
            String direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy);

            if((direcao.equals("horizontal") || direcao.equals("diagonal") || direcao.equals("vertical"))
            &&tabuleiro.caminhoLivre(Px, Py, Qx, Qy, direcao))
            return true;
        else 
            return false;
}
}
