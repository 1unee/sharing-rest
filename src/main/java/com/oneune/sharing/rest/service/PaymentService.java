package com.oneune.sharing.rest.service;

import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.reader.PaymentReader;
import com.oneune.sharing.rest.repository.PaymentRepository;
import com.oneune.sharing.rest.store.dto.PaymentDto;
import com.oneune.sharing.rest.store.entity.PaymentEntity;
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
public class PaymentService implements CRUDed<PaymentDto> {

    ModelMapper modelMapper;
    PaymentRepository paymentRepository;
    PaymentReader paymentReader;

    @Override
    public PaymentDto post(PaymentDto paymentDto) {
        PaymentEntity paymentEntity = modelMapper.map(paymentDto, PaymentEntity.class);
        paymentRepository.saveAndFlush(paymentEntity);
        return paymentReader.getById(paymentEntity.getId());
    }

    @Override
    public PaymentDto put(Long paymentId, PaymentDto paymentDto) {
        PaymentEntity paymentEntity = paymentReader.getEntityById(paymentId);
        modelMapper.map(paymentDto, paymentEntity);
        paymentRepository.saveAndFlush(paymentEntity);
        return paymentReader.getById(paymentEntity.getId());
    }

    @Override
    public PaymentDto deleteById(Long paymentId) {
        PaymentDto paymentDto = paymentReader.getById(paymentId);
        paymentRepository.deleteById(paymentId);
        return paymentDto;
    }

    @Override
    public PaymentDto getById(Long paymentId) {
        return paymentReader.getById(paymentId);
    }

    @Override
    public List<PaymentDto> getAll() {
        return paymentReader.getAll();
    }
}
