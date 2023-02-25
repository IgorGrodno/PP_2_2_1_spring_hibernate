package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Car() {
    }

    public Car(String model, int series,User user) {
        this.model = model;
        this.series = series;
        this.user=user;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return this.series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
