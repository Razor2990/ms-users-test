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

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private UserMapper userMapper;
	
	@Override
	public List<UserResponseDto> findAll() {
		
		return userRepository.findAll()
				.stream()
				.map(userMapper::toDto)
				.toList();
	}
	
	@Override
	public UserResponseDto findById(String id) {
		
		return userRepository.findById(id)
				.map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario"));
	}
	
	@Override
	public UserResponseDto create(UserRequestDto userRequestDto) {
		
		Address address = Address.builder().codigoPostal(userRequestDto.getCodigoPostal()).build();
		
		User user = userMapper.toEntity(userRequestDto, address);
		
		return userMapper.toDto(userRepository.save(user));
	}
	
	@Override
	public UserResponseDto update(String id, UserRequestDto userRequestDto) {
		
		User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No se encontró el usuario"));
		
		user.setNombre(userRequestDto.getNombre());
		user.setApellidoPaterno(userRequestDto.getApellidoPaterno());
		user.setApellidoMaterno(userRequestDto.getApellidoMaterno());
		user.setCorreo(userRequestDto.getCorreo());
		
		return userMapper.toDto(userRepository.save(user));
	}
	
	@Override
	public void deleteById(String id) {
		log.info("Usuario Eliminado: {}" + id);
		userRepository.deleteById(id);
		
	}

}
