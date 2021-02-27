package by.jrr.tutritapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
/** this is dummy class for dummy table just to make sure database is connected */
public class User {

    @Id
    @GeneratedValue
    Long id;
    String name;
}
