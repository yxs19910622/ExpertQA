/**
 * ToLDSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.izhong.web.webservices;

public interface ToLDSoap extends java.rmi.Remote {

    /**
     * 用于根据客户号，查找客户订单订购信息，发票信息
     */
    public java.lang.String getOrderByCustomerID(java.lang.String customerID) throws java.rmi.RemoteException;

    /**
     * 根据XML 的参数修改订单信息
     */
    public boolean updateOrderData(java.lang.String dataXML) throws java.rmi.RemoteException;
}
