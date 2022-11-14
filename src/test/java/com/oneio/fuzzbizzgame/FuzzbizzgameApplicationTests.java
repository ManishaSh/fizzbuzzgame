package com.oneio.fuzzbizzgame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class FuzzbizzgameApplicationTests {
    private final String URI = "/fizz-buzz";
    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;


    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void return400WhenInvalidInput() throws Exception {
        setUp();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URI)
                .param("number", String.valueOf(0))).andReturn();
        assert (mvcResult.getResponse().getStatus() == 400);

    }

    @Test
    public void return200WhenValidInput() throws Exception {
        setUp();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URI)
                .param("number", String.valueOf(16))).andReturn();
        assert (mvcResult.getResponse().getStatus() == 200);
    }

    @Test
    public void returnCorrectOutputValidInput() throws Exception {
        setUp();
        String validOutput = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URI)
                .param("number", String.valueOf(16))).andReturn();
        assert (validOutput.equals(mvcResult.getResponse().getContentAsString()));
    }

}
