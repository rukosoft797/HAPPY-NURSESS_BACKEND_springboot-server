package com.rukosoft.healthcare.bff.rest;

import com.rukosoft.healthcare.bff.model.Nurse;
import com.rukosoft.healthcare.bff.repository.NurseRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Data
@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/nurses")
public class NurseController {
    private final NurseRepository nurseRepository;

    @GetMapping
    public List<Nurse> findAll(){
        return nurseRepository.findAll ();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nurse> findById( @PathVariable Long id ){
        Optional<Nurse> optionalNurse =  nurseRepository.findById (id);
        if(!optionalNurse.isPresent ()){
            return ResponseEntity.unprocessableEntity ().build ();
        }
        return ResponseEntity.ok (optionalNurse.get ());
    }

    @PostMapping
    public ResponseEntity<Nurse> create(@RequestBody Nurse nurse) {
//        Optional<Library> optionalLibrary = libraryRepository.findById(book.getLibrary().getId());
//        if (!optionalLibrary.isPresent()) {
//            return ResponseEntity.unprocessableEntity().build();
//        }
//
//        book.setLibrary(optionalLibrary.get());

        Nurse savedNurse = nurseRepository.save(nurse);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedNurse.getNurseId()).toUri();
        System.out.println (location);
        return ResponseEntity.created(location).body(savedNurse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Nurse> updateNurse(@RequestBody Nurse nurse, @PathVariable Long id){
        Optional<Nurse> optionalNurse = nurseRepository.findById (id);
        if(!optionalNurse.isPresent ()){
            return ResponseEntity.unprocessableEntity ().build ();
        }
        nurse.setNurseId (optionalNurse.get ().getNurseId ());
        nurseRepository.save (nurse);
        return ResponseEntity.noContent ().build ();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Nurse> deleteNurse( @PathVariable Long id){
        Optional<Nurse> optionalNurse = nurseRepository.findById (id);
        if(!optionalNurse.isPresent ()){
            return ResponseEntity.unprocessableEntity ().build ();
        }
        nurseRepository.delete (optionalNurse.get ());
        return ResponseEntity.noContent ().build ();
    }

}
