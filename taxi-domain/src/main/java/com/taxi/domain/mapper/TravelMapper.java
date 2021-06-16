package com.taxi.domain.mapper;
import com.taxi.domain.model.TravelModel;
import com.taxi.entities.Travel;

import java.util.Objects;
public final class TravelMapper {
    private TravelMapper() {
        super();
    }
    public static Travel mapper(TravelModel travelModel) {
        Travel travel = new Travel();
        travel.setId(travelModel.getId());
        travel.setPassenger(PassengerMapper.mapper(travelModel.getPassenger()));
        travel.setDriver(DriverMapper.mapper(travelModel.getDriver()));
        travel.setStartDateTime(travelModel.getStartDateTime());
        travel.setStartPoint(PointMapper.mapper(travelModel.getStartPoint()));
        travel.setEndDateTime(travelModel.getEndDateTime());
        travel.setEndPoint(Objects.isNull(travelModel.getEndPoint()) ? null : PointMapper.mapper(travelModel.getEndPoint()));
        return travel;
    }
}
