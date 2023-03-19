package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TOURS")
@NamedQuery(name = "Tour.getAll", query = "SELECT Tour_id from Web_Tour")
public class Tour{
    @Id
    @Column(name = "Tour_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_of_tour")
    private String nameTour;

    @Column(name = "state_of_tour")
    private String stateTour;

    @Column(name = "cost_of_tour")
    private int costTour;

    @Column(name = "hotel")
    private String hotel;

    @Column(name = "additional_info")
    private String additionalInf;

    public Tour(String nameTour, String stateTour, int costTour, String hotel, String additionalInf) {
        this.nameTour = nameTour;
        this.stateTour = stateTour;
        this.costTour = costTour;
        this.hotel = hotel;
        this.additionalInf = additionalInf;
    }
}
