package Util;

import java.util.Scanner; // colocar todos os scanners dentro de InterfaceDeUsuario

public class InterfaceDeUsuario {
    private Scanner scan; // Scanner da classe.

    private class NumeroEZero extends Exception {
        public NumeroEZero(String Mensagem) {
            super(Mensagem); // classe de Exception
        }
    }

    private void ZeroCheck(double Valor) throws NumeroEZero {
        if (Valor <=  0) {
            throw new NumeroEZero("\n\u001B[41;30;1m"+"Este valor não pode ser igual ou menor que 0, tente novamente."+"\u001B[0m\n");
        }
    }

    private void ZeroCheck(int Valor) throws NumeroEZero {
        if (Valor <=  0) {
            throw new NumeroEZero("\n\u001B[41;30;1m"+"Este valor não pode ser igual ou menor que 0, tente novamente."+"\u001B[0m\n");
        } // os dois ZeroChecks server para dar throw, porem um e especifico de int, e o outro especifico de double. 
    }

    public void MensagemDeErroInputMismatch() {
        System.out.printf("\n\u001B[41;30;1m"+"ERRO!!! Apenas numeros por favor!"+ "\u001B[0m\n");
    }

    public InterfaceDeUsuario() {
        this.scan = new Scanner(System.in); // abre o scanner da classe.
    }

    public double ScanValor() { // pede o valor da propriedade e checa se e < ou = a 0
        while (true) {
            System.out.print("\nQual o valor da propriedade?\n ");
            try {
                double ValorDoImovel = scan.nextDouble();
                ZeroCheck(ValorDoImovel);
                return ValorDoImovel;
            } catch (java.util.InputMismatchException e){
                MensagemDeErroInputMismatch();
                scan.nextLine();
            } catch (NumeroEZero e) {
                e.getMessage();
            }
        }
    }

    public int ScanParcelas() { // pede a quantidade do parcelamento e se e < ou = a 0
        while (true) {
            
            try {
                
                System.out.println("\nQuantas parcelas? ");
                
                int Parcelamento = scan.nextInt();

                ZeroCheck(Parcelamento);
                
                return Parcelamento;
            } catch (java.util.InputMismatchException e){
                MensagemDeErroInputMismatch();
                scan.nextLine();
            } catch (NumeroEZero e) {
                e.getMessage();
            }
        }
    }

    public double ScanTaxaDeJuros() { // pede o valor do juros da Propriedade e se < 0
        while (true) {
            try {
                System.out.println("\nQual a taxa de Juros anual em %? ");
                double TaxaDeJuros = scan.nextDouble();
                ZeroCheck(TaxaDeJuros);
                if (TaxaDeJuros > 30) {
                    System.out.println("\nValor inválido. Você não pode cobrar menos que 0% ou mais que 30% em juros. \nTente novamente.");
                } else {
                    return TaxaDeJuros;
                }
            } catch (java.util.InputMismatchException e){
                MensagemDeErroInputMismatch();
                scan.nextLine();
            } catch (NumeroEZero erro) {
                erro.getMessage();
            }
        }
    }

    public double ScanArea(){
        while (true){
            try {
                System.out.printf("\nQual a area do terreno em metros?");
                double Area = scan.nextDouble();
                ZeroCheck(Area);
                return Area;
            } catch (java.util.InputMismatchException e) {
                MensagemDeErroInputMismatch();
                scan.nextLine();
            } catch (NumeroEZero e) {
                e.getMessage();
            }
        }
    }

    public double ScanAreaInterior() {
        while (true){
            try {
                System.out.printf("\nQual a Area do interior da propriedade em metros?");
                double Area = scan.nextDouble();
                ZeroCheck(Area);
                return Area;
            } catch (java.util.InputMismatchException e) {
                MensagemDeErroInputMismatch();
                scan.nextLine();
            } catch (NumeroEZero erro) {
                erro.getMessage();
            }
        }
    }

    public int ScanAndar() {
        while (true){
            try {
                System.out.printf("\nQual o andar do apartamento?");
                return scan.nextInt();
            } catch (java.util.InputMismatchException e) {
                MensagemDeErroInputMismatch();
                scan.nextLine();
            }
        }
    }

    public int ScanGaragem() {
        while (true){
            try {
                System.out.printf("\nQual o numero da garagem? ");
                return scan.nextInt();
            } catch (java.util.InputMismatchException e) {
                MensagemDeErroInputMismatch();
                scan.nextInt();
            }
        }
    }

    public String ScanZona() {
        while (true){
            try {
                System.out.printf("\nSeu terreno fica em zona resisdencial ou comercial? (1 ou 2)");
                int i = scan.nextInt();
                if (i == 1) {
                    String Zona = "Residencial";
                    return Zona;
                } else if (i == 2) {
                    String Zona = "Comercial";
                    return Zona;
                } else {
                    System.out.printf("\nValor inválido");
                }
            } catch (java.util.InputMismatchException e) {
                MensagemDeErroInputMismatch();
                scan.nextLine();
            }
        }
    }
}