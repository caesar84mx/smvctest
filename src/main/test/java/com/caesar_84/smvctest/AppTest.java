package main.test.java.com.caesar_84.smvctest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by caesar-84 on 2/9/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTest
{
    private MockMvc mockMvc;

    @SuppressWarnings("SpringjavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup()
    {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    public void simple() throws Exception
    {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }
}