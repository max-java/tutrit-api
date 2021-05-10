package by.jrr.tutritapi.bean;

import lombok.Data;

import java.time.Instant;

@Data
//@Entity
public class Event {

//    @Id
    String alias;
    String name;
    Instant date;

}
