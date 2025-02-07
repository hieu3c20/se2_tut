package EmployeeManagement.demo.model;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserTemplate {
    @Length(min = 6, max = 60)
    private String username;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{6,60}$",
            message = "6 chars min (at least 1" +
                    "digit & 1 uppercase letter)")
    private String password;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
