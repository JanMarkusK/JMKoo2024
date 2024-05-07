package ee.tlu.salat.model;
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

// ctrl + r    "private"    "private"   --> replace All
// private class Omniva

@Getter
@NoArgsConstructor
public class CatStatus{
    public boolean verified;
    public int sentCount;
    public String feedback;
}