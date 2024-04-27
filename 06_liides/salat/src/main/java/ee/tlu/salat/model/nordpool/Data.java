package ee.tlu.salat.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private int userId;
    private int id;
    private String title;
    private String body;
}