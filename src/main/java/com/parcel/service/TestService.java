package com.parcel.service;

import com.parcel.model.api.request.CreateTestRequest;
import com.parcel.model.domain.DtoTest;
import com.parcel.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public List<DtoTest> fetchTests(){
        return testRepository.findAll();
    }

    public DtoTest createTest(CreateTestRequest request){
        DtoTest test = DtoTest.builder()
                .text(request.getText())
                .number(request.getNumber())
                .build();

        return testRepository.save(test);
    }
}
