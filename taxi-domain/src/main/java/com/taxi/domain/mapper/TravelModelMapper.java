package com.taxi.domain.mapper;
import com.taxi.domain.model.TravelModel;
import com.taxi.entities.Travel;
public final class TravelModelMapper {
    private TravelModelMapper() {
        super();
    }
    public static TravelModel mapper(Travel travel) {
        TravelModel travelModel = new TravelModel();
        travelModel.setId(travel.getId());
        travelModel.setPassenger(PassengerModelMapper.mapper(travel.getPassenger()));
        travelModel.setDriver(DriverModelMapper.mapper(travel.getDriver()));
        travelModel.setStartDateTime(travel.getStartDateTime());
        travelModel.setStartPoint(PointModelMapper.mapper(travel.getStartPoint()));
        travelModel.setEndDateTime(travel.getEndDateTime());
        travelModel.setEndPoint(PointModelMapper.mapper(travel.getEndPoint()));
        return travelModel;
    }
}
