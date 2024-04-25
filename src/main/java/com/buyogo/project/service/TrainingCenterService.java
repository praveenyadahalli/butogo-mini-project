package com.buyogo.project.service;


import com.buyogo.project.representation.request.TrainingCenterRequest;
import com.buyogo.project.representation.response.TrainingCenterResponse;

import java.util.List;

public interface TrainingCenterService {
    public TrainingCenterResponse addNewTrainingCenter(TrainingCenterRequest trainingCenterRequest);

    public List<TrainingCenterResponse> getAllTrainingCenters(String centerCode);
}
