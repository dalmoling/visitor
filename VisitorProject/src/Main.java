import model.*;
import visitor.*;

public class Main {
    public static void main(String[] args) {
        DocumentoFiscal nf1 = new NFProduto("001", 1000.0);
        DocumentoFiscal nf2 = new NFServico("002", 500.0);

        Visitor calculador = new CalculadorImposto();
        Visitor exportadorXML = new ExportadorXML();
        ExportadorPDF exportadorPDF = new ExportadorPDF("notas.pdf");

        System.out.println("🧾 Cálculo de Impostos:");
        nf1.aceitar(calculador);
        nf2.aceitar(calculador);

        System.out.println("\n📤 Exportação XML:");
        nf1.aceitar(exportadorXML);
        nf2.aceitar(exportadorXML);

        System.out.println("\n📄 Exportação PDF:");
        nf1.aceitar(exportadorPDF);
        nf2.aceitar(exportadorPDF);
        exportadorPDF.finalizar();

        System.out.println("✅ Arquivo 'notas.pdf' gerado com sucesso!");
    }
}
