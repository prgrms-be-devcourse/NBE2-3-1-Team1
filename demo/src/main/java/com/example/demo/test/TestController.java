package com.example.demo.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tests")
@Tag(name = "Test API", description = "Test API description")
public class TestController {

    private final TestService testService;

    @Operation(summary = "Test API", description = "Test GET API ")
    @GetMapping
    public ResponseEntity<Long> testController() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(testService.testService().getId());
    }

}
