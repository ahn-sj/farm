package org.tally.farm.category.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tally.farm.category.CategoryType;
import org.tally.farm.global.BaseEntity;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    // ex) CG0000 -> CG = Enum / 0000 -> +10000 & substring
    private String categoryKey;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    private String description;

}
