
package com.example.findadoctor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Doctor {
    private String name;
    private String hospitalName;
    private String specialty;
    private String network;
    private String location;
}
