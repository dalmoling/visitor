package model;
import visitor.Visitor;

public class NFProduto implements DocumentoFiscal {
    public String numero;
    public double valorTotal;

    public NFProduto(String numero, double valorTotal) {
        this.numero = numero;
        this.valorTotal = valorTotal;
    }

    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitarNFProduto(this);
    }
}
