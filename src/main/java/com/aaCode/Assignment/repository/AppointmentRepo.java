package com.aaCode.Assignment.repository;

import com.aaCode.Assignment.entity.Appointment;
import com.aaCode.Assignment.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findBydate(String date);
    Optional<Appointment> findBycategory(String category);
}
