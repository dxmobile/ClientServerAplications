/**
 * Hello2ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hellorest.src;

public class Hello2ServiceLocator extends org.apache.axis.client.Service implements hellorest.src.Hello2Service {

    public Hello2ServiceLocator() {
    }


    public Hello2ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Hello2ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Hello2Port
    private java.lang.String Hello2Port_address = "http://localhost:8088/HelloRest/Hello2";

    public java.lang.String getHello2PortAddress() {
        return Hello2Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Hello2PortWSDDServiceName = "Hello2Port";

    public java.lang.String getHello2PortWSDDServiceName() {
        return Hello2PortWSDDServiceName;
    }

    public void setHello2PortWSDDServiceName(java.lang.String name) {
        Hello2PortWSDDServiceName = name;
    }

    public hellorest.src.Hello2 getHello2Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Hello2Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHello2Port(endpoint);
    }

    public hellorest.src.Hello2 getHello2Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            hellorest.src.Hello2ServiceSoapBindingStub _stub = new hellorest.src.Hello2ServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getHello2PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHello2PortEndpointAddress(java.lang.String address) {
        Hello2Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (hellorest.src.Hello2.class.isAssignableFrom(serviceEndpointInterface)) {
                hellorest.src.Hello2ServiceSoapBindingStub _stub = new hellorest.src.Hello2ServiceSoapBindingStub(new java.net.URL(Hello2Port_address), this);
                _stub.setPortName(getHello2PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Hello2Port".equals(inputPortName)) {
            return getHello2Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://src.hellorest/", "Hello2Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://src.hellorest/", "Hello2Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Hello2Port".equals(portName)) {
            setHello2PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
