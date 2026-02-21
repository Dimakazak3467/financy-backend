package poshlie_parni.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import poshlie_parni.dto.BankRequestDTO;
import poshlie_parni.dto.BankResponseDTO;
import poshlie_parni.dto.PersonDTO;
import poshlie_parni.dto.PersonRegisterDTO;
import poshlie_parni.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonRegisterDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(dto));
    }

    @GetMapping("/login")
    public ResponseEntity<PersonDTO> login(Authentication authentication) {
        return ResponseEntity.ok(personService.getPersonByUsername(authentication.getName()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO dto) {
        return ResponseEntity.ok(personService.updatePerson(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<String> getByUsername(@PathVariable String username) {
        PersonDTO personDTO = personService.getPersonByUsername(username);
        return ResponseEntity.ok("User " + personDTO.getUsername() + " is registered");
    }


    @PostMapping("/{personId}/banks")
    public ResponseEntity<Void> addBank(@PathVariable Long personId, @RequestBody BankRequestDTO bankRequestDTO) {
        personService.addBank(personId,bankRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/{personId}/banks")
    public ResponseEntity<List<BankResponseDTO>> getMyBanks(@PathVariable Long personId) {
        List<BankResponseDTO> banks = personService.getMyBanks(personId);
        return ResponseEntity.ok(banks);
    }

    @DeleteMapping("/{personId}/banks/{bankId}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long personId, @PathVariable Long bankId) {
        personService.deleteBank(bankId, personId);
        return ResponseEntity.noContent().build();
    }
}
