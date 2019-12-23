package com.cts.service;

import com.cts.util.HospitalConstant;
import com.cts.exception.InvalidDataException;
import com.cts.exception.ResourceNotFoundException;
import com.cts.model.Appointment;
import com.cts.model.Hospital;
import com.cts.model.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    Specialist specialist;

    @Autowired
    Hospital hospital;

    @Autowired
    HospitalConstant hospitalConstant;

    @Override
    public Specialist getSpecialistByHospitalNameAndType(String hospitalName, String specialistType) throws ResourceNotFoundException {
        String specialistHospitalName = specialist.getHospitalName();
        String specialistSpecialistType = specialist.getSpecialistType();

        if (specialistHospitalName.equalsIgnoreCase(hospitalName) && specialistSpecialistType.equalsIgnoreCase(specialistType))
            return specialist;
        else
            throw new ResourceNotFoundException(hospitalConstant.NO_RECORD_FOUND);
    }

    @Override
    public Appointment scheduleAppointment(String hospitalName, String specialistType, String availableDay,
                                           String patientName) throws InvalidDataException, ResourceNotFoundException {
        if (!hospitalName.isEmpty() && !specialistType.isEmpty() && !availableDay.isEmpty()) {
            Appointment appointment = null;
            String specialistHospitalName = specialist.getHospitalName();
            String specialistSpecialistType = specialist.getSpecialistType();
            String specialistAvailableDay = specialist.getAvailableDay();

            if (specialistHospitalName.equalsIgnoreCase(hospitalName) && specialistSpecialistType.equalsIgnoreCase(specialistType)) {
                String[] availableDays = specialistAvailableDay.split(",");
                for (String day : availableDays) {
                    if (day != null && day.equalsIgnoreCase(availableDay)) {
                        appointment = new Appointment(specialist.getSpecialistName(), patientName, day,
                                specialist.getAvailableTime());
                    }
                }
            } else {
                throw new ResourceNotFoundException(hospitalConstant.NO_RECORD_FOUND);
            }

            if (appointment != null)
                return appointment;
            else
                throw new ResourceNotFoundException(hospitalConstant.APPOINTMENT_NOT_AVAILABLE);
        } else {
            throw new InvalidDataException(hospitalConstant.INVALID_DATA);
        }

    }

    @Override
    public String checkBedsAvailable(String hospitalName) throws ResourceNotFoundException, InvalidDataException {
        int bedsAvailable = 0;
        if (hospital.getHospitalName().equalsIgnoreCase(hospitalName) ) {
            String[] bedStatus = hospital.getStatus().split(",");
            for (String status : bedStatus) {
                if (status.equals("discharge"))
                    bedsAvailable++;
            }
            if (bedsAvailable >0)
                return hospitalConstant.BEDS_AVAILABLE_TEXT+bedsAvailable;
            else
                throw new ResourceNotFoundException(hospitalConstant.NO_BEDS_AVAILABLE);
        }else
            throw new InvalidDataException(hospitalConstant.INVALID_DATA);
    }
}
