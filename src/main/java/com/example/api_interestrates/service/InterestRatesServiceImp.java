package com.example.api_interestrates.service;

import com.example.api_interestrates.entity.InterestRatesMonth;
import com.example.api_interestrates.model.dto.InterestRatesMonthDTO;
import com.example.api_interestrates.model.dto.InterestRatesMonthMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InterestRatesServiceImp implements InterestRatesService{
    private static final List<InterestRatesMonth> interest_rates = new ArrayList<>();
    static {
        interest_rates.add(new InterestRatesMonth(1, 3));
        interest_rates.add(new InterestRatesMonth(2, 3));
        interest_rates.add(new InterestRatesMonth(3, 3.3f));
        interest_rates.add(new InterestRatesMonth(6, 4));
        interest_rates.add(new InterestRatesMonth(9, 4));
        interest_rates.add(new InterestRatesMonth(12, 7.4f));
        interest_rates.add(new InterestRatesMonth(24, 5.3f));
        interest_rates.add(new InterestRatesMonth(36, 5.3f));
        interest_rates.add(new InterestRatesMonth(48, 5.3f));
        interest_rates.add(new InterestRatesMonth(60, 5.3f));
    }

    @Override
    public List<InterestRatesMonthDTO> getAll() {
        List<InterestRatesMonthDTO> result = new ArrayList<>();
        for (InterestRatesMonth interest_rate : interest_rates){
            result.add(InterestRatesMonthMapper.toInterestRatesMonthDTO(interest_rate));
        }
        return result;
    }

    @Override
    public InterestRatesMonthDTO getInterestRatesMonths(int months) {
        for (InterestRatesMonth interest_rate : interest_rates){
            if (interest_rate.getMonths() == months)
                return InterestRatesMonthMapper.toInterestRatesMonthDTO(interest_rate);
        }
        return null;
    }
}
