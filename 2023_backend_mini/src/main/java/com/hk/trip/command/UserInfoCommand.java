package com.hk.trip.command;

import jakarta.validation.constraints.NotBlank;

public class UserInfoCommand {

    private String id;
    
    @NotBlank(message = "주소를 입력하세요")
    private String address;
    
    @NotBlank(message = "이메일을 입력하세요")
    private String email;

    public UserInfoCommand() {
        super();
    }

    public UserInfoCommand(String id, String address, String email) {
        super();
        this.id = id;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfoCommand [id=" + id + ", address=" + address + ", email=" + email + "]";
    }

}
