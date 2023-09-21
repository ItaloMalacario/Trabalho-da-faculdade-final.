package Modelo;

public class Terreno extends Financeamento {
    private String Zona; // Zona residencial ou comercial.

    public Terreno(double ValorDaPropriedade, int Parcelamento, double Juros, String Zona) {
        super(ValorDaPropriedade, Parcelamento, Juros);
        this.Zona = Zona;
    }

    @Override
    public double GetValorMensal() {
        return (GetValorDaPropriedade() / GetParcelamento()) * (1 + ((GetJuros() + 2) / 12));
    }

    @Override
    public double GetValorTotal() {
        return GetValorMensal() * GetParcelamento();
    }

    @Override
    public void PrintInfo() {
        System.out.printf("\n\nTERRENO\n\n");
        System.out.printf("\nAs Parcelas são de: R$ %,.2f ",(GetValorDaPropriedade() / GetParcelamento()) * (1 + ((GetJuros() + 2) / 12))); // Valor das parcelas
        System.out.printf("\nTotal do financeamento é de: R$ %,.2f", GetValorTotal()); // Valor Final do financeamento.                        do terreno.
        System.out.printf("\nTerreno fica na zona " + Zona);
    }
}