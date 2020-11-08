package algo_lab_1;

public class Plane {

    private String name;
    private Double volumeInLiters;
    private Integer passengers;

    public Plane(String name, Double volumeInLiters, Integer passengers) {
        this.name = name;
        this.volumeInLiters = volumeInLiters;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public Double getVolumeInLiters() {
        return volumeInLiters;
    }

    public Integer getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", volumeInLiters=" + volumeInLiters +
                ", passengers=" + passengers +
                '}';
    }
}
