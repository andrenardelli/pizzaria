/**
 * Produto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pizzaria.webservice.test;

public class Produto  implements java.io.Serializable {
    private long idProduto;

    private java.lang.String nomeProduto;

    private com.pizzaria.webservice.test.TipoProduto tipoProduto;

    private java.math.BigDecimal valorProduto;

    public Produto() {
    }

    public Produto(
           long idProduto,
           java.lang.String nomeProduto,
           com.pizzaria.webservice.test.TipoProduto tipoProduto,
           java.math.BigDecimal valorProduto) {
           this.idProduto = idProduto;
           this.nomeProduto = nomeProduto;
           this.tipoProduto = tipoProduto;
           this.valorProduto = valorProduto;
    }


    /**
     * Gets the idProduto value for this Produto.
     * 
     * @return idProduto
     */
    public long getIdProduto() {
        return idProduto;
    }


    /**
     * Sets the idProduto value for this Produto.
     * 
     * @param idProduto
     */
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }


    /**
     * Gets the nomeProduto value for this Produto.
     * 
     * @return nomeProduto
     */
    public java.lang.String getNomeProduto() {
        return nomeProduto;
    }


    /**
     * Sets the nomeProduto value for this Produto.
     * 
     * @param nomeProduto
     */
    public void setNomeProduto(java.lang.String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    /**
     * Gets the tipoProduto value for this Produto.
     * 
     * @return tipoProduto
     */
    public com.pizzaria.webservice.test.TipoProduto getTipoProduto() {
        return tipoProduto;
    }


    /**
     * Sets the tipoProduto value for this Produto.
     * 
     * @param tipoProduto
     */
    public void setTipoProduto(com.pizzaria.webservice.test.TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }


    /**
     * Gets the valorProduto value for this Produto.
     * 
     * @return valorProduto
     */
    public java.math.BigDecimal getValorProduto() {
        return valorProduto;
    }


    /**
     * Sets the valorProduto value for this Produto.
     * 
     * @param valorProduto
     */
    public void setValorProduto(java.math.BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Produto)) return false;
        Produto other = (Produto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idProduto == other.getIdProduto() &&
            ((this.nomeProduto==null && other.getNomeProduto()==null) || 
             (this.nomeProduto!=null &&
              this.nomeProduto.equals(other.getNomeProduto()))) &&
            ((this.tipoProduto==null && other.getTipoProduto()==null) || 
             (this.tipoProduto!=null &&
              this.tipoProduto.equals(other.getTipoProduto()))) &&
            ((this.valorProduto==null && other.getValorProduto()==null) || 
             (this.valorProduto!=null &&
              this.valorProduto.equals(other.getValorProduto())));
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
        _hashCode += new Long(getIdProduto()).hashCode();
        if (getNomeProduto() != null) {
            _hashCode += getNomeProduto().hashCode();
        }
        if (getTipoProduto() != null) {
            _hashCode += getTipoProduto().hashCode();
        }
        if (getValorProduto() != null) {
            _hashCode += getValorProduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Produto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "produto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomeProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "tipoProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valorProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
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
