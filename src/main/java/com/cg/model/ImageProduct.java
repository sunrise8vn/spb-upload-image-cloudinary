package com.cg.model;


import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@ToString(exclude = "product")
@EqualsAndHashCode(exclude = "product")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "images_product")
public class ImageProduct {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_folder")
    private String imageFolder;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "cloud_id")
    private String cloudId;

    @Column(columnDefinition = "BIGINT(20) DEFAULT 0")
    private Long ts = new Date().getTime();

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
