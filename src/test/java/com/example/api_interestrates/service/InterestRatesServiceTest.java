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
        Assertions.assertEquals(3, interestRatesService.getInterestRatesMonths(1).getRate());
        Assertions.assertEquals(5.5f, interestRatesService.getInterestRatesMonths(12).getRate());
        Assertions.assertEquals(true, interestRatesService.getInterestRatesMonths(2).getRate() < interestRatesService.getInterestRatesMonths(6).getRate());
    }

    @Test
    public void test_getAll() {
        InterestRatesService interestRatesService = context.getBean(InterestRatesService.class);
        List<InterestRatesMonthDTO> result = interestRatesService.getAll();
        Assertions.assertEquals(3, result.get(0).getRate());
        Assertions.assertEquals(3, result.get(1).getRate());
        Assertions.assertEquals(4, result.get(3).getRate());
    }
}
