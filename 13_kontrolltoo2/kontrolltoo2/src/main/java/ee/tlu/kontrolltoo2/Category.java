package ee.tlu.kontrolltoo2;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class Category{
    public int id;
    public String name;
    public String image;
    public Date creationAt;
    public Date updatedAt;
}
