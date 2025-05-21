package action;

import java.awt.image.BufferedImage;
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

public class PDFtoIMGConversion {
	
	public static void generateImageFromPDF(String Filenamepdf ,String extension, String ResultImageName) throws Exception
	{
	    PDDocument document = PDDocument.load(new File(System.getProperty("user.home")+"/Downloads/"+Filenamepdf+".pdf"));
	    PDFRenderer pdfRenderer = new PDFRenderer(document);
	    for (int page = 0; page < document.getNumberOfPages(); ++page) {
	        BufferedImage bim = pdfRenderer.renderImageWithDPI(
	          page, 300, ImageType.RGB);
	        ImageIOUtil.writeImage(
	          bim, String.format(System.getProperty("user.dir")+"/Screenshot/"+ResultImageName+"."+extension), 300);
	        System.out.println("done");
	    }
	    document.close();
	}
}