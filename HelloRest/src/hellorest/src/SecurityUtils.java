package hellorest.src;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;

public class SecurityUtils {
	private final static byte[] PublicKey = {48,-127,-97,48,13,6,9,42,-122,72,-122,-9,13,1,1,1,5,0,3,-127,-115,0,48,-127,-119,2,-127,-127,0,-93,111,-117,28,14,19,59,-86,120,51,-55,66,1,-101,-94,59,46,35,90,59,-72,37,-19,-90,-89,-3,27,76,15,116,70,-67,-27,114,-99,127,70,37,-77,107,-42,58,87,56,58,-118,-67,-71,-115,-69,-13,70,-37,-79,-29,-62,-55,91,-76,-77,-109,91,71,14,54,-23,-98,77,56,69,90,-34,-117,33,40,47,43,22,-70,82,99,43,26,-8,65,12,-1,-113,-80,-27,19,48,-72,-123,-125,-101,-104,-37,-54,-95,99,11,-84,64,19,-117,-71,39,-20,28,12,23,-68,113,-35,114,-14,1,-105,109,-73,40,104,12,-58,49,104,65,2,3,1,0,1};
	private final static byte[] PrivateKey = {48,-126,2,117,2,1,0,48,13,6,9,42,-122,72,-122,-9,13,1,1,1,5,0,4,-126,2,95,48,-126,2,91,2,1,0,2,-127,-127,0,-93,111,-117,28,14,19,59,-86,120,51,-55,66,1,-101,-94,59,46,35,90,59,-72,37,-19,-90,-89,-3,27,76,15,116,70,-67,-27,114,-99,127,70,37,-77,107,-42,58,87,56,58,-118,-67,-71,-115,-69,-13,70,-37,-79,-29,-62,-55,91,-76,-77,-109,91,71,14,54,-23,-98,77,56,69,90,-34,-117,33,40,47,43,22,-70,82,99,43,26,-8,65,12,-1,-113,-80,-27,19,48,-72,-123,-125,-101,-104,-37,-54,-95,99,11,-84,64,19,-117,-71,39,-20,28,12,23,-68,113,-35,114,-14,1,-105,109,-73,40,104,12,-58,49,104,65,2,3,1,0,1,2,-127,-128,46,119,-125,60,-103,-65,-36,33,-18,-123,2,-66,-110,-120,118,74,-113,38,-101,-4,8,-78,55,-20,63,44,-42,58,-4,-43,-39,91,26,70,73,3,43,-91,-126,106,-79,-128,-22,-43,96,-57,-101,-125,-117,9,-103,-12,86,120,48,66,108,79,119,-125,-22,-20,115,-71,-32,-8,-127,-17,-60,77,-35,-22,-60,101,112,-102,-56,48,-124,109,34,40,-80,-42,-83,19,-102,-116,-15,105,5,-73,30,-10,-115,79,33,49,84,-111,-91,-52,94,-122,102,22,126,-2,-93,118,69,-127,41,-19,49,88,72,-97,-15,-30,-28,-126,94,-97,23,59,-43,49,2,65,0,-30,81,-115,-52,-55,10,-59,27,-108,-44,55,-73,101,-86,-20,-59,68,-60,-4,118,-32,-28,-2,-128,105,-115,91,22,97,-53,74,123,-27,-18,119,32,-52,29,84,-15,55,46,-96,-59,-48,-112,-83,-64,-54,98,116,82,-82,109,-56,44,98,-53,-118,126,97,-57,-110,61,2,65,0,-72,-34,-64,-45,57,8,-124,77,-29,33,-73,89,-4,-38,-89,-83,108,-53,-30,107,93,-26,50,-6,-36,-21,-102,-49,41,-68,-118,-110,-56,-64,-118,68,58,-109,-88,-91,-127,49,82,74,-94,-113,55,70,3,90,79,-13,19,-100,117,75,69,108,-66,-5,0,100,-30,85,2,64,73,65,54,-111,-53,-99,53,-47,-56,-87,-84,99,43,-128,88,-27,61,110,57,125,-51,43,-78,9,36,-95,65,-109,-116,17,-2,72,-2,82,-30,-78,117,-1,36,-120,115,97,31,95,8,52,92,89,99,-24,-36,88,10,-25,-77,-4,81,-6,42,24,-32,83,117,-51,2,64,20,12,-12,-44,-13,-26,-100,-110,-26,3,-114,35,80,109,86,-86,84,-106,120,100,52,-74,-10,-24,-122,117,119,64,-24,-63,-18,53,-91,88,92,-90,-79,-61,-70,18,-39,68,68,44,-100,28,-12,93,-65,-105,87,-4,-127,48,2,-8,-70,-6,-28,107,-52,-53,36,81,2,64,30,-81,37,-23,17,24,92,-81,-20,-117,9,59,53,116,-119,13,-72,75,-120,-92,36,28,-57,42,-32,36,101,25,-107,-41,119,121,124,88,-51,14,63,-10,-112,31,-124,-109,52,86,-81,3,99,43,-22,-123,-52,-76,-70,-67,-87,17,49,68,113,-91,22,-85,23,-48};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String texto = "Texto";
		System.out.println("Texto inicial: " + texto);
		


//		//Generate private key public key pair
//		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//		keyPairGenerator.initialize(1024);
//		KeyPair keyPair = keyPairGenerator.generateKeyPair();
//		PrivateKey privateKey = keyPair.getPrivate();
//		PublicKey publicKey = keyPair.getPublic();
//		
//		String puk = "{";
//		byte[] puka = publicKey.getEncoded();
//		for (int i = 0; i != puka.length;i++) {
//			puk+=puka[i] + ((i+1 == puka.length)?"":",");
//		}
//		System.out.println(puk + "}");
//		
//		String prk = "{";
//		byte[] prka = privateKey.getEncoded();
//		for (int i = 0; i != prka.length;i++) {
//			prk+=prka[i] + ((i+1 == prka.length)?"":",");
//		}
//		System.out.println(prk + "}");

