package com.buyogo.project.repository;

import com.buyogo.project.entity.TrainingCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenterEntity, Long> {
    /**
     * Query to filter the training centers by Id
     * @param centerCode
     * @return
     */
    @Query("SELECT t FROM TrainingCenterEntity t WHERE t.centerCode LIKE %?1%")
    List<TrainingCenterEntity> findByCenterCode(String centerCode);
}
