package com.portal.mvp.service.sample;

import com.portal.mvp.common.apiException.exception.BusinessException;
import com.portal.mvp.domain.sample.Sample;
import com.portal.mvp.dto.sample.request.SampleRequest;
import com.portal.mvp.dto.sample.response.SampleResponse;
import com.portal.mvp.repository.sample.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.portal.mvp.common.apiException.errorcode.ErrorCode.NOT_FOUND_SAMPLE;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;

    @Transactional
    public SampleResponse addSample(SampleRequest sampleRequest){
        Sample sample = dtoToEntity(sampleRequest);
        sampleRepository.save(sample);

        return entityToDto(sample);
    };

    @Transactional(readOnly = true)
    public SampleResponse selectSample(Long sampleId){
        Sample findSample = sampleRepository.findById(sampleId)
                .orElseThrow(() -> new BusinessException(NOT_FOUND_SAMPLE));
        return entityToDto(findSample);
    }

    /**
     * DTO(리퀘스트) -> domain으로 변환
     * @param sampleRequest
     * @return
     */
    Sample dtoToEntity(SampleRequest sampleRequest){
        return Sample.builder()
                .name(sampleRequest.getName())
                .age(sampleRequest.getAge())
                .build();
    }

    /**
     * domain -> DTO로 변환
     * @param sample
     * @return
     */
    private SampleResponse entityToDto(Sample sample){
        return SampleResponse.builder()
                .sampleId(sample.getSampleId())
                .name(sample.getName())
                .age(sample.getAge())
                .build();
    }
}
