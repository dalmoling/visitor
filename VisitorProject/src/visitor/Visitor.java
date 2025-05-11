package visitor;
import model.NFProduto;
import model.NFServico;

public interface Visitor {
    void visitarNFProduto(NFProduto nota);
    void visitarNFServico(NFServico nota);
}
