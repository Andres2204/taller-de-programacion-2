package com.example.primerapractica.Services;

import com.example.primerapractica.Models.Entity.Detalle;
import com.example.primerapractica.Models.Entity.Encabezado;
import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Repository
@Service
public class PDFbean {

    public void generate(Encabezado encabezado, List<Detalle> detalleList, HttpServletResponse response) throws DocumentException, IOException {
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        // Creating paragraph
        Paragraph paragraph1 = new Paragraph("Factura Nº"+encabezado.getId(), fontTiltle);
        // Aligning the paragraph in the document
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        // Adding the created paragraph in the document
        document.add(paragraph1);
        // Creating a table of the 4 columns
        PdfPTable table = new PdfPTable(6);

        // Setting width of the table, its columns and spacing
        table.setWidthPercentage(100);
        table.setWidths(new int[] {3,3,3,3,3,3});
        table.setSpacingBefore(5);

        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();
        // Setting the background color and padding of the table cell
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);
        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        // Adding headings in the created table cell or  header
        // Adding Cell to table
        cell.setPhrase(new Phrase("Producto", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Descripción", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Cantidad", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Precio Unitario", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Descuento", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Total", font));
        table.addCell(cell);
        // Iterating the list of students
        for (Detalle detalle : detalleList) {
            table.addCell(detalle.getProducto().getNombre());
            table.addCell(detalle.getProducto().getDescripcion());
            table.addCell(String.valueOf(detalle.getCantidad()));
            table.addCell(String.valueOf(detalle.getProducto().getValorUnitario()));
            table.addCell(String.valueOf(detalle.getDescuento()));
            table.addCell(String.valueOf(detalle.getValor()));
        }
        // Adding the created table to the document
        document.add(table);
        // Closing the document
        document.close();
    }
}

