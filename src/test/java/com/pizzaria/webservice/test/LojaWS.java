/**
 * LojaWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pizzaria.webservice.test;


public interface LojaWS extends java.rmi.Remote {
    public void finalizarPedido(java.lang.Long arg0) throws java.rmi.RemoteException;
    public Pedido[] getPedidos() throws java.rmi.RemoteException;
}
