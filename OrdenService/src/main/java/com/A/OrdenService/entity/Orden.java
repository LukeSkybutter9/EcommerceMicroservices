package com.A.OrdenService.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long productId;
    private Long quantity;
    private Boolean status;

}
