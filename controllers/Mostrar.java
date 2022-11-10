package controllers;

import java.util.ArrayList;
import java.util.Collections;

import controllers.comparators.PesoComparator;
import models.Arquivo;
import models.Compra;

public class Mostrar {
  ArrayList<Compra> compras;

  private void ler() {
    Arquivo arquivo = new Arquivo();
    this.compras = arquivo.ler();
  }

  private void mostrar() {
    for (Compra compra : this.compras) {
      System.out.println("ID: " + compra.id);
      System.out.println("Raça: " + compra.raca);
      System.out.println("Peso: " + compra.peso);
      System.out.println("Preço de venda: " + compra.precoVenda);
      System.out.println("");
    }
  }

  public void tudo() {
    this.ler();
    this.mostrar();
  }

  public void ordemAlfabetica() {
    this.ler();

    Collections.sort(this.compras);
    
    this.mostrar();
  }

  public void porPeso() {
    this.ler();

    PesoComparator comparador = new PesoComparator();
    Collections.sort(this.compras, comparador);

    this.mostrar();
  }

  public void mediaDoLucros() {
    this.ler();

    int soma = 0;

    for (Compra compra : this.compras) {
      soma += compra.precoVenda;
    }

    float media = soma / this.compras.size();
    System.out.println("Média dos lucros: " + media);
  }
}
