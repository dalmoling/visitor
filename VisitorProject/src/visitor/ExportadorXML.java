package visitor;
import model.*;

public class ExportadorXML implements Visitor {
    public void visitarNFProduto(NFProduto nota) {
        System.out.println("<NFProduto numero=\"" + nota.numero + "\" valor=\"" + nota.valorTotal + "\" />");
    }

    public void visitarNFServico(NFServico nota) {
        System.out.println("<NFServico numero=\"" + nota.numero + "\" valor=\"" + nota.valorServiço + "\" />");
    }
}
