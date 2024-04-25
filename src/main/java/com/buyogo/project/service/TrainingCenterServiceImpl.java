package com.buyogo.project.service;

import com.buyogo.project.entity.TrainingCenterEntity;
import com.buyogo.project.repository.TrainingCenterRepository;
import com.buyogo.project.representation.request.TrainingCenterRequest;
import com.buyogo.project.representation.response.TrainingCenterResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {
    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public TrainingCenterResponse addNewTrainingCenter(TrainingCenterRequest trainingCenterRequest) {
        TrainingCenterEntity trainingCenterEntity = new TrainingCenterEntity();
        trainingCenterEntity.setCenterName(trainingCenterRequest.getCenterName());
        trainingCenterEntity.setCenterCode(trainingCenterRequest.getCenterCode());
        trainingCenterEntity.setTrainingCenterAddress(trainingCenterRequest.getTrainingCenterAddress());
        trainingCenterEntity.setStudentCapacity(trainingCenterRequest.getStudentCapacity());
        trainingCenterEntity.setCoursesOffered(trainingCenterRequest.getCoursesOffered());
        trainingCenterEntity.setCreatedOn(trainingCenterRequest.getCreatedOn());
        trainingCenterEntity.setContactMail(trainingCenterRequest.getContactMail());
        trainingCenterEntity.setContactPhone(trainingCenterRequest.getContactPhone());
        trainingCenterRepository.save(trainingCenterEntity);
        return getTrainingCenterResponse(trainingCenterEntity);
    }

    private TrainingCenterResponse getTrainingCenterResponse(TrainingCenterEntity trainingCenterEntity) {
        TrainingCenterResponse trainingCenterResponse = new TrainingCenterResponse();
        trainingCenterResponse.setCenterId(trainingCenterEntity.getCenterId());
        trainingCenterResponse.setCenterName(trainingCenterEntity.getCenterName());
        trainingCenterResponse.setCenterCode(trainingCenterEntity.getCenterCode());
        trainingCenterResponse.setTrainingCenterAddress(trainingCenterEntity.getTrainingCenterAddress());
        trainingCenterResponse.setStudentCapacity(trainingCenterEntity.getStudentCapacity());
        trainingCenterResponse.setCoursesOffered(trainingCenterEntity.getCoursesOffered());
        trainingCenterResponse.setCreatedOn(trainingCenterEntity.getCreatedOn());
        trainingCenterResponse.setContactMail(trainingCenterEntity.getContactMail());
        trainingCenterResponse.setContactPhone(trainingCenterEntity.getContactPhone());
        return trainingCenterResponse;
    }

    @Override
    public List<TrainingCenterResponse> getAllTrainingCenters(String centerCode) {
        List<TrainingCenterEntity> trainingCenterEntities;
        if (centerCode == null) {
            trainingCenterEntities = trainingCenterRepository.findAll();
        } else {
            // Filter by centerCode
            trainingCenterEntities = trainingCenterRepository.findByCenterCode(centerCode);
        }
        List<TrainingCenterResponse> trainingCenterResponses = new ArrayList<>();
        for (TrainingCenterEntity trainingCenterEntity : trainingCenterEntities) {
            trainingCenterResponses.add(getTrainingCenterResponse(trainingCenterEntity));
        }
        return trainingCenterResponses;
    }
}
