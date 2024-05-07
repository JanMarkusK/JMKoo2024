package ee.tlu.salat.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Getter
@NoArgsConstructor
public class CatFacts{
    private CatStatus status;
    private String _id;
    private String user;
    private String text;
    private int __v;
    private String source;
    private Date updatedAt;
    private String type;
    private Date createdAt;
    private boolean deleted;
    private boolean used;
}


