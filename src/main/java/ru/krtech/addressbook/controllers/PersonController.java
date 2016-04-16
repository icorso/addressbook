package ru.krtech.addressbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.krtech.addressbook.model.repository.PersonRepository;

import java.util.Map;

/**
 * Created by m.filippov on 08.04.16
 */
@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = {"/person"}, method = RequestMethod.GET)
    public String person(Map<String, Object> model, int id) {
        model.put("person", personRepository.findOne((long) id));
        return "person";
    }

    @RequestMapping(value = {"/persons"}, method = RequestMethod.GET)
    public String persons(Map<String, Object> model) {
        model.put("persons", personRepository.findAll());
        return "persons";
    }

}
