package com.mypetlikeit.comm.jwt;

import org.springframework.data.repository.CrudRepository;

import com.mypetlikeit.domain.jwt.LogoutAccessToken;

public interface LogoutAccessTokenRedisRepository extends CrudRepository<LogoutAccessToken, String> {

}
