package Util;

import java.io.*;
import java.util.ArrayList;

import Modelo.Financeamento;

public class GerenciamentoDeArquivos {
    public void SalvarArquivoFinanceamento(String nome, ArrayList<Financeamento> Financeamento) {
        ObjectOutputStream outputStream;
        try{
            outputStream =  new ObjectOutputStream (new FileOutputStream(nome));
            for (Financeamento item : Financeamento){
                outputStream.writeObject(item);
            }
            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void LerArquivoFinanceamento(String nome) {
        ObjectInputStream LeitorDeArquivos;
        try {
            LeitorDeArquivos = new ObjectInputStream (new FileInputStream(nome));
            Object obj;
            while ((obj = LeitorDeArquivos.readObject()) != null) {
                if (obj instanceof Financeamento) {
                    ((Financeamento)obj).PrintInfo();
                }
            }
            System.out.println("FUNCIONOU ADSFGDHRTEEEEEEEEEEEEEEEEEE");
        } catch (EOFException e) {
            System.out.println("FIM");
        } catch (FileNotFoundException e) {
            System.out.println("ARQUIVO NÂO ENCONTRADO");
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada");
        }
    }
}