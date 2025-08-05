
package com.example.findadoctor.service;

import com.example.findadoctor.dto.DoctorSearchRequest;
import com.example.findadoctor.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final List<Doctor> doctors = List.of(
        new Doctor("Dr. John Smith", "General Hospital", "Dermatologist", "PPO", "02116"),
        new Doctor("Dr. Jane Doe", "City Care Center", "ENT Specialist", "PPO", "02116"),
        new Doctor("Dr. Emily White", "Boston Kids Hospital", "Pediatrician", "PPO", "02116"),
        new Doctor("Dr. Michael Brown", "Mind Wellness Clinic", "Psychiatrist", "PPO", "02116"),
        new Doctor("Dr. Linda Johnson", "Hope Cancer Center", "Oncologist", "PPO", "02116"),
        new Doctor("Dr. Robert Green", "Heart Institute", "Cardiologist", "PPO", "02116"),
        new Doctor("Dr. Susan Black", "Neuro Health", "Neurologist", "PPO", "02116"),
        new Doctor("Dr. Kevin Lee", "Ortho Plus", "Orthopedic", "PPO", "02116"),
        new Doctor("Dr. Sarah Walker", "Heart Institute", "Cardiologist", "PPO", "02116"),
        new Doctor("Dr. Daniel King", "Women's Care", "Gynecologist", "PPO", "02116"),
        new Doctor("Dr. Laura Scott", "Skin Health Clinic", "Dermatologist", "PPO", "02116"),
        new Doctor("Dr. James Hall", "Mind Wellness Clinic", "Psychiatrist", "PPO", "02116"),
        new Doctor("Dr. Amy Adams", "City Care Center", "ENT Specialist", "PPO", "02116"),
        new Doctor("Dr. Brian Moore", "Wellbeing Center", "General Physician", "PPO", "02116"),
        new Doctor("Dr. Angela Davis", "Neuro Health", "Neurologist", "PPO", "02116"),
        new Doctor("Dr. Steven Clark", "Hope Cancer Center", "Oncologist", "PPO", "02116"),
        new Doctor("Dr. Carol Allen", "Boston Kids Hospital", "Pediatrician", "PPO", "02116"),
        new Doctor("Dr. George Lewis", "Heart Institute", "Cardiologist", "PPO", "02116"),
        new Doctor("Dr. Nancy Young", "Wellbeing Center", "General Physician", "PPO", "02116"),
        new Doctor("Dr. Edward Wright", "Women's Care", "Gynecologist", "PPO", "02116")
    );

    public List<Doctor> searchDoctors(DoctorSearchRequest request) {
        String keyword = request.getDoctorHospitalSpecialty();
        return doctors.stream()
                .filter(d -> keyword == null || keyword.isBlank()
                        || d.getName().toLowerCase().contains(keyword.toLowerCase())
                        || d.getHospitalName().toLowerCase().contains(keyword.toLowerCase())
                        || d.getSpecialty().toLowerCase().contains(keyword.toLowerCase()))
                .filter(d -> request.getNetwork() == null || request.getNetwork().isBlank()
                        || d.getNetwork().equalsIgnoreCase(request.getNetwork()))
                .filter(d -> request.getLocation() == null || request.getLocation().isBlank()
                        || d.getLocation().toLowerCase().contains(request.getLocation().toLowerCase()))
                .collect(Collectors.toList());
    }
}
