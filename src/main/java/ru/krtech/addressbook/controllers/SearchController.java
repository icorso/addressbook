package ru.krtech.addressbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.krtech.addressbook.model.repository.AddressRepository;
import ru.krtech.addressbook.model.repository.PersonRepository;

/**
 * Created by m.filippov on 08.04.16
 */
@Controller
@RequestMapping(value = {"/search/","/search"})
public class SearchController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("term") String term) {
        ModelAndView mav = new ModelAndView("search/results");
        mav.addObject("term", term);
        return mav;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String initSearchForm() {
        return "search/view";
    }

}
