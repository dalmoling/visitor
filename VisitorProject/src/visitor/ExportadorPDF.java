package visitor;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import model.*;

import java.io.FileOutputStream;

public class ExportadorPDF implements Visitor {
    private Document document;

    public ExportadorPDF(String caminhoArquivo) {
        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void visitarNFProduto(NFProduto nota) {
        try {
            document.add(new Paragraph("NF Produto:"));
            document.add(new Paragraph("Número: " + nota.numero));
            document.add(new Paragraph("Valor: R$ " + nota.valorTotal));
            document.add(new Paragraph(" "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void visitarNFServico(NFServico nota) {
        try {
            document.add(new Paragraph("NF Serviço:"));
            document.add(new Paragraph("Número: " + nota.numero));
            document.add(new Paragraph("Valor: R$ " + nota.valorServiço));
            document.add(new Paragraph(" "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalizar() {
        document.close();
    }
}
