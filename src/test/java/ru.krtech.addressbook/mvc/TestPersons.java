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
import ru.krtech.addressbook.model.repository.AddressRepository;
import ru.krtech.addressbook.model.repository.PersonRepository;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration( Application.class)
public class TestPersons {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private PersonRepository p;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testPersons() throws Exception {
        String firstName = p.findAll().iterator().next().getFirstName();
        this.mockMvc.perform(get("/persons/"))
                .andExpect(status().isOk())
                .andExpect(view().name("persons/list"))
                .andExpect(content().string(containsString(firstName)))
                .andExpect(content().string(containsString("/persons/1/delete")))
                .andExpect(content().string(containsString("/persons/1/edit")));
    }

    @Test
    public void testPersonView() throws Exception {
        String firstName = p.findOne(1L).getFirstName();
        this.mockMvc.perform(get("/persons/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("persons/view"))
                .andExpect(content().string(containsString(firstName)));
    }

    @Test
    public void testPersonNew() throws Exception {
        this.mockMvc.perform(get("/persons/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("persons/manage"))
                .andExpect(content().string(
                        not(containsString("<input type=\"hidden\" name=\"_method\" value=\"put\" />"))));
    }

    @Test
    public void testPersonEdit() throws Exception {
        this.mockMvc.perform(get("/persons/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("persons/manage"))
                .andExpect(content().string(containsString("<input type=\"hidden\" name=\"_method\" value=\"put\" />")));
    }

}
