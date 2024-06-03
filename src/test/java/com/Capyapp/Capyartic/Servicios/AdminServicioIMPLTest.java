package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Administrador.AdministradorDto;
import com.Capyapp.Capyartic.Dto.Administrador.AdministradorMapper;
import com.Capyapp.Capyartic.Dto.Administrador.AdministradorToSaveDto;
import com.Capyapp.Capyartic.Entidades.Admin;
import com.Capyapp.Capyartic.Entidades.EstadoUsuario;
import com.Capyapp.Capyartic.Entidades.Rol;
import com.Capyapp.Capyartic.Repositorios.AdminRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AdminServicioIMPLTest {
    @Mock
    private AdminRepositorio adminRepositorio;

    @InjectMocks
    private AdminServicioIMPL adminServicio;
    Admin admin;
    AdministradorMapper adminMapper;
    @BeforeEach
    void setUp(){
        adminMapper=new AdministradorMapperImpl();
        adminServicio=new AdminServicioIMPL(adminRepositorio);
        admin=new Admin();
        admin.setId(1L);
        admin.setPrimerNombre("Andres");
        admin.setSegundoNombre("Juan");
        admin.setPrimerApellido("Parra");
        admin.setSegundoApellido("Arias");
        admin.setEmail("Parrouianos_turulingo@gmail.com");
        admin.setNumeroTelefono(3005679876L);
        admin.setSexo("Masculino");
        admin.setContraseña("ÑioclaSala1234");
        admin.setNombreUsuario("Guillermito");
        admin.setFechaRegistro(LocalDateTime.of(2024, Month.AUGUST,10,8,20));
        admin.setFechaNacimiento(LocalDateTime.of(2002, Month.APRIL,1,8,20));
        admin.setRolUser(Rol.ALUMNO);
        admin.setEstadoUsuario(EstadoUsuario.ACTIVO);
        adminRepositorio.save(admin);
    }
    @Test
    void GiveAdministrador_WhenAdministradorCreate_ThenReturnAdministradorGuardado() {
        admin.setId(1L);
        admin.setPrimerNombre("Andres");
        admin.setSegundoNombre("Juan");
        admin.setPrimerApellido("Parra");
        admin.setSegundoApellido("Arias");
        admin.setEmail("Parrouianos_turulingo@gmail.com");
        admin.setNumeroTelefono(3005679876L);
        admin.setSexo("Masculino");
        admin.setContraseña("ÑioclaSala1234");
        admin.setNombreUsuario("Guillermito");
        admin.setFechaRegistro(LocalDateTime.of(2024, Month.AUGUST,10,8,20));
        admin.setFechaNacimiento(LocalDateTime.of(2002, Month.APRIL,1,8,20));
        admin.setRolUser(Rol.ALUMNO);
        admin.setEstadoUsuario(EstadoUsuario.ACTIVO);
        given(adminRepositorio.save(any())).willReturn(admin);
        //Given
        AdministradorToSaveDto administradorGuardado=new AdministradorToSaveDto(
                "Andres",
                "Juan",
                "Parra",
                "Arias",
                "Parrouianos_turulingo@gmail.com",
                3005679876L,
                "Masculino",
                "ÑioclaSala1234",
                LocalDateTime.of(2024, Month.AUGUST,10,8,20),
                LocalDateTime.of(2002, Month.APRIL,1,8,20),
                Rol.ALUMNO,
                EstadoUsuario.ACTIVO
        );
        //When
        AdministradorDto administradorDto=adminServicio.guardarAdministrador(administradorGuardado);
        //Then
        assertThat(administradorDto).isNotNull();
        assertThat(administradorDto.getEmail()).isEqualTo("Parrouianos_turulingo@gmail.com");
    }

    @Test
    void actualizarAdministrador() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }
}