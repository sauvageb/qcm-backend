package com.example.qcm.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    @ManyToMany
    private List<Role> roleList;

}
