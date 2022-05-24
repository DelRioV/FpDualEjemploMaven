package edu.fpdual.pdfcreator.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class PdfItext {

    public void createPDF(String fileName, String text) throws IOException, DocumentException, URISyntaxException {

        Path path = Paths.get(ClassLoader.getSystemResource("art.png").toURI());

        Document document = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
//        How to encrypt(1st way) before his creation
//        pdfWriter.setEncryption("user".getBytes(),"1234".getBytes(),PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_256);

        document.open();
        Paragraph paragraph = createParagraph(text);
        Image image = createImage(path);
        PdfPTable pdfPTable = new PdfPTable(4);
        pdfPTable.setSpacingBefore(10f);
        addTableHeader(pdfPTable);
        addTableSimpleRows(pdfPTable);
        addTableCustomRows(pdfPTable);

        //document.add(chunk);
        document.add(paragraph);
        //document.add(Chunk.NEWLINE);
        document.add(image);
        document.add(pdfPTable);
        document.close();

//        How to encrypt(2nd way) after his creation
//        PdfReader pdfReader = new PdfReader((fileName + ".pdf"));
//        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(fileName + "_encrypted.pdf"));
//        pdfStamper.setEncryption("user".getBytes(), "1234".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_256);
//        pdfStamper.close();

    }

    private Image createImage(Path path) throws BadElementException, IOException {
        Image image = Image.getInstance(path.toAbsolutePath().toString());
        image.scalePercent(40);
        return image;
    }

    private Paragraph createParagraph(String text) {
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.RED);
        //Chunk chunk = new Chunk(text, font);
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setSpacingAfter(25f);
        return paragraph;
    }

    public void addTableHeader(PdfPTable pdfPTable) {
        Stream.of("Foto","Nombre", "Apellido", "Edad").forEach(nombreColumna -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.GREEN);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(nombreColumna));
            pdfPTable.addCell(header);
        });
    }

    public void addTableSimpleRows(PdfPTable pdfPTable) throws BadElementException, IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("art.png").toURI());
        Image image = Image.getInstance(path.toAbsolutePath().toString());
        image.scalePercent(10);
        pdfPTable.addCell(image);
        pdfPTable.addCell("Ismael");
        pdfPTable.addCell("Orellana");
        pdfPTable.addCell("19");
    }

    public void addTableCustomRows(PdfPTable pdfPTable) throws URISyntaxException, BadElementException, IOException {
        Path path = Paths.get(ClassLoader.getSystemResource("art.png").toURI());
        Image image = Image.getInstance(path.toAbsolutePath().toString());
        image.scalePercent(10);
        PdfPCell customColumnImg = new PdfPCell(image);
        customColumnImg.setBackgroundColor(BaseColor.MAGENTA);
        customColumnImg.setBorderWidth(1);
        customColumnImg.setHorizontalAlignment(Element.ALIGN_CENTER);
        customColumnImg.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(customColumnImg);

        PdfPCell customColumnNombre = new PdfPCell(new Phrase("Natalia"));
        customColumnNombre.setBackgroundColor(BaseColor.MAGENTA);
        customColumnNombre.setBorderWidth(5);
        customColumnNombre.setHorizontalAlignment(Element.ALIGN_CENTER);
        customColumnNombre.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(customColumnNombre);

        PdfPCell customColumnApellido = new PdfPCell(new Phrase("Castillo"));
        customColumnApellido.setBackgroundColor(BaseColor.MAGENTA);
        customColumnApellido.setBorderWidth(5);
        customColumnApellido.setHorizontalAlignment(Element.ALIGN_CENTER);
        customColumnApellido.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(customColumnApellido);

        PdfPCell customColumnEdad = new PdfPCell(new Phrase("45"));
        customColumnEdad.setBackgroundColor(BaseColor.MAGENTA);
        customColumnEdad.setBorderWidth(5);
        customColumnEdad.setHorizontalAlignment(Element.ALIGN_CENTER);
        customColumnEdad.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(customColumnEdad);
    }
    public static void main(String[] args) {
        try {
            new PdfItext().createPDF("PdfPruebaIText", "Ejemplo PDF creator");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
