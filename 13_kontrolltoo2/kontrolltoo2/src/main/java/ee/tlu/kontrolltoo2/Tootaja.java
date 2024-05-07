package ee.tlu.kontrolltoo2;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Tootaja{
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}