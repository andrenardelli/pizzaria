/**
 * LojaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pizzaria.webservice.test;

public class LojaServiceLocator extends org.apache.axis.client.Service implements com.pizzaria.webservice.test.LojaService {

    public LojaServiceLocator() {
    }


    public LojaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LojaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LojaWSPort
    private java.lang.String LojaWSPort_address = "http://localhost:8080/pizzaria/ws/lojaService";

    public java.lang.String getLojaWSPortAddress() {
        return LojaWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LojaWSPortWSDDServiceName = "LojaWSPort";

    public java.lang.String getLojaWSPortWSDDServiceName() {
        return LojaWSPortWSDDServiceName;
    }

    public void setLojaWSPortWSDDServiceName(java.lang.String name) {
        LojaWSPortWSDDServiceName = name;
    }

    public com.pizzaria.webservice.test.LojaWS getLojaWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LojaWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLojaWSPort(endpoint);
    }

    public com.pizzaria.webservice.test.LojaWS getLojaWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.pizzaria.webservice.test.LojaWSPortBindingStub _stub = new com.pizzaria.webservice.test.LojaWSPortBindingStub(portAddress, this);
            _stub.setPortName(getLojaWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLojaWSPortEndpointAddress(java.lang.String address) {
        LojaWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.pizzaria.webservice.test.LojaWS.class.isAssignableFrom(serviceEndpointInterface)) {
                com.pizzaria.webservice.test.LojaWSPortBindingStub _stub = new com.pizzaria.webservice.test.LojaWSPortBindingStub(new java.net.URL(LojaWSPort_address), this);
                _stub.setPortName(getLojaWSPortWSDDServiceName());
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
        if ("LojaWSPort".equals(inputPortName)) {
            return getLojaWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "lojaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "LojaWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LojaWSPort".equals(portName)) {
            setLojaWSPortEndpointAddress(address);
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
