package com.buyogo.project.representation.response;

import com.buyogo.project.entity.TrainingCenterAddress;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TrainingCenterResponse {
    Long centerId;
    String centerName;
    String centerCode;
    TrainingCenterAddress trainingCenterAddress;
    Integer studentCapacity;
    List<String> coursesOffered;
    Date createdOn;
    String contactMail;
    String contactPhone;
}
