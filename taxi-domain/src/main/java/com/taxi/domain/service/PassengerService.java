package com.taxi.domain.service;
import com.taxi.domain.mapper.PassengerModelMapper;
import com.taxi.domain.model.PassengerModel;
import com.taxi.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    public List<PassengerModel> getAllPassenger() {
        return this.passengerRepository.findAll().parallelStream().map(PassengerModelMapper::mapper).collect(Collectors.toList());
    }
    public PassengerModel getPassengerById(Long passengerId) {
        return this.passengerRepository.findById(passengerId).map(PassengerModelMapper::mapper).orElse(null);
    }
}
