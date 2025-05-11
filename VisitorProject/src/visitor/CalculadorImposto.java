package visitor;
import model.*;

public class CalculadorImposto implements Visitor {
    public void visitarNFProduto(NFProduto nota) {
        double imposto = nota.valorTotal * 0.18;
        System.out.println("Imposto NF Produto " + nota.numero + ": R$" + imposto);
    }

    public void visitarNFServico(NFServico nota) {
        double imposto = nota.valorServiço * 0.12;
        System.out.println("Imposto NF Serviço " + nota.numero + ": R$" + imposto);
    }
}
