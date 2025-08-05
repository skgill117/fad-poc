
package com.example.findadoctor.dto;

import lombok.Data;

@Data
public class DoctorSearchRequest {
    private String doctorHospitalSpecialty;
    private String network;
    private String location;
}
