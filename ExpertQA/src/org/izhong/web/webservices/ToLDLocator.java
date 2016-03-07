/**
 * ToLDLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.izhong.web.webservices;

public class ToLDLocator extends org.apache.axis.client.Service implements org.izhong.web.webservices.ToLD {

    public ToLDLocator() {
    }


    public ToLDLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ToLDLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for toLDSoap
    //private java.lang.String toLDSoap_address = "http://icreambak.izhong.com/WebService/toLD.asmx";
    //private java.lang.String toLDSoap_address = "http://192.168.40.111/IZWebService/WebService/toLD.asmx";
    //private java.lang.String toLDSoap_address = "http://192.168.50.175/WebServiceStub/Service1.asmx?wsdl";
    private java.lang.String toLDSoap_address = "http://icreambak.izhong.com/WebService/toLD.asmx?wsdl";
    public java.lang.String gettoLDSoapAddress() {
        return toLDSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String toLDSoapWSDDServiceName = "toLDSoap";

    public java.lang.String gettoLDSoapWSDDServiceName() {
        return toLDSoapWSDDServiceName;
    }

    public void settoLDSoapWSDDServiceName(java.lang.String name) {
        toLDSoapWSDDServiceName = name;
    }

    public org.izhong.web.webservices.ToLDSoap gettoLDSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(toLDSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gettoLDSoap(endpoint);
    }

    public org.izhong.web.webservices.ToLDSoap gettoLDSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.izhong.web.webservices.ToLDSoapStub _stub = new org.izhong.web.webservices.ToLDSoapStub(portAddress, this);
            _stub.setPortName(gettoLDSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void settoLDSoapEndpointAddress(java.lang.String address) {
        toLDSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.izhong.web.webservices.ToLDSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.izhong.web.webservices.ToLDSoapStub _stub = new org.izhong.web.webservices.ToLDSoapStub(new java.net.URL(toLDSoap_address), this);
                _stub.setPortName(gettoLDSoapWSDDServiceName());
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
        if ("toLDSoap".equals(inputPortName)) {
            return gettoLDSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "toLD");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "toLDSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("toLDSoap".equals(portName)) {
            settoLDSoapEndpointAddress(address);
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
