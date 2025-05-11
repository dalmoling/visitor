package model;
import visitor.Visitor;

public class NFServico implements DocumentoFiscal {
    public String numero;
    public double valorServiço;

    public NFServico(String numero, double valorServiço) {
        this.numero = numero;
        this.valorServiço = valorServiço;
    }

    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitarNFServico(this);
    }
}
