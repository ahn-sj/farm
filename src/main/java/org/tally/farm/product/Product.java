package org.tally.farm.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tally.farm.global.BaseEntity;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String categoryKey;

    private String name;

    private String description;

    private int regularPrice;

    private int salePrice;

    private int stock;

    private String basicImg1;

    private String basicImg2;

    private Long createdBy;

}
