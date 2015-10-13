/**
 * Consumidor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pizzaria.webservice.test;

public class Consumidor  extends com.pizzaria.webservice.test.Usuario  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String CPFConsumidor;

    private java.lang.String nomeConsumidor;

    private com.pizzaria.webservice.test.Pedido[] pedidos;

    public Consumidor() {
    }

    public Consumidor(
           java.lang.String login,
           java.lang.String senha,
           java.lang.String CPFConsumidor,
           java.lang.String nomeConsumidor,
           com.pizzaria.webservice.test.Pedido[] pedidos) {
        super(
            login,
            senha);
        this.CPFConsumidor = CPFConsumidor;
        this.nomeConsumidor = nomeConsumidor;
        this.pedidos = pedidos;
    }


    /**
     * Gets the CPFConsumidor value for this Consumidor.
     * 
     * @return CPFConsumidor
     */
    public java.lang.String getCPFConsumidor() {
        return CPFConsumidor;
    }


    /**
     * Sets the CPFConsumidor value for this Consumidor.
     * 
     * @param CPFConsumidor
     */
    public void setCPFConsumidor(java.lang.String CPFConsumidor) {
        this.CPFConsumidor = CPFConsumidor;
    }


    /**
     * Gets the nomeConsumidor value for this Consumidor.
     * 
     * @return nomeConsumidor
     */
    public java.lang.String getNomeConsumidor() {
        return nomeConsumidor;
    }


    /**
     * Sets the nomeConsumidor value for this Consumidor.
     * 
     * @param nomeConsumidor
     */
    public void setNomeConsumidor(java.lang.String nomeConsumidor) {
        this.nomeConsumidor = nomeConsumidor;
    }


    /**
     * Gets the pedidos value for this Consumidor.
     * 
     * @return pedidos
     */
    public com.pizzaria.webservice.test.Pedido[] getPedidos() {
        return pedidos;
    }


    /**
     * Sets the pedidos value for this Consumidor.
     * 
     * @param pedidos
     */
    public void setPedidos(com.pizzaria.webservice.test.Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

    public com.pizzaria.webservice.test.Pedido getPedidos(int i) {
        return this.pedidos[i];
    }

    public void setPedidos(int i, com.pizzaria.webservice.test.Pedido _value) {
        this.pedidos[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Consumidor)) return false;
        Consumidor other = (Consumidor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.CPFConsumidor==null && other.getCPFConsumidor()==null) || 
             (this.CPFConsumidor!=null &&
              this.CPFConsumidor.equals(other.getCPFConsumidor()))) &&
            ((this.nomeConsumidor==null && other.getNomeConsumidor()==null) || 
             (this.nomeConsumidor!=null &&
              this.nomeConsumidor.equals(other.getNomeConsumidor()))) &&
            ((this.pedidos==null && other.getPedidos()==null) || 
             (this.pedidos!=null &&
              java.util.Arrays.equals(this.pedidos, other.getPedidos())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCPFConsumidor() != null) {
            _hashCode += getCPFConsumidor().hashCode();
        }
        if (getNomeConsumidor() != null) {
            _hashCode += getNomeConsumidor().hashCode();
        }
        if (getPedidos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPedidos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPedidos(), i);
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
        new org.apache.axis.description.TypeDesc(Consumidor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "consumidor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPFConsumidor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CPFConsumidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeConsumidor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nomeConsumidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pedidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pedidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.pizzaria.com/", "pedido"));
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
