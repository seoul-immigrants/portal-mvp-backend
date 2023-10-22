package com.portal.mvp.dto.sample.response;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleResponse {

    private Long sampleId;
    private String name;
    private int age;

}
