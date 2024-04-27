package ee.tlu.salat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "toiduaine") //selleks, et vahetada AB tabeli nime
@Entity // AB'ga suhtlemiseks
@AllArgsConstructor
@NoArgsConstructor // AB'sse panekuks
public class ToiduaineEntity {
    @Id // alati unikaalne kustutamiseks, võtmiseks, muutmiseks
    private String nimetus;
    private int valk;
    private int rasv;
    private int sysivesik;
}
