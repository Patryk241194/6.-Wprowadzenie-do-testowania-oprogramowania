package com.kodilla.good.patterns.flights;

public record Flight(String originCity, String destinationCity) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;

        if (originCity() != null ? !originCity().equals(flight.originCity()) : flight.originCity() != null)
            return false;
        return destinationCity() != null ? destinationCity().equals(flight.destinationCity()) : flight.destinationCity() == null;
    }

    @Override
    public int hashCode() {
        int result = originCity() != null ? originCity().hashCode() : 0;
        result = 31 * result + (destinationCity() != null ? destinationCity().hashCode() : 0);
        return result;
    }
}

