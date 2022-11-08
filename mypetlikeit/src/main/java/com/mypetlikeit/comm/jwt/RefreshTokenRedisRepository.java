package com.mypetlikeit.comm.jwt;

import org.springframework.data.repository.CrudRepository;

import com.mypetlikeit.domain.jwt.RefreshToken;

public interface RefreshTokenRedisRepository extends CrudRepository<RefreshToken, String> {

}