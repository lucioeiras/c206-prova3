package controllers;

import controllers.exceptions.PrejuizoException;
import models.Arquivo;

public class Cadastrar {
  int numeroCompras = 0;

  private static Cadastrar instancia;

  private Cadastrar() {}

  public static Cadastrar novaInstancia() {
    if (instancia == null) {
      instancia = new Cadastrar();
    }

    return instancia;
  }

  public void novaCompra(String raca, int peso, float precoVenda) throws PrejuizoException {
    Arquivo arquivo = new Arquivo();
     
    if (peso < (precoVenda * 2)) {
      throw new PrejuizoException();
    }

    arquivo.anotar(numeroCompras + "," + raca + "," + peso + "," + precoVenda);
    numeroCompras++;
  }
}
