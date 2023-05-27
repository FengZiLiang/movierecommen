package com.gupt.bigdata.sparkmoviesweb.service;


import com.gupt.bigdata.sparkmoviesweb.entity.Personalratings;
import com.gupt.bigdata.sparkmoviesweb.mapper.PersonalratingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalratingsService {
    @Autowired
    public PersonalratingsMapper personalratingsMapper;

    public int insertPersonalratings(Personalratings personalratings) {
        return personalratingsMapper.insertPersonalratings(personalratings);
    }

    ;


}
