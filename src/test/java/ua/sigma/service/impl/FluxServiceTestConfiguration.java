package ua.sigma.service.impl;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ua.sigma.service.MaterialRequestFluxService;
import ua.sigma.service.MaterialRequestFluxServiceImpl;

/**
 * Configuration class for testing the {@link MaterialRequestFluxServiceImpl} class.
 *
 * @author Anton Taranukha
 */
@TestConfiguration
public class FluxServiceTestConfiguration {

    @Bean
    public MaterialRequestFluxService materialRequestFluxService() {
        return new MaterialRequestFluxServiceImpl();
    }
}
