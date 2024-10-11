package com.engineering.assessment.mobilefood.foodfacility.service.impl;

import com.engineering.assessment.mobilefood.foodfacility.dto.FoodFacilityDTO;
import com.engineering.assessment.mobilefood.foodfacility.service.FoodFacilityCsvService;
import com.engineering.assessment.mobilefood.infrastructure.util.CsvUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FoodFacilityCsvServiceImpl implements FoodFacilityCsvService {

    @Autowired
    private CsvUtils csvUtils;

    private List<FoodFacilityDTO> fullRecordsCache;

    @Override
    public List<FoodFacilityDTO> readFoodFacilityCsv() {
        if (fullRecordsCache == null) {
            fullRecordsCache = csvUtils.readCsv();
        }
        return fullRecordsCache;
    }

    private List<FoodFacilityDTO> filterRecords(Predicate<FoodFacilityDTO> predicate) {
        List<FoodFacilityDTO> fullRecords = readFoodFacilityCsv();
        if (fullRecords.isEmpty()) {
            return Collections.emptyList();
        }
        return fullRecords.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodFacilityDTO> getApprovedAndLowestPoliceDistrictsFoodFacility() {
        return filterRecords(foodFacilityDTO -> foodFacilityDTO.getStatus() != null
                && "APPROVED".equalsIgnoreCase(foodFacilityDTO.getStatus())
                && foodFacilityDTO.getPoliceDistricts() != null
                && "1".equals(foodFacilityDTO.getPoliceDistricts()));
    }

    @Override
    public List<FoodFacilityDTO> getApprovedAndSpecialZipCodesFoodFacility(String zipCodes) {
        return filterRecords(foodFacilityDTO -> foodFacilityDTO.getStatus() != null
                && "APPROVED".equalsIgnoreCase(foodFacilityDTO.getStatus())
                && foodFacilityDTO.getZipCodes() != null
                && zipCodes.equals(foodFacilityDTO.getZipCodes()));
    }
}