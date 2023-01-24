package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "laptops")
public class Laptop {
   @Id()
   @GeneratedValue(strategy = GenerationType.SEQUENCE,
           generator = "programmer_id_generator")
   @SequenceGenerator(name = "programmer_id_generator",
           sequenceName = "programmer_seq",
           allocationSize = 1)
    private Long id;
   private String brand;
   @Column(name = "oper_system")
   private String opertionSystem;
   private int memory;
   private int price;
   private LocalDate dateOfIssue;

   public Laptop(String brand, String opertionSystem, int memory, int price, LocalDate dateOfIssue) {
      this.brand = brand;
      this.opertionSystem = opertionSystem;
      this.memory = memory;
      this.price = price;
      this.dateOfIssue = dateOfIssue;
   }

   public Laptop(Long id, String brand, String opertionSystem, int memory, int price, LocalDate dateOfIssue) {
      this.id = id;
      this.brand = brand;
      this.opertionSystem = opertionSystem;
      this.memory = memory;
      this.price = price;
      this.dateOfIssue = dateOfIssue;
   }

   public Laptop() {

   }
}
