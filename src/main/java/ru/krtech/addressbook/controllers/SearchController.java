package ru.krtech.addressbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.krtech.addressbook.model.Person;
import ru.krtech.addressbook.repository.AddressRepository;
import ru.krtech.addressbook.repository.PersonRepository;

/**
 * Created by m.filippov on 08.04.16
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String search() {
        return "search/view";
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("keyword") String keyword) {
        ModelAndView mav = new ModelAndView("search/view");
        mav.addObject("keyword", keyword.trim());
        Iterable<Person> persons = personRepository.getPersonsByKeyword(keyword.trim());
        mav.addObject("persons", persons);
        return mav;
    }

}
