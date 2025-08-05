
package com.example.findadoctor.controller;

import com.example.findadoctor.dto.DoctorSearchRequest;
import com.example.findadoctor.model.Doctor;
import com.example.findadoctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/find-a-doctor")
@RequiredArgsConstructor
public class DoctorSearchController {

    private final DoctorService doctorService;

    @GetMapping
    public List<Doctor> findDoctor(
            @RequestParam(required = false) String doctorHospitalSpecialty,
            @RequestParam(required = false) String network,
            @RequestParam(required = false) String location
    ) {
        DoctorSearchRequest request = new DoctorSearchRequest();
        request.setDoctorHospitalSpecialty(doctorHospitalSpecialty);
        request.setNetwork(network);
        request.setLocation(location);

        return doctorService.searchDoctors(request);
    }
}
