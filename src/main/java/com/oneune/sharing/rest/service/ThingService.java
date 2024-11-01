package com.oneune.sharing.rest.service;

import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.reader.ThingReader;
import com.oneune.sharing.rest.repository.ThingRepository;
import com.oneune.sharing.rest.store.dto.ThingDto;
import com.oneune.sharing.rest.store.entity.ThingEntity;
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
public class ThingService implements CRUDed<ThingDto> {

    ModelMapper modelMapper;
    ThingRepository thingRepository;
    ThingReader thingReader;

    @Override
    public ThingDto post(ThingDto thingDto) {
        ThingEntity thingEntity = modelMapper.map(thingDto, ThingEntity.class);
        thingRepository.saveAndFlush(thingEntity);
        return thingReader.getById(thingEntity.getId());
    }

    @Override
    public ThingDto put(Long thingId, ThingDto thingDto) {
        ThingEntity thingEntity = thingReader.getEntityById(thingId);
        modelMapper.map(thingDto, thingEntity);
        thingRepository.saveAndFlush(thingEntity);
        return thingReader.getById(thingEntity.getId());
    }

    @Override
    public ThingDto deleteById(Long thingId) {
        ThingDto thingDto = thingReader.getById(thingId);
        thingRepository.deleteById(thingId);
        return thingDto;
    }

    @Override
    public ThingDto getById(Long thingId) {
        return thingReader.getById(thingId);
    }

    @Override
    public List<ThingDto> getAll() {
        return thingReader.getAll();
    }
}
