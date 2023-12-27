package com.example.userservice.service;

import java.util.List;
import java.util.UUID;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import com.example.userservice.jpa.UserRepository;
import com.example.userservice.vo.ResponseOrder;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	BCryptPasswordEncoder passwordEncoder;
	//OrderServiceClient orderServiceClient;
	@Autowired
	public UserServiceImpl(UserRepository userRepository,
		BCryptPasswordEncoder passwordEncoder
	){
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	// @Autowired
	// public UserServiceImpl(UserRepository userRepository,
	// 	BCryptPasswordEncoder passwordEncoder,
	// 	Environment env,
	// 	RestTemplate restTemplate,
	// 	OrderServiceClient orderServiceClient,
	// 	CircuitBreakerFactory circuitBreakerFactory) {
	// 	this.userRepository = userRepository;
	// 	this.passwordEncoder = passwordEncoder;
	// 	this.env = env;
	// 	this.restTemplate = restTemplate;
	// 	this.orderServiceClient = orderServiceClient;
	// 	this.circuitBreakerFactory = circuitBreakerFactory;
	// }

	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setUserId(UUID.randomUUID().toString());

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		//userEntity.setEncryptedPwd(passwordEncoder.encode(userDto.getPwd()));

		userRepository.save(userEntity);

		UserDto returnUserDto = mapper.map(userEntity, UserDto.class);

		return returnUserDto;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException("User not found");

		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
		// List<ResponseOrder> ordersList = orderServiceClient.getOrders(userId);
		// userDto.setOrders(ordersList);

		return userDto;
	}

	@Override
	public Iterable<UserEntity> getUserByAll() {
		return userRepository.findAll();
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = mapper.map(userEntity, UserDto.class);
		return userDto;
	}
}
