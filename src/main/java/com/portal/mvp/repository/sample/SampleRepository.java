package com.portal.mvp.repository.sample;

import com.portal.mvp.domain.sample.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long> {
}
