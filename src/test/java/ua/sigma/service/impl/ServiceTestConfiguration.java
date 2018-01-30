package ua.sigma.service.impl;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ua.sigma.service.MaterialRequestService;
import ua.sigma.service.MaterialRequestServiceImpl;

/**
 * Configuration class for testing the {@link MaterialRequestServiceImpl} class.
 *
 * @author Anton Taranukha
 */
@TestConfiguration
public class ServiceTestConfiguration {

    @Bean
    public MaterialRequestService materialRequestService() {
        return new MaterialRequestServiceImpl();
    }
}
