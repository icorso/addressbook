package ru.krtech.addressbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.krtech.addressbook.model.Address;
import ru.krtech.addressbook.model.Person;
import ru.krtech.addressbook.repository.AddressRepository;
import ru.krtech.addressbook.repository.PersonRepository;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by m.filippov on 05.05.16
 */
@Controller
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String addresses(Map<String, Object> model) {
        model.put("addresses", addressRepository.findAll());
        return "addresses/list";
    }

    @RequestMapping(value = "/{pid}/new", method = RequestMethod.GET)
    public String initCreationForm(@PathVariable("pid") int pid, Model model) {
        Address address = new Address();
        model.addAttribute(address);
        model.addAttribute(pid);
        return "addresses/manage";
    }

    @RequestMapping(value = "/{pid}/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid @ModelAttribute(value="address") Address address,
                                      BindingResult result,
                                      @ModelAttribute(value="pid") int pid) {
        if (result.hasErrors()) {
            return "addresses/manage";
        }

        Address a = this.addressRepository.save(address);
        Person p = this.personRepository.findOne((long) pid);
        p.setAddress(a);
        this.personRepository.save(p);
        return "redirect:/addresses/";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String initUpdateAddressForm(@PathVariable("id") int id, Model model) {
        Address address = this.addressRepository.findOne((long) id);
        model.addAttribute(address);
        return "addresses/manage";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public String processUpdateAddressForm(@Valid @ModelAttribute(value="address") Address address,
                                           BindingResult result) {
        if (result.hasErrors()) {
            return "addresses/manage";
        }
        this.addressRepository.save(address);
        return "redirect:/addresses/";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        this.addressRepository.delete((long) id);
        return "redirect:/addresses/";
    }

}
