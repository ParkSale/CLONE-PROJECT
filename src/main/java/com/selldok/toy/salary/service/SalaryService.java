package com.selldok.toy.salary.service;

import com.selldok.toy.salary.dao.SalaryRepository;
import com.selldok.toy.salary.entity.Salary;
import com.selldok.toy.salary.model.SalaryRequest;
import com.selldok.toy.salary.model.SalaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SalaryService {

    private final SalaryRepository salaryRepository;

    public SalaryResponse searchSalary(SalaryRequest salaryRequest){

        Salary salary = salaryRepository.findByOccupation(salaryRequest.getOccupation());
        SalaryResponse salaryResponse = new SalaryResponse(salary.getSalaryInfo().getFirstSalary()
                ,salary.getSalaryInfo().getSecondSalary(),salary.getSalaryInfo().getThirdSalary()
                ,salary.getSalaryInfo().getFourthSalary(),salary.getSalaryInfo().getFifthSalary()
                ,salary.getSalaryInfo().getSixthSalary(),salary.getSalaryInfo().getSeventhSalary()
                ,salary.getSalaryInfo().getEighthSalary(),salary.getSalaryInfo().getNinthSalary()
                ,salary.getSalaryInfo().getTenthSalary());
        return salaryResponse;
    }
}
