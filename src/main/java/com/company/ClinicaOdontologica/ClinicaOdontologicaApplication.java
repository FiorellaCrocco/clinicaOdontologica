package com.company.ClinicaOdontologica;

import com.company.ClinicaOdontologica.entity.Domicilio;
import com.company.ClinicaOdontologica.entity.Odontologo;
import com.company.ClinicaOdontologica.entity.Paciente;
import com.company.ClinicaOdontologica.entity.Turno;
import net.bytebuddy.asm.Advice;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	private static final Logger logger = Logger.getLogger(ClinicaOdontologicaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		logger.info("La aplicacion se encuentra en ejecucion");
	}

}
