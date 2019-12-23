package com.cts.controller;

import com.cts.exception.InvalidDataException;
import com.cts.exception.ResourceNotFoundException;
import com.cts.model.Appointment;
import com.cts.model.Specialist;
import com.cts.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${hostname}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class HospitalController {

    public static final String GET_SPECIALIST = "${get.specialist.url}";

    public static final String BEDS_AVAILABLE = "${beds.available.url}";

    @Autowired
    HospitalService hospitalService;

    @GetMapping(GET_SPECIALIST)
    public Specialist getSpecialistByHospitalNameAndType(@PathVariable String hospitalName,
                                                         @PathVariable String specialistType) throws ResourceNotFoundException {
        return hospitalService.getSpecialistByHospitalNameAndType(hospitalName, specialistType);

    }

    @PostMapping
    public Appointment scheduleAppointment(@RequestBody Specialist specialist) throws InvalidDataException,
            ResourceNotFoundException {
        return hospitalService.scheduleAppointment(specialist.getHospitalName(),
                specialist.getSpecialistType(), specialist.getAvailableDay(),
                specialist.getPatientName());

    }

    @GetMapping(BEDS_AVAILABLE)
    public String checkAvailableBeds(@PathVariable String hospitalName) throws ResourceNotFoundException,
            InvalidDataException {
       return hospitalService.checkBedsAvailable(hospitalName);
    }
}
