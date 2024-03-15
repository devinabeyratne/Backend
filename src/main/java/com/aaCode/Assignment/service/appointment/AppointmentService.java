package com.aaCode.Assignment.service.appointment;

import com.aaCode.Assignment.dto.AppointmentDTO;
import com.aaCode.Assignment.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(AppointmentDTO appointmentDTO);

//    String saveAppointment(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> getAllAppointment();

    AppointmentDTO searchAppointment(Long id);

    AppointmentDTO searchAppointment2(String category );

    AppointmentDTO searchAppointment3(String date );

    String deleteAppointment(Long id);

    List<Appointment> getallAppointment();
}
