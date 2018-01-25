package com.study.web;

import com.study.model.MaterialRequest;
import com.study.persistence.MaterialRequestRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Component
public class DataSetupBean implements InitializingBean {

    @Autowired
    private MaterialRequestRepository repo;

    //

    @Override
    public void afterPropertiesSet() throws Exception {
      //  System.out.println("DataSetupBean.afterPropertiesSet");

        IntStream.range(1, 20).forEach(i -> repo.save(new MaterialRequest(i + "", randomAlphabetic(8))));


        //List<MaterialRequest> all = repo.findAll();
        //System.out.println("all = " + all);

    }


}
