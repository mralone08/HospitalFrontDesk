package com.cts.model;

public class Appointment {
    String specialistName;
    String patientName;
    String appointmentDay;
    String appointmentTime;

    public Appointment() {
    }

    public Appointment(String specialistName, String patientName, String appointmentDay, String appointmentTime) {
        this.specialistName = specialistName;
        this.patientName = patientName;
        this.appointmentDay = appointmentDay;
        this.appointmentTime = appointmentTime;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(String appointmentDay) {
        this.appointmentDay = appointmentDay;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
