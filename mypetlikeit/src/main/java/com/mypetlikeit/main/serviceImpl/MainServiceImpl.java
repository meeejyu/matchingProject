package com.mypetlikeit.main.serviceImpl;

import org.springframework.stereotype.Service;

import com.mypetlikeit.main.mapper.MainMapper;
import com.mypetlikeit.main.service.MainService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{
    
    private final MainMapper mainMapper;

}
