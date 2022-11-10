package controllers.comparators;

import java.util.Comparator;

import models.Compra;

public class PesoComparator implements Comparator<Compra> {
  @Override
  public int compare(Compra compra, Compra outraCompra) {
    return Integer.compare(compra.peso, outraCompra.peso);
  }
}