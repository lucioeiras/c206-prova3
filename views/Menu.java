package views;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Cadastrar;
import controllers.Mostrar;
import controllers.exceptions.PrejuizoException;

public class Menu {
  int option = 0;
  Scanner sc = new Scanner(System.in);

  public Menu() {
    while (option != 6) {
      System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO");
      System.out.println("1) Cadastrar novo animal");
      System.out.println("2) Ver informações");
      System.out.println("3) Ordernar por ordem alfabética");
      System.out.println("4) Ordernar por peso");
      System.out.println("5) Calcular o valor médio dos lucros");
      System.out.println("6) SAIR");

      this.option = this.sc.nextInt();

      switch (option) {
        case 1:
          ArrayList<String> racas = new ArrayList<String>();
          racas.add("nelore");
          racas.add("angus");
          racas.add("curacu");
      
          System.out.println("Selecione a raça (1 - nelore, 2 - angus, 3 - curacu)");
          String raca = racas.get(this.sc.nextInt() - 1);
      
          System.out.println("Digite o peso: ");
          int peso = this.sc.nextInt();
      
          System.out.println("Digite o preço de venda: ");
          float precoVenda = this.sc.nextFloat();
      
          Cadastrar cadastrar = Cadastrar.novaInstancia();
      
          try {
            cadastrar.novaCompra(raca, peso, precoVenda);
          } catch (PrejuizoException err) {
            break;
          }
        break;
        
        case 2:
          Mostrar mostrar = new Mostrar();
          mostrar.tudo();
        break;

        case 3:
          mostrar = new Mostrar();
          mostrar.ordemAlfabetica();
        break;

        case 4:
          mostrar = new Mostrar();
          mostrar.porPeso();
        break;

        case 5:
          mostrar = new Mostrar();
          mostrar.mediaDoLucros();
      }
    }
  }

  public void close() {
    sc.close();
  }
}
