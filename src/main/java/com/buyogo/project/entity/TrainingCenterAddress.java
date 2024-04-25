package com.buyogo.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TrainingCenterAddress {

    @NotBlank(message = "Detailed Address is mandatory")
    private String detailAddress;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Pincode is mandatory")
    private String pincode;
}
