package com.taxi.domain.model;
public class DistanceKMGeneric<T> implements Comparable<DistanceKMGeneric<T>> {
    private T value;
    private Double distance;
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    @Override
    public int compareTo(DistanceKMGeneric<T> o) {
        return this.distance.compareTo(o.getDistance());
    }
}
