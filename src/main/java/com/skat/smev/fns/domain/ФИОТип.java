//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.12 at 03:29:52 PM MSK 
//


package com.skat.smev.fns.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Фамилия, имя, отчество физического лица
 * 
 * <p>Java class for ФИОТип complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ФИОТип">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Фамилия" use="required" type="{urn://x-artefacts-fns-inn/commons/4.0.0}string-60" />
 *       &lt;attribute name="Имя" use="required" type="{urn://x-artefacts-fns-inn/commons/4.0.0}string-60" />
 *       &lt;attribute name="Отчество" type="{urn://x-artefacts-fns-inn/commons/4.0.0}string-60" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u0424\u0418\u041e\u0422\u0438\u043f", namespace = "urn://x-artefacts-fns-inn/commons/4.0.0")
public class ФИОТип {

    //ФИОТип
    @XmlAttribute(name = "\u0424\u0430\u043c\u0438\u043b\u0438\u044f", required = true)
    protected String фамилия;
    @XmlAttribute(name = "\u0418\u043c\u044f", required = true)
    protected String имя;
    @XmlAttribute(name = "\u041e\u0442\u0447\u0435\u0441\u0442\u0432\u043e")
    protected String отчество;

    /**
     * Gets the value of the фамилия property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getФамилия() {
        return фамилия;
    }

    /**
     * Sets the value of the фамилия property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setФамилия(String value) {
        this.фамилия = value;
    }

    /**
     * Gets the value of the имя property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getИмя() {
        return имя;
    }

    /**
     * Sets the value of the имя property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setИмя(String value) {
        this.имя = value;
    }

    /**
     * Gets the value of the отчество property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getОтчество() {
        return отчество;
    }

    /**
     * Sets the value of the отчество property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setОтчество(String value) {
        this.отчество = value;
    }

}
