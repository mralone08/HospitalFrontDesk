package com.cts.service;

import com.cts.exception.InvalidDataException;
import com.cts.model.Appointment;
import com.cts.model.Specialist;
import com.cts.exception.ResourceNotFoundException;

public interface HospitalService {
    Specialist getSpecialistByHospitalNameAndType(String hospitalName, String specialistType) throws ResourceNotFoundException;
    Appointment scheduleAppointment(String hospitalName, String specialistType,String availableDay,String patientName) throws InvalidDataException,ResourceNotFoundException;
    String checkBedsAvailable(String hospitalName) throws ResourceNotFoundException, InvalidDataException;
}
