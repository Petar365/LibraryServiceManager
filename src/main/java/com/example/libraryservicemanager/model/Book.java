//package com.example.libraryservicemanager.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Book {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String Title;
//
//    private String Author;
//
//    private String isbn;
//
//    private Integer quantity;
//
//    @Column(name = "added_at")
//    private LocalDateTime addedAt;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "book")
//    private List<BorrowedBooks> borrowedBooks = new ArrayList<>();
//}
