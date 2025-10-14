package com.example.sd20204.buoi13.beanConfig;

import com.example.sd20204.buoi13.model.ButXoa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DemoBeanConfig {
    @Bean("B1")
    public ButXoa createButXoaBean() {
        return new ButXoa(1, "Thien Long");
    }

    @Bean("B2")
    public ButXoa createButXoaBean2() {
        return new ButXoa(1, "Thien Long");
    }
}
