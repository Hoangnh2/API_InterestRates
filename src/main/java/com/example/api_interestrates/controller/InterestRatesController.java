package com.example.api_interestrates.controller;

import com.example.api_interestrates.entity.InterestRatesMonth;
import com.example.api_interestrates.model.dto.InterestRatesMonthDTO;
import com.example.api_interestrates.service.InterestRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API/getInterestRates")
public class InterestRatesController {

    @Autowired
    private InterestRatesService interestRatesService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<InterestRatesMonthDTO> interest_rates = interestRatesService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(interest_rates);
    }
    @GetMapping("/{months}")
    public ResponseEntity<?> getInterestRatesMonths(@PathVariable(value = "months") int months) {
        InterestRatesMonthDTO result = interestRatesService.getInterestRatesMonths(months);
        if (result == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có lãi suất tương ứng. API v1.0");
        else
            return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

