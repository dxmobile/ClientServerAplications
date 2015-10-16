package hellorest.src.news;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import hellorest.src.DummyClass;
import hellorest.src.Hello2Proxy;

public class Main {

	private final static byte[] PublicKey = {48,-127,-97,48,13,6,9,42,-122,72,-122,-9,13,1,1,1,5,0,3,-127,-115,0,48,-127,-119,2,-127,-127,0,-93,111,-117,28,14,19,59,-86,120,51,-55,66,1,-101,-94,59,46,35,90,59,-72,37,-19,-90,-89,-3,27,76,15,116,70,-67,-27,114,-99,127,70,37,-77,107,-42,58,87,56,58,-118,-67,-71,-115,-69,-13,70,-37,-79,-29,-62,-55,91,-76,-77,-109,91,71,14,54,-23,-98,77,56,69,90,-34,-117,33,40,47,43,22,-70,82,99,43,26,-8,65,12,-1,-113,-80,-27,19,48,-72,-123,-125,-101,-104,-37,-54,-95,99,11,-84,64,19,-117,-71,39,-20,28,12,23,-68,113,-35,114,-14,1,-105,109,-73,40,104,12,-58,49,104,65,2,3,1,0,1};
	
	String symKeyEnc;
	String message;

	public Main() throws Exception{

		Hello2Proxy h2p = new Hello2Proxy();
		byte[] array = extractBytes ("C:\\Users\\Andres\\Desktop\\B&N\\aaa.jpg");
		String textToEncrypt = "textoAEncriptar";
		encryptAndGenerateSymKey(textToEncrypt);
		System.out.println("Llave:" + symKeyEnc);
		System.out.println("Mensaje:" + message);
		DummyClass d = h2p.sendImage("Name", symKeyEnc, 100001000, 100001000, null, message, 100001000);
//		for (byte b : array) {
//			System.out.println(b);
//		}
		System.out.println(new String(d.getByteArray()));
	}

	public static void main(String[] args) throws Exception {
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
	
	private void encryptAndGenerateSymKey(String data) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, IOException{

		byte[] symKey = SecurityUtils.generateSymetricKey();

		message = SecurityUtils.encriptDataSymetric(symKey, data);

		symKeyEnc = SecurityUtils.encryptSymetricByPublic(SecurityUtils.getPuKey(PublicKey), symKey);
		
	}
}
