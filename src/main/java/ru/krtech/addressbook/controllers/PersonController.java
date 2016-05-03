package ru.krtech.addressbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.krtech.addressbook.model.Person;
import ru.krtech.addressbook.repository.AddressRepository;
import ru.krtech.addressbook.repository.PersonRepository;

import java.util.Map;

/**
 * Created by m.filippov on 08.04.16
 */
@Controller
@RequestMapping(value = {"/persons", "/persons/"})
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ModelAndView showPerson(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("persons/view");
        mav.addObject(this.personRepository.findOne((long) id));
        return mav;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreationForm(Model model) {
        Person owner = new Person();
        model.addAttribute(owner);
        return "persons/manage";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreationForm(@ModelAttribute(value="person") Person person,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/persons/new";
        } else {
            Person p = this.personRepository.save(person);
            return "redirect:/persons/" + p.getId();
        }
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String persons(Map<String, Object> model) {
        model.put("persons", personRepository.findAll());
        return "persons/list";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String initUpdatePersonForm(@PathVariable("id") int id, Model model) {
        Person person = this.personRepository.findOne((long) id);
        model.addAttribute(person);
        return "persons/manage";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public String processUpdatePersonForm(@ModelAttribute(value="person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "persons/manage";
        } else {
            this.personRepository.save(person);
            return "redirect:/persons/{id}";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        this.personRepository.delete((long) id);
        return "redirect:/persons/";
    }

}
