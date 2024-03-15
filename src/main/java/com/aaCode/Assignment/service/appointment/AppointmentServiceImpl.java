package com.aaCode.Assignment.service.appointment;

import com.aaCode.Assignment.dto.AppointmentDTO;
import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.entity.Appointment;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.repository.AppointmentRepo;
import com.aaCode.Assignment.repository.TechnicianRepo;
import com.aaCode.Assignment.service.technician.TechnicianService;
import com.aaCode.Assignment.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private final AppointmentRepo appointmentRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public AppointmentServiceImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

//    public String saveAppointment(AppointmentDTO appointmentDTO){
//        if (appointmentRepo.existsById(appointmentDTO.getId())){
//            return VarList.RSP_DUPLICATED;
//        }else {
//            appointmentRepo.save(modelMapper.map(appointmentDTO, Appointment.class));
//            return VarList.RSP_SUCCESS;
//        }
//    }

    public Appointment createAppointment(AppointmentDTO appointmentDTO){
        Appointment appointment = new Appointment();

        appointment.setName(appointmentDTO.getName());
        appointment.setAge(appointmentDTO.getAge());
        appointment.setDob(appointmentDTO.getDob());
        appointment.setSex(appointmentDTO.getSex());
        appointment.setCategory(appointmentDTO.getCategory());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setTime(appointmentDTO.getTime());
        appointment.setEmail(appointmentDTO.getEmail());
        appointment.setPhone(appointmentDTO.getPhone());

        return appointmentRepo.save(appointment);
    }

//    public List<Appointment> getAllAppointment(){
//        return appointmentRepo.findAll();
//    }


    public List<AppointmentDTO> getAllAppointment(){
        List<Appointment> userList = appointmentRepo.findAll();
        return modelMapper.map(userList,new TypeToken<ArrayList<AppointmentDTO>>(){
        }.getType());
    }

    public AppointmentDTO searchAppointment(Long id){
        if (appointmentRepo.existsById(id)){
            Appointment user =appointmentRepo.findById(id).orElse(null);
            return modelMapper.map(user, AppointmentDTO.class);
        }else {
            return null;
        }
    }

    public AppointmentDTO searchAppointment2(String category ){
        Optional<Appointment> appointmentOptional = appointmentRepo.findBycategory(category);

        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            return modelMapper.map(appointment, AppointmentDTO.class);
        } else {
            return null;
        }
    }

    public AppointmentDTO searchAppointment3(String date ){
        Optional<Appointment> appointmentOptional = appointmentRepo.findBydate(date);

        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            return modelMapper.map(appointment, AppointmentDTO.class);
        } else {
            return null;
        }
    }

    public String deleteAppointment(Long id){
        if (appointmentRepo.existsById(id)){
            appointmentRepo.deleteById(id);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<Appointment> getallAppointment() {
        return appointmentRepo.findAll();
    }
}
