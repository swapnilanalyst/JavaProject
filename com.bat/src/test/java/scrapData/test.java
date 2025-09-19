package scrapData;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test {

    @Test
    public void checkTitle() {
        Assert.assertTrue("Hello".contains("Hell"), "Text does not contain expected substring!");
    }
}
