package ru.krtech.addressbook.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.krtech.addressbook.Application;
import ru.krtech.addressbook.repository.AddressRepository;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration( Application.class)
public class TestAddresses {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private AddressRepository ar;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testAddresses() throws Exception {
        String city = ar.findAll().iterator().next().getCity();
        this.mockMvc.perform(get("/addresses"))
                .andExpect(status().isOk())
                .andExpect(view().name("addresses/list"))
                .andExpect(content().string(containsString(city)))
                .andExpect(content().string(not(containsString("Add person"))));
    }

    @Test
    public void testAddressesNew() throws Exception {
        this.mockMvc.perform(get("/addresses/1/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("addresses/manage"))
                .andExpect(content().string(
                        containsString("<input id=\"address.id\" type=\"hidden\" name=\"id\" value=\"0\" />"))
                );
    }

    @Test
    public void testAddressesEdit() throws Exception {
        this.mockMvc.perform(get("/addresses/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("addresses/manage"))
                .andExpect(content().string(containsString("")));
    }

}
