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
import ru.krtech.addressbook.repository.PersonRepository;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration( Application.class)
public class TestSearch {

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
    public void testSearchForm() throws Exception {
        this.mockMvc.perform(get("/search/"))
                .andExpect(status().isOk())
                .andExpect(view().name("search/view"))
                .andExpect(content().string(containsString("id=\"search-form\"")));
    }

    @Test
    public void testSearchByLastName() throws Exception {
        String keyword = "m";
        String lastName1 = "Moltenmane";
        String lastName2 = "Barleydust";
        this.mockMvc.perform(post("/search/")
                .param("keyword", keyword))
                .andExpect(view().name("search/view"))
                .andExpect(content().string(containsString(keyword)))
                .andExpect(content().string(containsString(lastName1)))
                .andExpect(content().string(not(containsString(lastName2))));
    }

    @Test
    public void testSearchByStreet() throws Exception {
        String keyword = "steel";
        String firstName1 = "Bhelurus";
        String firstName2 = "Doldrom";
        this.mockMvc.perform(post("/search/")
                .param("keyword", keyword))
                .andExpect(view().name("search/view"))
                .andExpect(content().string(containsString(keyword)))
                .andExpect(content().string(containsString(firstName1)))
                .andExpect(content().string(not(containsString(firstName2))));
    }

}
