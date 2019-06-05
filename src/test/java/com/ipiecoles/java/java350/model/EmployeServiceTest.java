package com.ipiecoles.java.java350.model;

import com.ipiecoles.java.java350.repository.EmployeRepository;
import com.ipiecoles.java.java350.service.EmployeService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class EmployeServiceTest {

    @InjectMocks
    public EmployeService employeService;

    @Mock
    public EmployeRepository employeRepository;

    public void testCalculPerformanceCommercial(){

    }
}
