package com.example.api_interestrates.model.dto;

import com.example.api_interestrates.entity.InterestRatesMonth;

public class InterestRatesMonthMapper {
    public static InterestRatesMonthDTO toInterestRatesMonthDTO(InterestRatesMonth interestRatesMonth){
        InterestRatesMonthDTO temp = new InterestRatesMonthDTO();
        temp.setMonths(interestRatesMonth.getMonths());
        temp.setRate(interestRatesMonth.getRate());
        return temp;
    }
}
