package com.selldok.toy.salary.controller;

import com.selldok.toy.salary.model.SalaryRequest;
import com.selldok.toy.salary.model.SalaryResponse;
import com.selldok.toy.salary.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;


    @GetMapping("/salary")
    public ResponseEntity<SalaryResponse> tmp(SalaryRequest salaryRequest){

        //TODO : salaryService를 통해서 연봉리스트 받아오기
        SalaryResponse salaryResponse = salaryService.searchSalary(salaryRequest);
        return new ResponseEntity(salaryResponse, HttpStatus.OK);
    }

}
