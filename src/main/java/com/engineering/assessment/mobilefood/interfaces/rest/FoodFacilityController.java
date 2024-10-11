package com.engineering.assessment.mobilefood.interfaces.rest;

import com.engineering.assessment.mobilefood.foodfacility.dto.FoodFacilityDTO;
import com.engineering.assessment.mobilefood.foodfacility.service.FoodFacilityCsvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/foodfacility")
public class FoodFacilityController {

    @Autowired
    private FoodFacilityCsvService foodFacilityCsvService;

    @GetMapping("/read-csv")
    public List<FoodFacilityDTO> readCsv() {
        return foodFacilityCsvService.readFoodFacilityCsv();
    }

    @GetMapping("/approved-lowest-police-districts-food-facility")
    public List<FoodFacilityDTO> getApprovedAndLowestPoliceDistrictsFoodFacility() {
        return foodFacilityCsvService.getApprovedAndLowestPoliceDistrictsFoodFacility();
    }

    @GetMapping("/approved-specific-zipcodes-food-facility")
    public List<FoodFacilityDTO> getApprovedAndSpecificZipcodesFoodFacility(@RequestParam String zipcodes) {
        return foodFacilityCsvService.getApprovedAndSpecialZipCodesFoodFacility(zipcodes);
    }

}
