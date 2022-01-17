package com.crud.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.crud.app.model.Patient;
import com.crud.app.repository.PatientRepository;
import com.crud.app.services.PatientService;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class PatientTest { @Autowired
private PatientService service; @MockBean
private PatientRepository repository;
@Test
public void listAllTest() {
when(repository.findAll()).thenReturn((List<Patient>) Stream.of(new Patient(1,"saan","9876543210","san8@gmail.com","jklm","O+","Female",34,"Kolkata"),
new Patient(1,"Elena","9878903210","elena8@gmail.com","67hj","A+","Female",38,"Karnatak")).collect(Collectors.toList()));
assertEquals(2,service.listAll().size());
}
@Test
public void saveTest() {
Patient p1=new Patient(3,"Damon","7897903210","damon@gmail.com","89js","AB+","Male",40,"Jammu");
service.save(p1);
verify(repository,times(1)).save(p1);
}
@Test
public void updateTest() {
Patient p1=new Patient(3,"Damon","7897903210","damon@gmail.com","89js","AB+","Male",40,"Jammu");
service.save(p1);
verify(repository,times(1)).save(p1);
}
@Test
public void deleteTest() {
int id=2;
service.delete(id);
verify(repository,times(1)).deleteById(id);
}
}

