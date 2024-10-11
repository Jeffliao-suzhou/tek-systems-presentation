package com.engineering.assessment.mobilefood.foodfacility.service.impl;

import com.engineering.assessment.mobilefood.foodfacility.dto.FoodFacilityDTO;
import com.engineering.assessment.mobilefood.foodfacility.service.FoodFacilityCsvService;
import com.engineering.assessment.mobilefood.infrastructure.util.CsvUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FoodFacilityCsvServiceImpl implements FoodFacilityCsvService {

    @Autowired
    private CsvUtils csvUtils;

    @Override
    public List<FoodFacilityDTO> readFoodFacilityCsv() {
        return csvUtils.readCsv();
    }

    @Override
    public List<FoodFacilityDTO> getApprovedAndLowestPoliceDistrictsFoodFacility() {
        List<FoodFacilityDTO> fullRecords = readFoodFacilityCsv();
        List<FoodFacilityDTO> filterRecords = new ArrayList<>();
        if(fullRecords.isEmpty()){
            return Collections.emptyList();
        }
        try {
            for (FoodFacilityDTO foodFacilityDTO : fullRecords) {
                if(foodFacilityDTO.getStatus() != null
                        && foodFacilityDTO.getPoliceDistricts() != null
                        && "APPROVED".equalsIgnoreCase(foodFacilityDTO.getStatus())
                        && "1".equals(foodFacilityDTO.getPoliceDistricts())){
                    filterRecords.add(foodFacilityDTO);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error occurs while retrieve approved and lowest police distrcts food facility", ex);
        }

        return filterRecords;
    }
}