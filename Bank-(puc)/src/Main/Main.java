package Main;

import java.util.ArrayList;
import java.util.Locale;

import Modelo.Apartamento;
import Modelo.Casa;
import Modelo.Financeamento;
import Modelo.Terreno;
import Util.GerenciamentoDeArquivos;
import Util.InterfaceDeUsuario;

public class Main {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Financeamento> ListaDeFinanceamentos = new ArrayList<>();
        
        Locale.setDefault(new Locale("pt", "BR"));
        
        InterfaceDeUsuario interfaceDeUsuario = new InterfaceDeUsuario();
        
        System.out.printf("\nPor favor, registre casas á seguir: ");
        
        for (int i = 1; i <= 2; i++) {
            
            System.out.printf("\n\nCasa "+ i + ":");
            
            double ValorDaPropriedade = interfaceDeUsuario.ScanValor();
            
            int Parcelas = interfaceDeUsuario.ScanParcelas();
            
            double Juros = interfaceDeUsuario.ScanTaxaDeJuros();

            double Area = interfaceDeUsuario.ScanArea();
            
            while (true) {
                
                double AreaInterior = interfaceDeUsuario.ScanAreaInterior();
                
                if (AreaInterior > Area) {
                    System.out.printf("A area interior não pode ser maior que a area do terreno, tente novamente.");
                } else {
                    ListaDeFinanceamentos.add(new Casa(ValorDaPropriedade, Parcelas, Juros, Area, AreaInterior));
                    break;
                }
            }
        }
        
        System.out.printf("Por favor, registre apartamentos á seguir: ");
        
        for (int i = 1; i <= 2; i++) {

            System.out.printf("\n\nApartamento "+ i +":");
            
            double ValorDaPropriedade = interfaceDeUsuario.ScanValor();
            
            int Parcelas = interfaceDeUsuario.ScanParcelas();
            
            double Juros = interfaceDeUsuario.ScanTaxaDeJuros();
            
            int Andar = interfaceDeUsuario.ScanAndar();

            int Garagem = interfaceDeUsuario.ScanGaragem();

            ListaDeFinanceamentos.add(new Apartamento(ValorDaPropriedade, Parcelas, Juros, Andar, Garagem));
        }
        
        System.out.printf("\nPor favor, registre terrenos a seguir:");
        
        System.out.printf("\n\nTERRENO");
        
        double ValorDaPropriedade = interfaceDeUsuario.ScanValor();
        
        int Parcelas = interfaceDeUsuario.ScanParcelas();
        
        double Juros = interfaceDeUsuario.ScanTaxaDeJuros();
        
        String Zona = interfaceDeUsuario.ScanZona(); // residencial ou comercial.
        
        ListaDeFinanceamentos.add(new Terreno(ValorDaPropriedade, Parcelas, Juros, Zona));
        
        GerenciamentoDeArquivos Gerente = new GerenciamentoDeArquivos();
        
        Gerente.SalvarArquivoFinanceamento("Financeamentos.txt", ListaDeFinanceamentos);
        Gerente.LerArquivoFinanceamento("Financeamentos.txt");
    }
}