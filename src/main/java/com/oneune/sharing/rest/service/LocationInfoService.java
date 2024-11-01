package com.oneune.sharing.rest.service;

import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.reader.LocationInfoReader;
import com.oneune.sharing.rest.repository.LocationInfoRepository;
import com.oneune.sharing.rest.store.dto.LocationInfoDto;
import com.oneune.sharing.rest.store.entity.LocationInfoEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
public class LocationInfoService implements CRUDed<LocationInfoDto> {

    ModelMapper modelMapper;
    LocationInfoRepository locationInfoRepository;
    LocationInfoReader locationInfoReader;

    @Override
    public LocationInfoDto post(LocationInfoDto locationInfoDto) {
        LocationInfoEntity locationInfoEntity = modelMapper.map(locationInfoDto, LocationInfoEntity.class);
        locationInfoRepository.saveAndFlush(locationInfoEntity);
        return locationInfoReader.getById(locationInfoEntity.getId());
    }

    @Override
    public LocationInfoDto put(Long locationInfoId, LocationInfoDto locationInfoDto) {
        LocationInfoEntity locationInfoEntity = locationInfoReader.getEntityById(locationInfoId);
        modelMapper.map(locationInfoDto, locationInfoEntity);
        locationInfoRepository.saveAndFlush(locationInfoEntity);
        return locationInfoReader.getById(locationInfoEntity.getId());
    }

    @Override
    public LocationInfoDto deleteById(Long locationInfoId) {
        LocationInfoDto locationInfoDto = locationInfoReader.getById(locationInfoId);
        locationInfoRepository.deleteById(locationInfoId);
        return locationInfoDto;
    }

    @Override
    public LocationInfoDto getById(Long locationInfoId) {
        return locationInfoReader.getById(locationInfoId);
    }

    @Override
    public List<LocationInfoDto> getAll() {
        return locationInfoReader.getAll();
    }
}
