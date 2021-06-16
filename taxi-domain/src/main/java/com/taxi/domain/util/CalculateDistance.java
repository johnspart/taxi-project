package com.taxi.domain.util;
import com.taxi.domain.model.PointModel;
public final class CalculateDistance {
    private CalculateDistance() {
        super();
    }
    public static double distance(PointModel initial, PointModel toCompare) {
        Double theta = initial.getLongitude() - toCompare.getLongitude();
        double dist = Math.sin(deg2rad(initial.getLatitude())) * Math.sin(deg2rad(toCompare.getLatitude())) +
                Math.cos(deg2rad(initial.getLatitude())) * Math.cos(deg2rad(toCompare.getLatitude())) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;
        return (dist);
    }
    private static double deg2rad(Double deg) {
        return (deg * Math.PI / 180.0);
    }
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
