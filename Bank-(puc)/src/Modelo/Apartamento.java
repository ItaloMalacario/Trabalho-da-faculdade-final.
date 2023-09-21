package Modelo;

public class Apartamento extends Financeamento {
    private double ValorTotal;
    private int Andar;
    private int Garagem; 

    public Apartamento(double ValorDaPropriedade, int Parcelamento, double Juros, int Andar,int Garagem) {
        super(ValorDaPropriedade, Parcelamento, Juros);
        this.Andar = Andar;
        this.Garagem = Garagem;
    }

    @Override
    public double GetValorTotal() {
        return this.ValorTotal;
    }

    public void PrintInfo() {
        System.out.printf("\n\nAPARTAMENTO\n\n");
        double Reducao = GetJuros(); // reduz a taxa de juros.
        int i = 1;
        while (i <= GetParcelamento()) {
            Reducao /= 2;
            System.out.printf("\nMês " + i + " Valor do aluguel: R$ %,.2f ",
            ((GetValorDaPropriedade() + (super.GetValorDaPropriedade() / (100 / Reducao)))/ GetParcelamento()));
            ValorTotal += ((GetValorDaPropriedade() + (GetValorDaPropriedade() / (100 / Reducao)))/ GetParcelamento());
            i++;
        }
        System.out.printf("\n\nO valor Total do Pagamento é: R$ %,.2f ", GetValorTotal());
        System.out.printf("\nAndar: " + Andar);
        System.out.printf("\nGaragem: " + Garagem);
    }

}