/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sumanheuju
 */
@Entity
@Table(name = "tbl_profile_users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfileUser.findAll", query = "SELECT p FROM ProfileUser p")
    , @NamedQuery(name = "ProfileUser.findByProfileUserId", query = "SELECT p FROM ProfileUser p WHERE p.profileUserId = :profileUserId")
    , @NamedQuery(name = "ProfileUser.findByName", query = "SELECT p FROM ProfileUser p WHERE p.name = :name")
    , @NamedQuery(name = "ProfileUser.findByAddress", query = "SELECT p FROM ProfileUser p WHERE p.address = :address")
    , @NamedQuery(name = "ProfileUser.findByContactNo", query = "SELECT p FROM ProfileUser p WHERE p.contactNo = :contactNo")
    , @NamedQuery(name = "ProfileUser.findByLicenseNo", query = "SELECT p FROM ProfileUser p WHERE p.licenseNo = :licenseNo")
    , @NamedQuery(name = "ProfileUser.findByBloodGroup", query = "SELECT p FROM ProfileUser p WHERE p.bloodGroup = :bloodGroup")
    , @NamedQuery(name = "ProfileUser.findByVehicleNo", query = "SELECT p FROM ProfileUser p WHERE p.vehicleNo = :vehicleNo")
    , @NamedQuery(name = "ProfileUser.findByEmail", query = "SELECT p FROM ProfileUser p WHERE p.email = :email")
    , @NamedQuery(name = "ProfileUser.findByProfilePicture", query = "SELECT p FROM ProfileUser p WHERE p.profilePicture = :profilePicture")})
public class ProfileUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "profile_user_id")
    private Integer profileUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contact_no")
    private String contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "license_no")
    private String licenseNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "blood_group")
    private String bloodGroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vehicle_no")
    private String vehicleNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "profile_picture")
    private String profilePicture;
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileUserId",fetch = FetchType.EAGER)
    private List<Profile> profileList;

    public ProfileUser() {
    }

    public ProfileUser(Integer profileUserId) {
        this.profileUserId = profileUserId;
    }

    public ProfileUser(Integer profileUserId, String name, String address, String contactNo, String licenseNo, String bloodGroup, String vehicleNo, String email, String profilePicture) {
        this.profileUserId = profileUserId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.licenseNo = licenseNo;
        this.bloodGroup = bloodGroup;
        this.vehicleNo = vehicleNo;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public Integer getProfileUserId() {
        return profileUserId;
    }

    public void setProfileUserId(Integer profileUserId) {
        this.profileUserId = profileUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @XmlTransient
    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    

    @Override
    public String toString() {
        return "com.vortex.mavenproject1.entity.ProfileUser[ profileUserId=" + profileUserId + " ]";
    }
    
}
