package action;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.io.File;

import org.testng.Assert;

public class CompareImage {
	
	static boolean vresult;
		public  boolean processImage(String Actualimagename, String Expectedimagename) throws InterruptedException {

			String file1 =System.getProperty("user.dir")+"/Screenshot/"+Actualimagename+".png";
			String file2 =System.getProperty("user.dir")+"/Screenshot/"+Expectedimagename+".png";
				
			
			File f1 = new File(System.getProperty("user.dir")+"/Screenshot/"+Actualimagename+".png");
			File f2 = new File(System.getProperty("user.dir")+"/Screenshot/"+Expectedimagename+".png");

			Assert.assertTrue(f1.exists());
			Thread.sleep(1000);
			Assert.assertTrue(f2.exists());

			// Load the images
			Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
			Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

			try {

				PixelGrabber grabImage1Pixels = new PixelGrabber(image1, 0, 0, -1,
						-1, false);
				PixelGrabber grabImage2Pixels = new PixelGrabber(image2, 0, 0, -1,
						-1, false);

				int[] image1Data = null;

				if (grabImage1Pixels.grabPixels()) {
					int width = grabImage1Pixels.getWidth();
					int height = grabImage1Pixels.getHeight();
					image1Data = new int[width * height];
					image1Data = (int[]) grabImage1Pixels.getPixels();
				}

				int[] image2Data = null;

				if (grabImage2Pixels.grabPixels()) {
					int width = grabImage2Pixels.getWidth();
					int height = grabImage2Pixels.getHeight();
					image2Data = new int[width * height];
					image2Data = (int[]) grabImage2Pixels.getPixels();
				}
	 vresult =java.util.Arrays.equals(image1Data, image2Data);
				System.out.println("Pixels equal: "+ vresult);

			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return vresult ;
		}

		
	}

