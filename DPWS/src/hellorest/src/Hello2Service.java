/**
 * Hello2Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hellorest.src;

public interface Hello2Service extends javax.xml.rpc.Service {
    public java.lang.String getHello2PortAddress();

    public hellorest.src.Hello2 getHello2Port() throws javax.xml.rpc.ServiceException;

    public hellorest.src.Hello2 getHello2Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
