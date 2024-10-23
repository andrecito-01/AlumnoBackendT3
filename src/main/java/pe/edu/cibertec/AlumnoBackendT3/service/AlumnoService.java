package pe.edu.cibertec.AlumnoBackendT3.service;

import pe.edu.cibertec.AlumnoBackendT3.dto.AlumnoRequestDTO;

import java.io.IOException;

public interface AlumnoService {

    String[] buscarCodAlumno(AlumnoRequestDTO alumnoRequestDTO)throws IOException;

}
