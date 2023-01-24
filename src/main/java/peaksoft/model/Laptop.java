package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import peaksoft.OperationSystem;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
@Table(name="laptops")

public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String brand;
    @Enumerated(EnumType.STRING)
    @Column(name="operation_system")
    private OperationSystem operationSystem;
    private int memory;
    private int price;
    @Column(name="date_of_issue")
    private LocalDate date_of_issue;

    public Laptop(String brand) {
        this.brand = brand;
    }

    public Laptop() {

    }

    public Laptop(Long id) {
        this.id = id;
    }

    public Laptop(String brand, OperationSystem operationSystem, int memory, int price, LocalDate date_of_issue) {
        this.brand = brand;
        this.operationSystem = operationSystem;
        this.memory = memory;
        this.price = price;
        this.date_of_issue = date_of_issue;
    }
}
