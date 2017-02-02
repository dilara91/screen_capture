import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Capture {

	public static void main(String[] args){
		int count = 0;
		int sleep = Integer.parseInt(args[0]);
		int seconds = Integer.parseInt(args[1]);
		int max_decimal = findDecimal(sleep,seconds);
		
		while(count<(1000.0/sleep)*seconds){
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension screenSize = toolkit.getScreenSize();
			Rectangle screenRect = new Rectangle(screenSize);
			// create screen shot
			Robot robot;
			try {
				robot = new Robot();
			
			BufferedImage image = robot.createScreenCapture(screenRect);
			// save captured image to PNG file
			ImageIO.write(image, "jpg", new File("screen_"+createName(count,max_decimal)+".jpg"));
			count++;
			Thread.sleep(sleep);
			} catch (AWTException | IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	public static int findDecimal(int sleep,int seconds){
	
		int max_count =(int)(1000.0/sleep)*seconds;
		int toReturn = 0;
		while(max_count>0){
			max_count/=10;
			toReturn++;
		}
		return toReturn;
	}
	
	public static String createName(int count,int decimal){
		int cur_decimal = 0;
		int temp = count;
		while(temp>0){
			temp/=10;
			cur_decimal++;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<decimal-cur_decimal;i++){
			sb.append("0");
		}
		if(count!=0)
			sb.append(count);
		return sb.toString();
	}
}
