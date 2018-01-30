package ua.sigma.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.sigma.persistence.MaterialRequestFluxRepository;
import ua.sigma.model.MaterialRequest;
import ua.sigma.service.MaterialRequestFluxService;
import ua.sigma.service.MaterialRequestFluxServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for the {@link MaterialRequestFluxServiceImpl}.
 *
 * @author Anton Taranukha
 */
@RunWith(SpringRunner.class)
@ImportAutoConfiguration(FluxServiceTestConfiguration.class)
public class MaterialRequestFluxServiceImplTest {

    private static final String ID1 = "id1";
    private static final String ID2 = "id2";
    private static final String NAME = "customerName";
    private MaterialRequest materialRequest1, materialRequest2;
    private List<MaterialRequest> materialRequests;


    @Autowired
    private MaterialRequestFluxService service;

    @MockBean
    private MaterialRequestFluxRepository repository;

    @Before
    public void init() {
        materialRequest1 = new MaterialRequest(ID1, NAME);
        materialRequest2 = new MaterialRequest(ID2, NAME);

        materialRequests = new ArrayList<>();
        materialRequests.add(materialRequest1);
        materialRequests.add(materialRequest2);
    }

    @Test
    public void shouldFindEntityAndReturnItInResponse() {
        when(repository.findById(ID1)).thenReturn(Mono.just(materialRequest1));
        MaterialRequest response = service.findById(ID1).block();
        assertEquals(materialRequest1, response);
    }

    @Test
    public void shouldBeAbleToFindAllEtities() {
        when(repository.findAll()).thenReturn(Flux.fromIterable(materialRequests));
        List<MaterialRequest> response = service.getAll().collectList().block();
        assertEquals(materialRequests, response);
    }

    @Test
    public void shouldSaveCorrectly() {
        service.save(materialRequest1);
        verify(repository, times(1)).save(materialRequest1);
    }

    @Test
    public void shouldDeleteCorrectly() {
        when(repository.findById(ID1)).thenReturn(Mono.just(materialRequest1));
        service.delete(ID1);
        verify(repository, times(1)).findById(ID1);
        verify(repository, times(1)).delete(materialRequest1);
    }
}
