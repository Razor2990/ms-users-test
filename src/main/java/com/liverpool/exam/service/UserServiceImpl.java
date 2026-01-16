package com.liverpool.exam.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.liverpool.exam.dto.UserRequestDto;
import com.liverpool.exam.dto.UserResponseDto;
import com.liverpool.exam.entity.Address;
import com.liverpool.exam.entity.User;
import com.liverpool.exam.mapper.UserMapper;
import com.liverpool.exam.repository.UserRepository;
import com.liverpool.exam.service.copomex.CopomexService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private UserMapper userMapper;
	private CopomexService copomexService;
	
	@Override
	public List<UserResponseDto> findAll() {
		
		log.info("Obteniendo información de todos los registros...");
		
		return userRepository.findAll()
				.stream()
				.map(userMapper::toDto)
				.toList();
	}
	
	@Override
	public UserResponseDto findById(String id) {
		log.info("Obteniendo información del usuario con id: {}", id);
		return userRepository.findById(id)
				.map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario"));
	}
	
	@Override
	public UserResponseDto create(UserRequestDto userRequestDto) {
		
		log.info("Guardando datos de usuario");
		Address address = copomexService.getAddressByCp(userRequestDto.getCodigoPostal());
		
		User user = userMapper.toEntity(userRequestDto, address);
		
		UserResponseDto response =  userMapper.toDto(userRepository.save(user));
		
		log.info("Usuario creado con id: {}", response.getId());
		
		return response;
	}
	
	@Override
	public UserResponseDto update(String id, UserRequestDto userRequestDto) {
		
		log.info("Actualizando datos de usuario con id {}", id);
		User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No se encontró el usuario"));
		
		user.setNombre(userRequestDto.getNombre());
		user.setApellidoPaterno(userRequestDto.getApellidoPaterno());
		user.setApellidoMaterno(userRequestDto.getApellidoMaterno());
		user.setCorreo(userRequestDto.getCorreo());
		
		if(!userRequestDto.getCodigoPostal().equals(user.getDireccion().getCodigoPostal())) {
			log.info("Actualizando Address del registro: {}", id);
			Address address = copomexService.getAddressByCp(userRequestDto.getCodigoPostal());
			user.setDireccion(address);
		} else {
			log.info("Sin acutalización de Address. Se conservan los datos del registro: {}", id);
			
		}
		
		return userMapper.toDto(userRepository.save(user));
	}
	
	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
		log.info("Usuario Eliminado: {}", id);
		
	}

}
