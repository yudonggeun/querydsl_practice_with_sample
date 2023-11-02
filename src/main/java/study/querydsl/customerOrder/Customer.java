package study.querydsl.customerOrder;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int age;
    @Column
    private LocalDate joined;
    @Column
    private String name;
    @Column
    private String email;
}
