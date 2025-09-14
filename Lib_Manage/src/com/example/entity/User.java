package com.example.entity;

public class User {
    private long id;
    private String username;
    private String fullName;
    private String contactNo;
    private String email;
    private String password;
    private String role;
    private String dob;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(long id, String username, String fullName, String contactNo, String email, String password, String role, String dob) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.contactNo = contactNo;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dob = dob;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
