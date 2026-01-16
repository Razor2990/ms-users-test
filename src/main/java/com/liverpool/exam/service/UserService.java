package com.liverpool.exam.service;

import java.util.List;

import com.liverpool.exam.dto.UserRequestDto;
import com.liverpool.exam.dto.UserResponseDto;

public interface UserService {

	List<UserResponseDto> findAll();
	UserResponseDto findById(String id);
	UserResponseDto create(UserRequestDto userRequestDto);
	UserResponseDto update(String id, UserRequestDto userRequestDto);
	void deleteById(String id);
}
