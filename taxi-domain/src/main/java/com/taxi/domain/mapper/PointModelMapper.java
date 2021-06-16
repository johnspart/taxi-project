package com.taxi.domain.mapper;
import com.taxi.domain.model.PointModel;
import com.taxi.entities.util.Point;
public final class PointModelMapper {
    private PointModelMapper() {
        super();
    }
    public static PointModel mapper(Point point) {
        PointModel pointModel = new PointModel();
        pointModel.setLatitude(point.getLatitude());
        pointModel.setLongitude(point.getLongitude());
        return pointModel;
    }
}
