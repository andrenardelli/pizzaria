/**
 * Pedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pizzaria.webservice.test;

public class Pedido  implements java.io.Serializable {
    private com.pizzaria.webservice.test.Consumidor consumidor;

    private java.util.Calendar dataFechamento;

    private java.util.Calendar dataSolicitacao;

    private long idPedido;

    private com.pizzaria.webservice.test.ItemPedido[] itensPedido;

    public Pedido() {
    }

    public Pedido(
           com.pizzaria.webservice.test.Consumidor consumidor,
           java.util.Calendar dataFechamento,
           java.util.Calendar dataSolicitacao,
           long idPedido,
           com.pizzaria.webservice.test.ItemPedido[] itensPedido) {
           this.consumidor = consumidor;
           this.dataFechamento = dataFechamento;
           this.dataSolicitacao = dataSolicitacao;
           this.idPedido = idPedido;
           this.itensPedido = itensPedido;
    }


    /**
     * Gets the consumidor value for this Pedido.
     * 
     * @return consumidor
     */
    public com.pizzaria.webservice.test.Consumidor getConsumidor() {
        return consumidor;
    }


    /**
     * Sets the consumidor value for this Pedido.
     * 
     * @param consumidor
     */
    public void setConsumidor(com.pizzaria.webservice.test.Consumidor consumidor) {
        this.consumidor = consumidor;
    }


    /**
     * Gets the dataFechamento value for this Pedido.
     * 
     * @return dataFechamento
     */
    public java.util.Calendar getDataFechamento() {
        return dataFechamento;
    }


    /**
     * Sets the dataFechamento value for this Pedido.
     * 
     * @param dataFechamento
     */
    public void setDataFechamento(java.util.Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
    }


    /**
     * Gets the dataSolicitacao value for this Pedido.
     * 
     * @return dataSolicitacao
     */
    public java.util.Calendar getDataSolicitacao() {
        return dataSolicitacao;
    }


    /**
     * Sets the dataSolicitacao value for this Pedido.
     * 
     * @param dataSolicitacao
     */
    public void setDataSolicitacao(java.util.Calendar dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }


    /**
     * Gets the idPedido value for this Pedido.
     * 
     * @return idPedido
     */
    public long getIdPedido() {
        return idPedido;
    }


    /**
     * Sets the idPedido value for this Pedido.
     * 
     * @param idPedido
     */
    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }


    /**
     * Gets the itensPedido value for this Pedido.
     * 
     * @return itensPedido
     */
    public com.pizzaria.webservice.test.ItemPedido[] getItensPedido() {
        return itensPedido;
    }


    /**
     * Sets the itensPedido value for this Pedido.
     * 
     * @param itensPedido
     */
    public void setItensPedido(com.pizzaria.webservice.test.ItemPedido[] itensPedido) {
        this.itensPedido = itensPedido;
    }

    public com.pizzaria.webservice.test.ItemPedido getItensPedido(int i) {
        return this.itensPedido[i];
    }

    public void setItensPedido(int i, com.pizzaria.webservice.test.ItemPedido _value) {
        this.itensPedido[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pedido)) return false;
        Pedido other = (Pedido) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consumidor==null && other.getConsumidor()==null) || 
             (this.consumidor!=null &&
              this.consumidor.equals(other.getConsumidor()))) &&
            ((this.dataFechamento==null && other.getDataFechamento()==null) || 
             (this.dataFechamento!=null &&
              this.dataFechamento.equals(other.getDataFechamento()))) &&
            ((this.dataSolicitacao==null && other.getDataSolicitacao()==null) || 
             (this.dataSolicitacao!=null &&
              this.dataSolicitacao.equals(other.getDataSolicitacao()))) &&
            this.idPedido == other.getIdPedido() &&
            ((this.itensPedido==null && other.getItensPedido()==null) || 
             (this.itensPedido!=null &&
              java.util.Arrays.equals(this.itensPedido, other.getItensPedido())));
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
        if (getConsumidor() != null) {
            _hashCode += getConsumidor().hashCode();
        }
        if (getDataFechamento() != null) {
            _hashCode += getDataFechamento().hashCode();
        }
        if (getDataSolicitacao() != null) {
            _hashCode += getDataSolicitacao().hashCode();
        }
        _hashCode += new Long(getIdPedido()).hashCode();
        if (getItensPedido() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItensPedido());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItensPedido(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pedido.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "pedido"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consumidor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consumidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "consumidor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFechamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataFechamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataSolicitacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataSolicitacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itensPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itensPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "itemPedido"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
