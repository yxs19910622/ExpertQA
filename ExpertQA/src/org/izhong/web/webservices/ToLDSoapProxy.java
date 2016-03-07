package org.izhong.web.webservices;

public class ToLDSoapProxy implements org.izhong.web.webservices.ToLDSoap {
  private String _endpoint = null;
  private org.izhong.web.webservices.ToLDSoap toLDSoap = null;
  
  public ToLDSoapProxy() {
    _initToLDSoapProxy();
  }
  
  public ToLDSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initToLDSoapProxy();
  }
  
  private void _initToLDSoapProxy() {
    try {
      toLDSoap = (new org.izhong.web.webservices.ToLDLocator()).gettoLDSoap();
      if (toLDSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)toLDSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)toLDSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (toLDSoap != null)
      ((javax.xml.rpc.Stub)toLDSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.izhong.web.webservices.ToLDSoap getToLDSoap() {
    if (toLDSoap == null)
      _initToLDSoapProxy();
    return toLDSoap;
  }
  
  public java.lang.String getOrderByCustomerID(java.lang.String customerID) throws java.rmi.RemoteException{
    if (toLDSoap == null)
      _initToLDSoapProxy();
    return toLDSoap.getOrderByCustomerID(customerID);
  }
  
  public boolean updateOrderData(java.lang.String dataXML) throws java.rmi.RemoteException{
    if (toLDSoap == null)
      _initToLDSoapProxy();
    return toLDSoap.updateOrderData(dataXML);
  }
  
  
}