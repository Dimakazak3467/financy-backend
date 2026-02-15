package poshlie_parni.util;

import lombok.experimental.UtilityClass;
import poshlie_parni.dto.PersonDTO;
import poshlie_parni.entity.Person;

@UtilityClass
public class PersonMapper {
    public PersonDTO convertToDto(Person person) {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setUsername(person.getUsername());

        return personDTO;
    }

}
