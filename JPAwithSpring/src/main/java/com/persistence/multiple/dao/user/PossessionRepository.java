package com.persistence.multiple.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistence.multiple.model.user.Possession;

public interface PossessionRepository extends JpaRepository<Possession, Long> {

}
