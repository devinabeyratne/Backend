package com.aaCode.Assignment.controller;

import com.aaCode.Assignment.dto.AppointmentDTO;
import com.aaCode.Assignment.dto.ResponseDTO;
import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.entity.Appointment;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.service.appointment.AppointmentService;
import com.aaCode.Assignment.service.technician.TechnicianService;
import com.aaCode.Assignment.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/appointment")
@CrossOrigin("*")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

//    @PostMapping(value = "/CreateAppointment")
//    public ResponseEntity saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
//        try {
//            String res = appointmentService.saveAppointment(appointmentDTO);
//            if (res.equals("00")) {
//                responseDTO.setCode(VarList.RSP_SUCCESS);
//                responseDTO.setMessage("Success");
//                responseDTO.setContent(appointmentDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//
//            } else if (res.equals("06")) {
//                responseDTO.setCode(VarList.RSP_DUPLICATED);
//                responseDTO.setMessage("Appointment already added.");
//                responseDTO.setContent(appointmentDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            } else {
//                responseDTO.setCode(VarList.RSP_FAIL);
//                responseDTO.setMessage("Error");
//                responseDTO.setContent(null);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            }
//
//        } catch (Exception ex) {
//            responseDTO.setCode(VarList.RSP_ERROR);
//            responseDTO.setMessage(ex.getMessage());
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
//
//    }

    @PostMapping(path = "/CreateAppointment")
    public ResponseEntity<Appointment> addAppointment(@RequestBody AppointmentDTO appointmentDTO){
        Appointment appointment = appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);

    }

//    @GetMapping("/getAllAppointment")
//    public ResponseEntity getAllAppointment() {
//        try {
//            List<AppointmentDTO> userDTOList = appointmentService.getAllAppointment();
//            responseDTO.setCode(VarList.RSP_SUCCESS);
//            responseDTO.setMessage("Success");
//            responseDTO.setContent(userDTOList);
//            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//
//        } catch (Exception ex) {
//            responseDTO.setCode(VarList.RSP_ERROR);
//            responseDTO.setMessage(ex.getMessage());
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
//    }

    @GetMapping(path = "/getAllAppointment")
    public ResponseEntity<List<Appointment>> getAllAppointment(){
        return ResponseEntity.ok(appointmentService.getallAppointment());
    }

    @GetMapping("/searchAppointment/{id}")
    public ResponseEntity searchAppointment(@PathVariable Long id) {
        try {
            AppointmentDTO userDTO = appointmentService.searchAppointment(id);
            if (userDTO != null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(userDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Appointment Available For this appointment id");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchAppointment2/{category}")
    public ResponseEntity searchAppointment2(@PathVariable String category) {
        try {
            AppointmentDTO appointmentDTO = appointmentService.searchAppointment2(category);
            if (appointmentDTO != null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(appointmentDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Appointment Available For this test_name");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchAppointment3/{date}")
    public ResponseEntity searchAppointment3(@PathVariable String date) {
        try {
            AppointmentDTO appointmentDTO = appointmentService.searchAppointment3(date);
            if (appointmentDTO != null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(appointmentDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Appointment Available For this date");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAppointment/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Long id) {
        try {
            String res = appointmentService.deleteAppointment(id);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Appointment Available For this appointment id");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
