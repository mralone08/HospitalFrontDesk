package com.cts.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Component
@XmlRootElement
@PropertySource("classpath:specialist.properties")
public class Hospital {
    @Value("${hospital.hospitalId}")
    private String hospitalId;

    @Value("${hospital.hospitalName}")
    private String hospitalName;

    @Value("${hospital.specialistName}")
    private String specialistName;

    @Value("${hospital.specialistType}")
    private String specialistType;

    @Value("${hospital.patientName}")
    private String patientName;

    @Value("${hospital.status}")
    private String status;

    public Hospital() {
    }

    public Hospital(String hospitalId, String hospitalName, String specialistName, String specialistType,
                    String patientName, String status) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.specialistName = specialistName;
        this.specialistType = specialistType;
        this.patientName = patientName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalId='" + hospitalId + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", specialistName='" + specialistName + '\'' +
                ", specialistType='" + specialistType + '\'' +
                ", patientName='" + patientName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