		byte[] llaveSim = generateSymetricKey();

		String dataEnc = encriptDataSymetric(llaveSim, texto);

		String llaveSimEnc = encryptSymetricByPublic(getPuKey(PublicKey), llaveSim);

		byte[] llaveSimDecr = decryptSymmetricKey(getPrKey(PrivateKey), llaveSimEnc);

		String nuevoTexto = decryptDataWithSymmetricKey(dataEnc, llaveSimDecr);

		System.out.println("Texto final: " + nuevoTexto);
	}



	public static byte[] generateSymetricKey() throws NoSuchAlgorithmException{
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(128);
		SecretKey key = generator.generateKey();
		byte[] symmetricKey =key.getEncoded();
		return symmetricKey; 
	}

	public static String encriptDataSymetric(byte[] symmetricKey, String data) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
		String encryptedData = encryptWithAESKey(data, symmetricKey);
		return encryptedData;
	}

	public static String encryptSymetricByPublic(PublicKey publicKey, byte[] symmetricKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		String encryptedkey =Base64.encodeBase64String(cipher.doFinal(symmetricKey));
		return encryptedkey;
	}

	public static PublicKey getPuKey(byte[] keyBytes) throws InvalidKeySpecException, IOException, NoSuchAlgorithmException{
		//byte[] keyBytes= (new BASE64Decoder()).decodeBuffer(key); 
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes); 
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec); 
		return publicKey;
	}

	public static PrivateKey getPrKey(byte[] byteKey) throws InvalidKeySpecException, NoSuchAlgorithmException{
		//byte[] byteKey = Base64.decodeBase64(key);
	    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(byteKey);
	    KeyFactory fact = KeyFactory.getInstance("RSA");
	    PrivateKey priv = fact.generatePrivate(keySpec);
	    //Arrays.fill(clear, (byte) 0);
	    return priv;
	}

	public static byte[] decryptSymmetricKey(PrivateKey privateKey, String encryptedkey) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
		Cipher dipher = Cipher.getInstance("RSA");

		dipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedSymmetricKey =dipher.doFinal(Base64.decodeBase64(encryptedkey));
		return decryptedSymmetricKey;
	}

	public static String decryptDataWithSymmetricKey(String encryptedData, byte[] decryptedSymmetricKey ) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		return decryptWithAESKey(encryptedData, decryptedSymmetricKey);
	}


	public static String encryptWithAESKey(String data, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		SecretKey secKey = new SecretKeySpec(key,"AES");

		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.ENCRYPT_MODE, secKey);
		byte[] newData = cipher.doFinal(data.getBytes());

		return Base64.encodeBase64String(newData);
	}

	public static String decryptWithAESKey(String inputData, byte[] key) throws NoSuchAlgorithmException,
	NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES");
		SecretKey secKey = new SecretKeySpec(key, "AES");

		cipher.init(Cipher.DECRYPT_MODE, secKey);
		byte[] newData = cipher.doFinal(Base64.decodeBase64(inputData.getBytes()));
		return new String(newData);

	}

}
