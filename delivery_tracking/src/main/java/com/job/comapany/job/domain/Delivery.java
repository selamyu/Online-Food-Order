package com.job.comapany.job.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.annotation.Nonnull;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime estimatedDeliveryTime;
//    private LocalDateTime actualDeliveryTime;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    @Column(name = "order_id")
    private Long orderId;
}
