package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Arquivo {
  public void anotar(String linha) {
    OutputStream fluxoSaida = null;
    OutputStreamWriter geradorFluxoSaida = null;
    BufferedWriter bufferSaida = null;

    try {
      fluxoSaida = new FileOutputStream("/Users/diegoeiras/www/inatel/c206/lab/provas/3/dist/animais.txt", true);
      geradorFluxoSaida = new OutputStreamWriter(fluxoSaida);
      bufferSaida = new BufferedWriter(geradorFluxoSaida);
      bufferSaida.write(linha);
      bufferSaida.newLine();
    } catch (FileNotFoundException err) {
      System.err.printf("FileNotFoundException: %s.%n", err);
    } catch (IOException err) {
      System.err.printf("IOException: %s.%n", err);
    } finally {
      try {
        bufferSaida.close();
      } catch (IOException err) {
        System.err.printf("IOException: %s.%n", err);
      } 
    }
  }

  public ArrayList<Compra> ler() {
    ArrayList<Compra> compras = new ArrayList<Compra>();

    InputStream fluxoEntrada = null;
    InputStreamReader leitorFluxoEntrada = null;
    BufferedReader bufferEntrada = null;  

    String linha = null;

    try {
      fluxoEntrada = new FileInputStream("/Users/diegoeiras/www/inatel/c206/lab/provas/3/dist/animais.txt");
      leitorFluxoEntrada = new InputStreamReader(fluxoEntrada);
      bufferEntrada = new BufferedReader(leitorFluxoEntrada);

      linha = bufferEntrada.readLine();

      while (linha != null) {
        String[] strings = linha.split(",");

        Compra novaCompra = new Compra(
          Integer.valueOf(strings[0]), 
          strings[1],
          Integer.valueOf(strings[2]),
          Float.valueOf(strings[3])
        );
        compras.add(novaCompra);

        linha = bufferEntrada.readLine();
      }
    } catch (FileNotFoundException err) {
      System.err.printf("FileNotFoundException: %s.%n", err);
    } catch (IOException err) {
      System.err.printf("IOException: %s.%n", err);
    } finally {
      try {
        bufferEntrada.close();
      } catch (IOException err) {
        System.err.printf("IOException: %s.%n", err);
      } 
    }

    return compras;
  }
}
