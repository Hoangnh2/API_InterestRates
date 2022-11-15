package com.example.api_interestrates.service;

import com.example.api_interestrates.model.dto.InterestRatesMonthDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
public class InterestRatesServiceTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void test_getInterestRatesMonths() {
        InterestRatesService interestRatesService = context.getBean(InterestRatesService.class);
        Assertions.assertEquals(true, interestRatesService.getInterestRatesMonths(2).getRate() < interestRatesService.getInterestRatesMonths(6).getRate());
        Assertions.assertEquals(true, interestRatesService.getInterestRatesMonths(12).getRate() == interestRatesService.getInterestRatesMonths(24).getRate());
        Assertions.assertEquals(true, interestRatesService.getInterestRatesMonths(6).getRate() == interestRatesService.getInterestRatesMonths(9).getRate());
    }

    @Test
    public void test_getAll() {
        InterestRatesService interestRatesService = context.getBean(InterestRatesService.class);
        List<InterestRatesMonthDTO> result = interestRatesService.getAll();
        Assertions.assertEquals(true, result.get(1).getRate() < result.get(3).getRate());
        Assertions.assertEquals(true, result.get(3).getRate() == result.get(4).getRate());
        Assertions.assertEquals(true, result.get(5).getRate() == result.get(6).getRate());
    }
}
