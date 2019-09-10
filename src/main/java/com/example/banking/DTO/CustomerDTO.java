package com.example.banking.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CustomerDTO {

    @NotBlank
    @Size(min = 3, max = 10)
    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
