package com.cg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String description;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_folder")
    private String imageFolder;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "cloud_id")
    private String cloudId;


}
