package hellorest.src.news;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;

import hellorest.src.DummyClass;
import hellorest.src.Hello2Proxy;

public class Main {
	
	public Main() throws IOException{

		Hello2Proxy h2p = new Hello2Proxy();
		byte[] array = extractBytes ("C:\\Users\\Andres\\Desktop\\B&N\\aaa.jpg");
		DummyClass d = h2p.sendImage("Name", "101010101", 100001000, 100001000, array, "Malaria", 100001000);
		for (byte b : array) {
			System.out.println(b);
		}
		System.out.println("XXX"+d.getName());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public byte[] extractBytes (String ImageName) throws IOException {
		// open image
		File imgPath = new File(ImageName);
		BufferedImage bufferedImage = ImageIO.read(imgPath);

		// get DataBufferBytes from Raster
		WritableRaster raster = bufferedImage .getRaster();
		DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

		return ( data.getData() );
	}

}
