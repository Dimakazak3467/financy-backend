package poshlie_parni.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import poshlie_parni.dto.PersonDTO;
import poshlie_parni.dto.PersonRegisterDTO;
import poshlie_parni.entity.Person;
import poshlie_parni.exeption.PersonAlreadyExistsExeption;
import poshlie_parni.exeption.PersonNotFoundExeption;
import poshlie_parni.repository.PersonRepository;
import poshlie_parni.service.PersonService;
import poshlie_parni.util.PersonMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream()
                .map(PersonMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        return personRepository.findById(id)
                .map(PersonMapper::convertToDto)
                .orElseThrow(() -> new PersonNotFoundExeption("Person not found!"));
    }

    @Override
    public PersonDTO createPerson(PersonRegisterDTO dto) {

        if (personRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new PersonAlreadyExistsExeption("Person already exists!");
        }


        Person person = new Person();
        person.setName(dto.getName());
        person.setUsername(dto.getUsername());
        person.setPassword(passwordEncoder.encode(dto.getPassword()));

        return PersonMapper.convertToDto(personRepository.save(person));
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonDTO dto) {

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundExeption("Person not found!"));


        if (personRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new PersonAlreadyExistsExeption("Username already exists");
        }

        person.setName(dto.getName());
        person.setUsername(dto.getUsername());

        return PersonMapper.convertToDto(personRepository.save(person));
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonDTO getPersonByUsername(String username) {

        Optional<Person> optionalPerson = personRepository.findByUsername(username);

        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundExeption("Person with username " + username + " not found");
        }

        return PersonMapper.convertToDto(optionalPerson.get());
    }
}
