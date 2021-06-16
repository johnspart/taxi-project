package com.taxi.domain.mapper;
import com.taxi.domain.model.PassengerModel;
import com.taxi.entities.Passenger;
public final class PassengerMapper {
    private PassengerMapper() {
        super();
    }
    public static Passenger mapper(PassengerModel passengerM) {
        Passenger passenger = new Passenger();
        passenger.setId(passengerM.getId());
        passenger.setName(passengerM.getName());
        passenger.setLastName(passengerM.getLastName());
        passenger.setDateOfBirth(passengerM.getDateOfBirth());
        return passenger;
    }
}
