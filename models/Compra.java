package models;

public class Compra implements Comparable<Compra> {
  public int id;
  public String raca;
  public int peso;
  public float precoVenda;

  public Compra(
    int id,
    String raca,
    int peso,
    float precoVenda
  ) {
    this.id = id;
    this.raca = raca;
    this.peso = peso;
    this.precoVenda = precoVenda;
  }

  @Override
  public int compareTo(Compra compra) {
    return this.raca.compareTo(compra.raca);
  }
}
