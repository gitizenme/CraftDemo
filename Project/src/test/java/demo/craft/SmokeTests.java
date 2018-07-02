package demo.craft;

import demo.craft.controller.CraftController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTests {

    @Autowired
    private CraftController controller;

    @Test
    public void contexLoads() throws Exception {
        Assert.assertNotNull(controller);
    }
}