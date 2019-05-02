
package com.evry.fs.payment.pms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://evry.com/fs/payment/pms}ProjectDetailsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "projectDetailsType"
})
@XmlRootElement(name = "addProjectRequestType")
public class AddProjectRequestType {

    @XmlElement(name = "ProjectDetailsType", required = true)
    protected ProjectDetailsType projectDetailsType;

    /**
     * Gets the value of the projectDetailsType property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectDetailsType }
     *     
     */
    public ProjectDetailsType getProjectDetailsType() {
        return projectDetailsType;
    }

    /**
     * Sets the value of the projectDetailsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectDetailsType }
     *     
     */
    public void setProjectDetailsType(ProjectDetailsType value) {
        this.projectDetailsType = value;
    }

}
