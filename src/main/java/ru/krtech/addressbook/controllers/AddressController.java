package ru.krtech.addressbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by m.filippov on 08.04.16
 */
@Controller
public class AddressController {

    @RequestMapping("/address")
    public String address(Map<String, Object> model, int id) {
        model.put("id", id);
        return "address";
    }

    @RequestMapping("/addresses")
    public String addresses(Map<String, Object> model) {
        return "addresses";
    }
}
