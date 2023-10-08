package com.portal.mvp.controller.sample;

import com.portal.mvp.dto.sample.request.SampleRequest;
import com.portal.mvp.dto.sample.response.SampleResponse;
import com.portal.mvp.service.sample.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @PostMapping("")
    public ResponseEntity<SampleResponse> sampleAdd(SampleRequest sampleRequest){
        SampleResponse sampleResponse = sampleService.addSample(sampleRequest);
        return ResponseEntity.ok(sampleResponse);
    }

    @GetMapping("/{sampleId}")
    public ResponseEntity<SampleResponse> sampleSelect(@PathVariable Long sampleId){
        SampleResponse sampleResponse = sampleService.selectSample(sampleId);
        return ResponseEntity.ok(sampleResponse);
    }
}
