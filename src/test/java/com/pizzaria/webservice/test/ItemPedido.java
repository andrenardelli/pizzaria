/**
 * ItemPedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pizzaria.webservice.test;

public class ItemPedido  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long idItemPedido;

    private com.pizzaria.webservice.test.Produto produto;

    private int qtdeProdutos;

    public ItemPedido() {
    }

    public ItemPedido(
           long idItemPedido,
           com.pizzaria.webservice.test.Produto produto,
           int qtdeProdutos) {
           this.idItemPedido = idItemPedido;
           this.produto = produto;
           this.qtdeProdutos = qtdeProdutos;
    }


    /**
     * Gets the idItemPedido value for this ItemPedido.
     * 
     * @return idItemPedido
     */
    public long getIdItemPedido() {
        return idItemPedido;
    }


    /**
     * Sets the idItemPedido value for this ItemPedido.
     * 
     * @param idItemPedido
     */
    public void setIdItemPedido(long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }


    /**
     * Gets the produto value for this ItemPedido.
     * 
     * @return produto
     */
    public com.pizzaria.webservice.test.Produto getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this ItemPedido.
     * 
     * @param produto
     */
    public void setProduto(com.pizzaria.webservice.test.Produto produto) {
        this.produto = produto;
    }


    /**
     * Gets the qtdeProdutos value for this ItemPedido.
     * 
     * @return qtdeProdutos
     */
    public int getQtdeProdutos() {
        return qtdeProdutos;
    }


    /**
     * Sets the qtdeProdutos value for this ItemPedido.
     * 
     * @param qtdeProdutos
     */
    public void setQtdeProdutos(int qtdeProdutos) {
        this.qtdeProdutos = qtdeProdutos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ItemPedido)) return false;
        ItemPedido other = (ItemPedido) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idItemPedido == other.getIdItemPedido() &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            this.qtdeProdutos == other.getQtdeProdutos();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Long(getIdItemPedido()).hashCode();
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        _hashCode += getQtdeProdutos();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ItemPedido.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "itemPedido"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idItemPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idItemPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "produto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeProdutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeProdutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
