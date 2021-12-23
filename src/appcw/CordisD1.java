/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcw;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdul
 */
public class CordisD1 {
    int projectRcn, projectID, id, Pid;
    String projectAcronym, role, name, shortName, activityType, endOfParticipation, ecContribution, country, street, city, postCode, organizationUrl, vatNumber;

    public CordisD1(int projectRcn, int projectID, int id, int Pid, String projectAcronym, String role, String name, String shortName, String activityType, String endOfParticipation, String ecContribution, String country, String street, String city, String postCode, String organizationUrl, String vatNumber) {
        this.projectRcn = projectRcn;
        this.projectID = projectID;
        this.id = id;
        this.Pid = Pid;
        this.projectAcronym = projectAcronym;
        this.role = role;
        this.name = name;
        this.shortName = shortName;
        this.activityType = activityType;
        this.endOfParticipation = endOfParticipation;
        this.ecContribution = ecContribution;
        this.country = country;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.organizationUrl = organizationUrl;
        this.vatNumber = vatNumber;
        
    }

    public int getProjectRcn() {
        return projectRcn;
    }

    public void setProjectRcn(int projectRcn) {
        this.projectRcn = projectRcn;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int Pid) {
        this.Pid = Pid;
    }

    public String getProjectAcronym() {
        return projectAcronym;
    }

    public void setProjectAcronym(String projectAcronym) {
        this.projectAcronym = projectAcronym;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getEndOfParticipation() {
        return endOfParticipation;
    }

    public void setEndOfParticipation(String endOfParticipation) {
        this.endOfParticipation = endOfParticipation;
    }

    public String getEcContribution() {
        return ecContribution;
    }

    public void setEcContribution(String ecContribution) {
        this.ecContribution = ecContribution;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getOrganizationUrl() {
        return organizationUrl;
    }

    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    
    Connection connection;

    public CordisD1() {
        connection = SqliteConnection.Connector2();
        if (connection == null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
