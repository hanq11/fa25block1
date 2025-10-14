package com.example.sd20203.buoi13.configBean;

import com.example.sd20203.buoi13.model.CapSach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DemoConfigBean {
    @Bean("B1")
    public CapSach createCapSachBean() {
        return new CapSach(1, "Ladoda");
    }

    @Bean("B2")
    public CapSach createCapSachBean2() {
        return new CapSach(2, "Ladoda");
    }
}
