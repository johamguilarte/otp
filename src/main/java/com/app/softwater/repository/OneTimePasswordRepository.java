package com.app.softwater.repository;

import com.app.softwater.entity.OneTimePassword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface OneTimePasswordRepository extends CrudRepository<OneTimePassword, Long> {
    Optional<OneTimePassword> findByOneTimePasswordCodeAndExpiresAfter(Integer code, Date now);
}
