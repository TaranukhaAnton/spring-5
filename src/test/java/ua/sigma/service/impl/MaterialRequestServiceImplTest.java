package ua.sigma.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.sigma.model.MaterialRequest;
import ua.sigma.persistence.MaterialRequestRepository;
import ua.sigma.service.MaterialRequestService;
import ua.sigma.service.MaterialRequestServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test class for the {@link MaterialRequestServiceImpl} class.
 *
 * @author Anton Taranukha
 */
@RunWith(SpringRunner.class)
@ImportAutoConfiguration(ServiceTestConfiguration.class)
public class MaterialRequestServiceImplTest {

    private static final String ID1 = "id1";
    private static final String ID2 = "id2";
    private static final String NAME = "customerName";

    private MaterialRequest materialRequest1;
    private MaterialRequest materialRequest2;
    private List<MaterialRequest> materialRequests;

    @Autowired
    private MaterialRequestService service;

    @MockBean
    private MaterialRequestRepository repository;

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
        when(repository.findById(ID1)).thenReturn(Optional.of(materialRequest1));
        MaterialRequest response = service.findById(ID1).get();
        assertEquals(materialRequest1, response);
    }

    @Test
    public void shouldBeAbleToFindAllEtities() {
        when(repository.findAll()).thenReturn(materialRequests);
        List<MaterialRequest> response = service.getAll();
        assertEquals(materialRequests, response);
    }

    @Test
    public void shouldSaveCorrectly() {
        service.save(materialRequest1);
        verify(repository, times(1)).save(materialRequest1);
    }

    @Test
    public void shouldDeleteCorrectly() {
        when(repository.findById(ID1)).thenReturn(Optional.of(materialRequest1));
        service.delete(ID1);
        verify(repository, times(1)).findById(ID1);
        verify(repository, times(1)).delete(materialRequest1);
    }
}
