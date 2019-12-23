package com.cts.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Component
@XmlRootElement
@PropertySource("classpath:specialist.properties")
public class Specialist {

    @Value("${specialist.hospitalId}")
    int hospitalId;
    @Value("${specialist.hospitalName}")
    String hospitalName;
    @Value("${specialist.availableDay}")
    String availableDay;
    @Value("${specialist.availableTime}")
    String availableTime;
    @Value("${specialist.isAvailable}")
    String isAvailable;
    @Value("${specialist.specialistType}")
    String specialistType;
    @Value("${specialist.specialistName}")
    String specialistName;

    String patientName;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", availableDay='" + availableDay + '\'' +
                ", availableTime='" + availableTime + '\'' +
                ", isAvailable='" + isAvailable + '\'' +
                ", specialistType='" + specialistType + '\'' +
                ", specialistName='" + specialistName + '\'' +
                ", patientName='" + patientName + '\'' +
                '}';
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAvailableDay() {
        return availableDay;
    }

    public void setAvailableDay(String availableDay) {
        this.availableDay = availableDay;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }
}
