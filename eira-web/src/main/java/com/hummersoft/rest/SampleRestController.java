package com.hummersoft.rest;

import com.hummersoft.service.SampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SampleRestController {

    private SampleService sampleService;

    public SampleRestController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("sample")
    public ResponseEntity<String> helloEira(){
        System.out.println("Inside helloEira in SampleRestController");
        return new ResponseEntity<>("Hello Eira", HttpStatus.OK);
    }
}
