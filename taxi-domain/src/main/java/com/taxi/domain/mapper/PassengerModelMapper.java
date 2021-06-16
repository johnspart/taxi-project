package com.taxi.domain.mapper;
import com.taxi.domain.model.PassengerModel;
import com.taxi.entities.Passenger;
public final class PassengerModelMapper {
    private PassengerModelMapper() {
        super();
    }
    public static PassengerModel mapper(Passenger passenger) {
        PassengerModel passengerModel = new PassengerModel();
        passengerModel.setId(passenger.getId());
        passengerModel.setName(passenger.getName());
        passengerModel.setLastName(passenger.getLastName());
        passengerModel.setDateOfBirth(passenger.getDateOfBirth());
        return passengerModel;
    }
}
