package net.yasri.microservice.domain;

import lombok.*;
import net.yasri.microservice.web.model.BreadStyleEnum;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bread {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Integer version;

    @CreationTimestamp
    @Column(updatable = false)
    private OffsetDateTime createdDate;

    @UpdateTimestamp
    private OffsetDateTime lastModifiedDate;

    private String breadName;
    private BreadStyleEnum breadStyle;

    @Column(unique = true)
    private Long upc;

    private BigDecimal price;
    private Integer quantityOnHand;
}
