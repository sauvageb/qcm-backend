package com.example.qcm.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NonNull
    private RoleEnum name;
}
