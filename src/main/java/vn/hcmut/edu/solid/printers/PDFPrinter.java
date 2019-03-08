package vn.hcmut.edu.solid.printers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import vn.hcmut.edu.solid.SearchResult;
import vn.hcmut.edu.solid.helpers.Maker;
import vn.hcmut.edu.solid.items.Book;
import vn.hcmut.edu.solid.items.LibItem;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFPrinter extends Printer {

    public PDFPrinter(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public void print() throws IOException, DocumentException {
        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("SearchResult.pdf"));
        document.open();

        PdfPTable table = new PdfPTable(6); // 6 columns.
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f); //Space after table

        //Set Column widths
        float[] columnWidths = {1f, 1f, 3f, 1.5f, 1.5f, 1f};
        table.setWidths(columnWidths);

        PdfPCell frontCoverCellTitle = createPdfPCell("Front Cover", true);
        PdfPCell backCoverCellTitle = createPdfPCell("Back Cover", true);
        PdfPCell titleCellTitle = createPdfPCell("Title", true);
        PdfPCell authorsCellTitle = createPdfPCell("Authors", true);
        PdfPCell publisherCellTitle = createPdfPCell("Publisher", true);
        PdfPCell yearCellTitle = createPdfPCell("Year", true);

        //To avoid having the cell border and the content overlap, if you are having thick cell borders
        //frontCoverCellTitle.setUserBorderPadding(true);
        //backCoverCellTitle.setUserBorderPadding(true);
        //titleCellTitle.setUserBorderPadding(true);

        addRowToTable(table, frontCoverCellTitle, backCoverCellTitle, titleCellTitle, authorsCellTitle, publisherCellTitle, yearCellTitle);

        for (LibItem b : searchResult.getList()) {
            Maker maker = new Maker(b);
            PdfPCell frontCoverCell = createPdfPCell(maker.makeFrontCover(), false);
            PdfPCell backCoverCell = createPdfPCell(maker.makeBackCover(), false);
            PdfPCell titleCell = createPdfPCell(b.getTitle(), false);
            PdfPCell authorsCell;
            if (b instanceof Book) {
                authorsCell = createPdfPCell(((Book) b).getAuthors(), false);
            } else {
                authorsCell = createPdfPCell("", false);
            }
            PdfPCell publisherCell = createPdfPCell(b.getPublisher(), false);
            PdfPCell yearCell = createPdfPCell(b.getYear(), false);

            addRowToTable(table, frontCoverCell, backCoverCell, titleCell, authorsCell, publisherCell, yearCell);
        }

        document.add(table);

        document.close();
        writer.close();
    }

    private void addRowToTable(PdfPTable table, PdfPCell frontCoverCellTitle, PdfPCell backCoverCellTitle, PdfPCell titleCellTitle, PdfPCell authorsCellTitle, PdfPCell publisherCellTitle, PdfPCell yearCellTitle) {
        table.addCell(frontCoverCellTitle);
        table.addCell(backCoverCellTitle);
        table.addCell(titleCellTitle);
        table.addCell(authorsCellTitle);
        table.addCell(publisherCellTitle);
        table.addCell(yearCellTitle);
    }

    private PdfPCell createPdfPCell(Object content, boolean isTitle) {
        PdfPCell cell;
        if (content instanceof Image) {
            cell = new PdfPCell((Image) content);
            cell.setPaddingTop(5);
        } else {
            if (isTitle) {
                cell = new PdfPCell(new Paragraph((String) content, new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            } else {
                cell = new PdfPCell(new Paragraph((String) content, new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL)));
            }
        }
        cell.setPaddingLeft(10);
        cell.setPaddingBottom(5);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        return cell;
    }
}
