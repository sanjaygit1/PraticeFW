package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDatafromPDF {

	public static void main(String[] args) throws Throwable {
	
		File file = new File("./src/test/resources/multipage-pdf.pdf");

		PDDocument doc = PDDocument.load(file);
		
		int pages = doc.getNumberOfPages();
		System.out.println(pages);//---->Print num of pages
		
		PDFTextStripper pdfData = new PDFTextStripper();
		String readData = pdfData.getText(doc);
	//	System.out.println(readData);//------->Fetching all the pages data
		
//		pdfData.setStartPage(2);
//		pdfData.setEndPage(2);
//		String readData1 = pdfData.getText(doc);
//		System.out.println(readData1);//------->fetching single page data
		
		pdfData.setStartPage(2);
     	String readData1 = pdfData.getText(doc);
		System.out.println(readData1);//---->fetches the data from start page till end page data
	}

}
