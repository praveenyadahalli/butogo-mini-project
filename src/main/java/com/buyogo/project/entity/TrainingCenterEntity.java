package com.buyogo.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "training_centers")
public class TrainingCenterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerId;

    @Size(max = 40, message = "Maximum 40 characters allowed")
    @NotBlank(message = "Center name is mandatory")
    @Column(name = "center_name")
    private String centerName;

    @Size(max = 12, message = "Maximum 12 characters allowed")
    @NotBlank(message = "Center code is mandatory")
    @Pattern(regexp = "^^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{12}$", message = "CenterCode must be exactly 12 alphanumeric characters")
    @Column(name = "center_code")
    private String centerCode;

    @NotNull(message = "Training Center Addresss is mandatory")
    @Embedded
    @Column(name = "training_center_address")
    @Valid
    private TrainingCenterAddress trainingCenterAddress;

    @PositiveOrZero(message = "Student Capacity must be a positive number or zero")
    @Column(name = "training_center_address")
    private Integer studentCapacity;

    @ElementCollection
    @Column(name = "courses_offered")
    private List<String> coursesOffered;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    @Email
    @Column(name = "contact_mail")
    private String contactMail;

    @NotBlank(message = "ContactPhone is mandatory")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "ContactPhone must be a 10-digit number")
    @Column(name = "contact_phone")
    private String contactPhone;

    @PrePersist
    public void prePersist() {
        this.createdOn = new Date();
    }
}
