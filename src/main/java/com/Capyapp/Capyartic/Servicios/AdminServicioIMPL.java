package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Administrador.AdministradorDto;
import com.Capyapp.Capyartic.Dto.Administrador.AdministradorMapper;
import com.Capyapp.Capyartic.Dto.Administrador.AdministradorToSaveDto;
import com.Capyapp.Capyartic.Entidades.Admin;
import com.Capyapp.Capyartic.Excepciónes.AdministradorNotFoundException;
import com.Capyapp.Capyartic.Repositorios.AdminRepositorio;
import org.springframework.stereotype.Service;

@Service
public class AdminServicioIMPL implements AdminServicio {
    private final AdminRepositorio adminRepositorio;

    public AdminServicioIMPL(AdminRepositorio adminRepositorio) {
        this.adminRepositorio = adminRepositorio;
    }

    @Override
    public AdministradorDto guardarAdministrador(AdministradorToSaveDto administrador) {
        Admin admin1= AdministradorMapper.INSTANCE.administradorToSaveDtoToAdmin(administrador);
        Admin adminGuardado = adminRepositorio.save(admin1);
        return AdministradorMapper.INSTANCE.adminToAdminDto(adminGuardado);
    }

    @Override
    public AdministradorDto actualizarAdministrador(Long id,AdministradorToSaveDto administrador) {
        Admin admin1= AdministradorMapper.INSTANCE.administradorToSaveDtoToAdmin(administrador);
        Admin adminExiste=adminRepositorio.findById(id).orElseThrow(()-> new AdministradorNotFoundException("Administrador no encontrado"));
        adminExiste.setId(id);
        adminExiste.setPrimerNombre(admin1.getPrimerNombre());
        adminExiste.setSegundoNombre(admin1.getSegundoNombre());
        adminExiste.setPrimerApellido(admin1.getPrimerApellido());
        adminExiste.setSegundoApellido(admin1.getSegundoApellido());
        adminExiste.setEmail(admin1.getEmail());
        adminExiste.setNumeroTelefono(admin1.getNumeroTelefono());
        adminExiste.setSexo(admin1.getSexo());
        adminExiste.setContraseña(admin1.getContraseña());
        adminExiste.setNombreUsuario(admin1.getNombreUsuario());
        adminExiste.setFechaRegistro(admin1.getFechaRegistro());
        adminExiste.setFechaNacimiento(admin1.getFechaNacimiento());
        adminExiste.setRolUser(admin1.getRolUser());
        adminExiste.setEstadoUsuario(admin1.getEstadoUsuario());
        adminExiste=adminRepositorio.save(adminExiste);
        return AdministradorMapper.INSTANCE.adminToAdminDto(adminExiste);
    }

    @Override
    public AdministradorDto findById(Long id) throws AdministradorNotFoundException {
        Admin admin=adminRepositorio.findById(id).orElseThrow(()-> new AdministradorNotFoundException("Administrador no encontrado"));
        return AdministradorMapper.INSTANCE.adminToAdminDto(admin);
    }

    @Override
    public void deleteById(Long id) throws AdministradorNotFoundException {
        Admin admin=adminRepositorio.findById(id).orElseThrow(()-> new AdministradorNotFoundException("Administrador no encontrado"));
        adminRepositorio.delete(admin);
    }
}
