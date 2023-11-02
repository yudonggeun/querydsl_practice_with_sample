package study.querydsl.customerOrder;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Customer customer;
    @Column
    private String product;
    @Column
    private int amount;
    @Column
    private LocalDate salesDate;
}
