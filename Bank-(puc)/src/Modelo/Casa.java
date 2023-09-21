package Modelo;

public class Casa extends Financeamento {
    private double AreaTerreno;
    private double AreaInterior;

    public Casa(double ValorDaPropriedade, int Parcelamento, double Juros, double AreaTerreno,double AreaCasa) {
        super(ValorDaPropriedade, Parcelamento, Juros);
        this.AreaInterior = AreaCasa;
        this.AreaTerreno = AreaTerreno;
    }

    private class DescontoMairQueJurosException extends Exception {
        public DescontoMairQueJurosException(String Mensagem) {
            super(Mensagem);
        }
    }

    private void DescontoCheck(double Desconto) throws DescontoMairQueJurosException{
        if (Desconto/super.GetValorMensal() > super.GetParcelamento()) {
            throw new DescontoMairQueJurosException("O valor do desconto não pode ser maior que o valor do juros.");
        }  // serve para checar se o desconto é maior que os juros, se o juros for de 10%, o desconto não pode ser maior que isso.
    }      // ou seja se o juros for de 5%,  e o desconto de 10%, ele "pega". (ou essa e a intenção)

    private double GetDesconto() {            
        if (super.GetValorMensal() >= 1000) { // caso o valor mensal seja maior que 1000, o desconto e de 100,
            return 100;                       // mas se for menor que 1000, ele da um deconto de 10% do valor mensal
        } else {           
            return (super.GetValorMensal() * 0.1); 
        }
    }

    @Override 
    public double GetValorMensal() {
        try {
            DescontoCheck(GetDesconto());
            return super.GetValorMensal() - GetDesconto();
        } catch (DescontoMairQueJurosException e) {
            return super.GetValorMensal();
        }
    }

    @Override
    public void PrintInfo() {
        System.out.printf("\n\n CASA \n\nO valor das mensalidades são: R$ %,.2f ",GetValorMensal(),"\n"); 
        // Juros compostos com no maximo R$100,00 de desconto para todo mês.
        System.out.printf("\nValor total do pagamento:  R$ %,.2f",GetValorTotal());
        System.out.printf("\nÁrea Do terreno: " + this.AreaTerreno + "m");
        System.out.printf("\nÁrea da interior casa: " +  this.AreaInterior + "m");
    }
}