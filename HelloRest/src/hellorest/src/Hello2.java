package hellorest.src;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Hello2
{
    private final String message = new String("Hello, ");

    public Hello2()
    {}

    @WebMethod(operationName="sendImage")
    public DummyClass sayHello(String pacientName, String pacientId,
    		long longitud, long latitud,
    		byte[] byteArray, String disease,
    		long key){
    	System.out.println("pacientName: " +  pacientName
    			 + "\n pacientId: " +   pacientId
    			 + "\n longitud: " + longitud
    			 + "\n latitud: " + latitud
    			 + "\n disease: " + disease
    			 + "\n key: " + key);
    	
    	DummyClass dc = new DummyClass(pacientId, 1, byteArray);
        return dc;
    }
}