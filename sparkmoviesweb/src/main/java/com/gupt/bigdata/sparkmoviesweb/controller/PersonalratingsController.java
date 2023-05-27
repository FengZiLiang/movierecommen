package com.gupt.bigdata.sparkmoviesweb.controller;


import com.gupt.bigdata.sparkmoviesweb.entity.Personalratings;
import com.gupt.bigdata.sparkmoviesweb.service.PersonalratingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personalratings")
public class PersonalratingsController {
    @Autowired
    public PersonalratingsService personalratingsService;

    @RequestMapping(value = "/insertPersonalratings" ,method = RequestMethod.POST)
    public int insertPersonalratings(Personalratings personalratings){
        return personalratingsService.insertPersonalratings(personalratings);
    };
}
