package com.portal.mvp.service.sample;

import com.portal.mvp.common.apiException.exception.BusinessException;
import com.portal.mvp.domain.sample.Sample;
import com.portal.mvp.dto.sample.request.SampleRequest;
import com.portal.mvp.repository.sample.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.portal.mvp.common.apiException.errorcode.ErrorCode.NOT_FOUND_SAMPLE;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Slf4j
class SampleServiceTest {

    @Autowired
    private SampleService sampleService;
    @Autowired
    private SampleRepository sampleRepository;


    @Test
    void addSample(){
        //given
        SampleRequest sampleRequest = new SampleRequest();
        sampleRequest.setName("JUNG");
        sampleRequest.setAge(20);

        //when
        Sample saveSample = sampleRepository.save(sampleService.dtoToEntity(sampleRequest));

        //then
        assertThat(saveSample.getName()).isEqualTo(sampleRequest.getName());
        assertThat(saveSample.getAge()).isNotEqualTo(33);
    }

    @Test
    void selectSample(){
        //given
        Long sampleId = 1L;

        //when
        Sample findSample = sampleRepository.findById(sampleId)
                .orElseThrow(() -> new BusinessException(NOT_FOUND_SAMPLE));

        //then
        assertThat(findSample.getName()).isEqualTo("JUG");
    }

}