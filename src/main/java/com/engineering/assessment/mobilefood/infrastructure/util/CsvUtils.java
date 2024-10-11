package com.engineering.assessment.mobilefood.infrastructure.util;

import com.engineering.assessment.mobilefood.foodfacility.dto.FoodFacilityDTO;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CsvUtils {

    @Value("${csv.file.name}")
    private String csvFileName;

    public List<FoodFacilityDTO> readCsv() {
        String csvFilePath = "data/csv/" + csvFileName;
        List<FoodFacilityDTO> foodFacilityDTOS = new ArrayList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String[] headers = csvReader.readNext();
            if (headers != null && headers.length > 0) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    FoodFacilityDTO foodFacilityDTO = new FoodFacilityDTO();
                    foodFacilityDTO.setLocationId(line[0]);
                    foodFacilityDTO.setApplicant(line[1]);
                    foodFacilityDTO.setFacilityType(line[2]);
                    foodFacilityDTO.setCnn(line[3]);
                    foodFacilityDTO.setLocationDescription(line[4]);
                    foodFacilityDTO.setAddress(line[5]);
                    foodFacilityDTO.setBlocklot(line[6]);
                    foodFacilityDTO.setBlock(line[7]);
                    foodFacilityDTO.setLot(line[8]);
                    foodFacilityDTO.setPermit(line[9]);
                    foodFacilityDTO.setStatus(line[10]);
                    foodFacilityDTO.setFoodItems(line[11]);
                    foodFacilityDTO.setX(line[12]);
                    foodFacilityDTO.setY(line[13]);
                    foodFacilityDTO.setLatitude(Double.valueOf(line[14]));
                    foodFacilityDTO.setLongitude(Double.valueOf(line[15]));
                    foodFacilityDTO.setSchedule(line[16]);
                    foodFacilityDTO.setDaysHours(line[17]);
                    foodFacilityDTO.setNoiSent(line[18]);
                    foodFacilityDTO.setApprovedTime(line[19]);
                    foodFacilityDTO.setReceived(line[20]);
                    foodFacilityDTO.setPriorPermit(Boolean.getBoolean(line[21]));
                    foodFacilityDTO.setExpirationDate(line[22]);
                    foodFacilityDTO.setLocation(line[23]);
                    foodFacilityDTO.setFirePreventionDistricts(line[24]);
                    foodFacilityDTO.setPoliceDistricts(line[25]);
                    foodFacilityDTO.setSupervisorDistricts(line[26]);
                    foodFacilityDTO.setZipCodes(line[27]);
                    foodFacilityDTO.setNeighborhoodsOld(line[28]);
                    foodFacilityDTOS.add(foodFacilityDTO);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file", e);
        } catch (Exception ex) {
            throw new RuntimeException("Error occurs while handling CSV process", ex);
        }
        return foodFacilityDTOS;
    }

}
