package poshlie_parni.service;

import poshlie_parni.dto.PersonDTO;
import poshlie_parni.dto.PersonRegisterDTO;

import java.util.List;

public interface PersonService {

    List<PersonDTO> getAllPersons();

    PersonDTO getPersonById(Long id);
    PersonDTO createPerson(PersonRegisterDTO dto);
    PersonDTO updatePerson(Long id, PersonDTO dto);

    void deletePerson(Long id);
    PersonDTO getPersonByUsername(String name);
}
