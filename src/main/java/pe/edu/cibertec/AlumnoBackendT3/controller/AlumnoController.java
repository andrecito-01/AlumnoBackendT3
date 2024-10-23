package pe.edu.cibertec.AlumnoBackendT3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.AlumnoBackendT3.dto.AlumnoRequestDTO;
import pe.edu.cibertec.AlumnoBackendT3.dto.AlumnoResponseDTO;
import pe.edu.cibertec.AlumnoBackendT3.service.AlumnoService;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

@RestController
@RequestMapping("/busqueda")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @PostMapping("/buscar")
    public AlumnoResponseDTO buscarcodigo(@RequestBody AlumnoRequestDTO alumnoRequestDTO) {


        try {
            Thread.sleep(Duration.ofSeconds(5));

            String[] datosAlumnos = alumnoService.buscarCodAlumno(alumnoRequestDTO);

            System.out.println("Respuesta Backend: " + Arrays.toString(datosAlumnos));

            if (datosAlumnos == null) {
                return new AlumnoResponseDTO("01", "", "", "", "");
            }

            return new AlumnoResponseDTO(datosAlumnos[0], datosAlumnos[1], datosAlumnos[2], datosAlumnos[3], datosAlumnos[4]);



        }catch (Exception e){
            System.out.println(e.getMessage());
            return new AlumnoResponseDTO("99", "", "", "", "");
        }










    }























    }








