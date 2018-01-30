package ua.sigma.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.sigma.model.MaterialRequest;
import ua.sigma.persistence.MaterialRequestRepository;

import java.util.stream.IntStream;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Component
public class DataSetupBean implements InitializingBean {

    @Autowired
    private MaterialRequestRepository repo;

    @Override
    public void afterPropertiesSet() {
        IntStream.range(1, 20).forEach(i -> repo.save(new MaterialRequest(i + "", randomAlphabetic(8))));
    }


}
