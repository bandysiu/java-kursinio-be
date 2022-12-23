package com.parcel.controller;

import com.parcel.model.api.request.CreateTestRequest;
import com.parcel.model.api.response.TestResponse;
import com.parcel.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/test")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new test in database")
    public Long createTest(@Validated @RequestBody CreateTestRequest request){
        return testService.createTest(request).getId();
    }

    @GetMapping(value = "/tests")
    @Operation(summary = "Get tests from database")
    public List<TestResponse> fetchVehicles() {
        return testService.fetchTests().stream()
                .map(p -> new TestResponse(p.getId(), p.getText(), p.getNumber()))
                .collect(Collectors.toList());
    }
}
