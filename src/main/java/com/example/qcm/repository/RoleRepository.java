package com.example.qcm.repository;

import com.example.qcm.repository.entity.Role;
import com.example.qcm.repository.entity.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(RoleEnum role);
}
