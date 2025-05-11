// Elementos (formas)
interface Forma {
  void aceitar(Visitor visitor);
}

class Circulo implements Forma {
  double raio = 5;
  public void aceitar(Visitor visitor) {
    visitor.visitarCirculo(this);
  }
}

class Retangulo implements Forma {
  double largura = 4, altura = 3;
  public void aceitar(Visitor visitor) {
    visitor.visitarRetangulo(this);
  }
}

// Visitor
interface Visitor {
  void visitarCirculo(Circulo c);
  void visitarRetangulo(Retangulo r);
}

class CalculadoraArea implements Visitor {
  public void visitarCirculo(Circulo c) {
    System.out.println("Área do círculo: " + (Math.PI * c.raio * c.raio));
  }
  public void visitarRetangulo(Retangulo r) {
    System.out.println("Área do retângulo: " + (r.largura * r.altura));
  }
}

// Uso
public class Main {
  public static void main(String[] args) {
    Forma[] formas = { new Circulo(), new Retangulo() };
    Visitor calc = new CalculadoraArea();

    for (Forma f : formas) {
      f.aceitar(calc); // executa a operação sem alterar as classes
    }
  }
}
