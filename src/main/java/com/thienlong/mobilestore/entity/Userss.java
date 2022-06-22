package com.thienlong.mobilestore.entity;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Userss {
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer ID;
    @Column(name = "user_name", length = 50, nullable = false)
    private String userName;
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "role_id", length = 2, nullable = false)
    private int roleID;

    public Userss() {
    }

    public Userss(String userName, String password, int roleID) {
        this.userName = userName;
        this.password = password;
        this.roleID = roleID;
    }

    public Userss(Integer ID, String userName, String password, int roleID) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.roleID = roleID;
    }

    public Userss(Integer ID, String userName, String fullName, String password, int roleID) {
        this.ID = ID;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.roleID = roleID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", roleID='" + roleID + '\'' +
                '}';
    }
}