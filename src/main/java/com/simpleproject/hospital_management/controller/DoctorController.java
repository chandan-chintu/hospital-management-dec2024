package com.simpleproject.hospital_management.controller;

import com.simpleproject.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    // here we are using hashmap to perform database operations
    HashMap<Integer, Doctor> doctorDb = new HashMap<>();

    // 1->{1,ajay,ajay@gmail.com,9287373894,cardiologist}
    // 2->{2,vijay,vijay@gmail.com,9287333894,cardiologist}
    // 3->{3,sanjay,sanjay@gmail.com,9333333894,cardiologist}

    // @RequestBody - takes the input or request from postman and assigns it to doctor object, it should be used for class objects

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor inputDoctorRequest){
        // take the input request coming and add it inside hashmap
        doctorDb.put(inputDoctorRequest.getId(), inputDoctorRequest);
        return "Doctor saved successfully";
    }

    @GetMapping("/findAll")
    public HashMap<Integer, Doctor> findAllDoctors(){
        return doctorDb;
    }

    // @PathVariable - input is sent in  url path or endpoint
    @GetMapping("/find/{id}")
    public Doctor findDoctorByd(@PathVariable int id){
        Doctor doctor = doctorDb.get(id);
        return doctor;
    }

}
