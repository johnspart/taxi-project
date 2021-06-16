package com.taxi.domain.mapper;
import com.taxi.domain.model.PointModel;
import com.taxi.entities.util.Point;
public final class PointMapper {
    private PointMapper() {
        super();
    }
    public static Point mapper(PointModel pointModel) {
        Point point = new Point();
        point.setLatitude(pointModel.getLatitude());
        point.setLongitude(pointModel.getLongitude());
        return point;
    }
}
