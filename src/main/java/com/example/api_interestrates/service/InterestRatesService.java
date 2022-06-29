package com.example.api_interestrates.service;

import com.example.api_interestrates.entity.InterestRatesMonth;
import com.example.api_interestrates.model.dto.InterestRatesMonthDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InterestRatesService {
    public List<InterestRatesMonthDTO> getAll();
    public InterestRatesMonthDTO getInterestRatesMonths(int months);
}
