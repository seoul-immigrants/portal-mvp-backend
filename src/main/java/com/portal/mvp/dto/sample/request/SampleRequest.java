package com.portal.mvp.dto.sample.request;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequest {

    private String name;
    private int age;

}
