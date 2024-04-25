package com.buyogo.project.representation.request;

import com.buyogo.project.entity.TrainingCenterAddress;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TrainingCenterRequest {
    String centerName;
    String centerCode;
    TrainingCenterAddress trainingCenterAddress;
    Integer studentCapacity;
    List<String> coursesOffered;
    Date createdOn;
    String contactMail;
    String contactPhone;

}
