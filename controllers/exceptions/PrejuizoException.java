package controllers.exceptions;

public class PrejuizoException extends Exception {
  public PrejuizoException() {
    System.out.println("Essa compra irá te retornar um prejuízo!");
  }
}