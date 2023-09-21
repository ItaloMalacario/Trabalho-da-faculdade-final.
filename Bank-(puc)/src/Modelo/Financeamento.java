package Modelo;

import java.io.Serializable;

public abstract class Financeamento implements Serializable{

    public abstract void PrintInfo();

    //private static final long serialVersionUID = 1L;
    
    private double ValorDaPropriedade;
    private int Parcelamento;
    private double Juros;
    
    public Financeamento(double ValorDaPropriedade, int Parcelamento, double Juros) {
        this.ValorDaPropriedade = ValorDaPropriedade;
        this.Parcelamento = Parcelamento;
        this.Juros = Juros;
    }
    
    public double GetValorDaPropriedade() {
        return this.ValorDaPropriedade;
    }
    
    public int GetParcelamento() {
        return this.Parcelamento;
    }
    
    public double GetJuros() {
        return this.Juros;
    }
    
    public double GetValorMensal() {
        return (this.ValorDaPropriedade / this.Parcelamento) * (1 + (this.Juros / 10));
    }

    public double GetValorTotal() {
        return GetValorMensal() * GetParcelamento();
    }
}