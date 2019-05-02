
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
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="projectName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="projectStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estimatedHrs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loggedHrs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="remainingHrs" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "projectId",
    "projectName",
    "projectStatus",
    "estimatedHrs",
    "loggedHrs",
    "remainingHrs"
})
@XmlRootElement(name = "ProjectDetailsType")
public class ProjectDetailsType {

    protected int projectId;
    @XmlElement(required = true)
    protected String projectName;
    @XmlElement(required = true)
    protected String projectStatus;
    protected int estimatedHrs;
    protected int loggedHrs;
    protected int remainingHrs;

    /**
     * Gets the value of the projectId property.
     * 
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of the projectId property.
     * 
     */
    public void setProjectId(int value) {
        this.projectId = value;
    }

    /**
     * Gets the value of the projectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets the value of the projectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectName(String value) {
        this.projectName = value;
    }

    /**
     * Gets the value of the projectStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectStatus() {
        return projectStatus;
    }

    /**
     * Sets the value of the projectStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectStatus(String value) {
        this.projectStatus = value;
    }

    /**
     * Gets the value of the estimatedHrs property.
     * 
     */
    public int getEstimatedHrs() {
        return estimatedHrs;
    }

    /**
     * Sets the value of the estimatedHrs property.
     * 
     */
    public void setEstimatedHrs(int value) {
        this.estimatedHrs = value;
    }

    /**
     * Gets the value of the loggedHrs property.
     * 
     */
    public int getLoggedHrs() {
        return loggedHrs;
    }

    /**
     * Sets the value of the loggedHrs property.
     * 
     */
    public void setLoggedHrs(int value) {
        this.loggedHrs = value;
    }

    /**
     * Gets the value of the remainingHrs property.
     * 
     */
    public int getRemainingHrs() {
        return remainingHrs;
    }

    /**
     * Sets the value of the remainingHrs property.
     * 
     */
    public void setRemainingHrs(int value) {
        this.remainingHrs = value;
    }

}
