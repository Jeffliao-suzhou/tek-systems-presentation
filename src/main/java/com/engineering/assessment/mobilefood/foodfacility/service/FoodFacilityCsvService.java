package com.engineering.assessment.mobilefood.foodfacility.service;

import com.engineering.assessment.mobilefood.foodfacility.dto.FoodFacilityDTO;

import java.util.List;

public interface FoodFacilityCsvService {
    List<FoodFacilityDTO> readFoodFacilityCsv();

    List<FoodFacilityDTO> getApprovedAndLowestPoliceDistrictsFoodFacility();
}
