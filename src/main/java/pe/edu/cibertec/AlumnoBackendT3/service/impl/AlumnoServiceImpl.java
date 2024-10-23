package pe.edu.cibertec.AlumnoBackendT3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AlumnoBackendT3.dto.AlumnoRequestDTO;
import pe.edu.cibertec.AlumnoBackendT3.service.AlumnoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarCodAlumno(AlumnoRequestDTO alumnoRequestDTO)throws IOException{

        String[] datosAlumnos=null;
        Resource resource= resourceLoader.getResource("classpath:alumnos.txt");

        try(BufferedReader br=new BufferedReader(new FileReader(resource.getFile()))){
            String linea;
            while((linea= br.readLine())!=null){
                String[] datos=linea.split(";");
                if (alumnoRequestDTO.codigo().equals(datos[0])){


                    datosAlumnos=new String[5];
                    datosAlumnos[0]=datos[0]; //Recuperar codigo
                    datosAlumnos[1]=datos[1]; //Recuperar nombre
                    datosAlumnos[2]=datos[2]; //Recuperar apellido
                    datosAlumnos[3]=datos[3]; //Recuperar carrera
                    datosAlumnos[4]=datos[4]; //Recuperar ciclo

                }

            }
        }catch (IOException e){
            datosAlumnos=null;
            throw new IOException(e);
        }

        return datosAlumnos;
    }


}
