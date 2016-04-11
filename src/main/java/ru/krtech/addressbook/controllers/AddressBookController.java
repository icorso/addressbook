package ru.krtech.addressbook.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by m.filippov on 08.04.16
 */
@Controller
public class AddressBookController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        return "index";
    }
}
