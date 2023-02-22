package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    private String nameTour;
    private String stateTour;
    private int costTour;
    private String hotel;
    private String additionalInf;
}
