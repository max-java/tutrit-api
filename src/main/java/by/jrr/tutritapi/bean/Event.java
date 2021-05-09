package by.jrr.tutritapi.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Data
//@Entity
public class Event {

    @Id
    String alias;
    String name;
    Instant date;

}
