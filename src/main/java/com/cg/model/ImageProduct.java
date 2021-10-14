//package com.cg.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//
//public class ImageProduct {
//
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String id;
//
//    @Column(name = "image_name")
//    private String imageName;
//
//    @Column(name = "image_folder")
//    private String imageFolder;
//
//    @Column(name = "image_url")
//    private String imageUrl;
//
//    @Column(name = "cloud_id")
//    private String cloudId;
//
//    @ManyToOne
//    @JoinColumn(name = "image_id")
//    @JsonIgnore
//    private ImageProduct imageProduct;
//}
