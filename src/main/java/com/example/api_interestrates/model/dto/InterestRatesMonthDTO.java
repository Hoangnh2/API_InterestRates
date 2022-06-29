package com.example.api_interestrates.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterestRatesMonthDTO {
    private int Months;
    private float Rate;
}
