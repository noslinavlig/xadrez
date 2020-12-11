public class Bispo extends Peca {


    public Bispo (Casa casa, int tipo){
        super(casa, tipo);
    }

    @Override
    public boolean movimentoPermitido(int Px, int Py, int Qx, int Qy, Tabuleiro tabuleiro){
            String direcao = this.deslocamentoDirecao(Px, Py, Qx, Qy);
            
            if(direcao.equals("diagonal") && tabuleiro.caminhoLivre(Px, Py, Qx, Qy, direcao))
            return true;
        else
            return false;
    }
}
