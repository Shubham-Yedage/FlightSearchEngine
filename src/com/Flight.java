package com;

/**
 * Created by synerzip on 4/4/16.
 */
public class Flight implements Comparable<Flight> {

    private String name;
    private String departure;
    private String arrival;
    private String depDate;
    private int depTime;
    private float duration;
    private float fare;


    public Flight(String name, String departure, String arrival, String depDate, int depTime, float duration, float fare) {
        this.departure = departure;
        this.name = name;
        this.arrival = arrival;
        this.depDate = depDate;
        this.depTime = depTime;
        this.duration = duration;
        this.fare = fare;
    }


    public String getName() {
        return name;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDepDate() {
        return depDate;
    }

    public int getDepTime() {
        return depTime;
    }

    public float getDuration() {
        return duration;
    }

    public float getFare() {
        return fare;
    }

    @Override
    public int compareTo(Flight f) {
        return Double.compare(f.fare, this.fare);
    }

    @Override
    public String toString() {
        return "|" + name + "|" + departure + "|" + arrival + "|" + depDate
                + "|" + depTime + "|" + duration + "|" + fare + "|";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (depTime != flight.depTime) return false;
        if (Float.compare(flight.duration, duration) != 0) return false;
        if (Float.compare(flight.fare, fare) != 0) return false;
        if (!name.equals(flight.name)) return false;
        if (!departure.equals(flight.departure)) return false;
        if (!arrival.equals(flight.arrival)) return false;
        return depDate.equals(flight.depDate);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + departure.hashCode();
        result = 31 * result + arrival.hashCode();
        result = 31 * result + depDate.hashCode();
        result = 31 * result + depTime;
        result = 31 * result + (duration != +0.0f ? Float.floatToIntBits(duration) : 0);
        result = 31 * result + (fare != +0.0f ? Float.floatToIntBits(fare) : 0);
        return result;
    }
}
