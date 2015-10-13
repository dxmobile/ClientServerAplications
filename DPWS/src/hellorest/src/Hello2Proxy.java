package hellorest.src;

public class Hello2Proxy implements hellorest.src.Hello2 {
  private String _endpoint = null;
  private hellorest.src.Hello2 hello2 = null;
  
  public Hello2Proxy() {
    _initHello2Proxy();
  }
  
  public Hello2Proxy(String endpoint) {
    _endpoint = endpoint;
    _initHello2Proxy();
  }
  
  private void _initHello2Proxy() {
    try {
      hello2 = (new hellorest.src.Hello2ServiceLocator()).getHello2Port();
      if (hello2 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hello2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hello2)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hello2 != null)
      ((javax.xml.rpc.Stub)hello2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public hellorest.src.Hello2 getHello2() {
    if (hello2 == null)
      _initHello2Proxy();
    return hello2;
  }
  
  public hellorest.src.DummyClass sendImage(java.lang.String arg0, java.lang.String arg1, long arg2, long arg3, byte[] arg4, java.lang.String arg5, long arg6) throws java.rmi.RemoteException{
    if (hello2 == null)
      _initHello2Proxy();
    return hello2.sendImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  
}