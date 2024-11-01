package com.oneune.sharing.rest.service;

import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.reader.UserReader;
import com.oneune.sharing.rest.repository.UserRepository;
import com.oneune.sharing.rest.store.dto.UserDto;
import com.oneune.sharing.rest.store.entity.UserEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
public class UserService implements CRUDed<UserDto> {

    ModelMapper modelMapper;
    UserRepository userRepository;
    UserReader userReader;

    @Transactional
    @Override
    public UserDto post(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userRepository.saveAndFlush(userEntity);
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Transactional
    @Override
    public UserDto put(Long userId, UserDto userDto) {
        UserEntity userEntity = userReader.getEntityById(userId);
        modelMapper.map(userDto, userEntity);
        userRepository.saveAndFlush(userEntity);
        return userReader.getById(userDto.getId());
    }

    @Transactional
    @Override
    public UserDto deleteById(Long userId) {
        UserEntity userEntity = userReader.getEntityById(userId);
        userRepository.delete(userEntity);
        userRepository.flush();
        return modelMapper.map(userEntity, UserDto.class);
    }

    public UserEntity getEntityById(Long userId) {
        return userReader.getEntityById(userId);
    }

    @Override
    public UserDto getById(Long userId) {
        return userReader.getById(userId);
    }

    public List<UserDto> getAll() {
        return userReader.getAll();
    }
}
