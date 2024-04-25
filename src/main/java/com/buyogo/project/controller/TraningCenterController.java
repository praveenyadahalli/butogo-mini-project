package com.buyogo.project.controller;

import com.buyogo.project.representation.request.TrainingCenterRequest;
import com.buyogo.project.representation.response.TrainingCenterResponse;
import com.buyogo.project.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/centers")
@RestController
@Validated
public class TraningCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping()
    public ResponseEntity<TrainingCenterResponse> addNewTrainingCenter(@RequestBody TrainingCenterRequest trainingCenterRequest) {
        TrainingCenterResponse trainingCenterResponse = trainingCenterService.addNewTrainingCenter(trainingCenterRequest);
        return new ResponseEntity<>(trainingCenterResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenterResponse>> getAllTrainingCenters(@RequestParam(required = false) String centerCode) {
        List<TrainingCenterResponse> trainingCenterResponses = trainingCenterService.getAllTrainingCenters(centerCode);
        return new ResponseEntity<List<TrainingCenterResponse>>(trainingCenterResponses, HttpStatus.OK);
    }
}
