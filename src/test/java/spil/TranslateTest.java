package spil;

import org.junit.Assert;
import org.junit.Test;

public class TranslateTest {

    @Test
    public void getInstance() throws Exception
    {
        Assert.assertEquals("Translate is not the same instance", Translate.getInstance(), Translate.getInstance());
    }


    @Test
    public void setLang() throws Exception
    {
        Assert.assertTrue("Current language is default", Translate.getLang().equals("da_DK"));

        Translate.setLang("en_EN");

        Assert.assertTrue("Current language is now english", Translate.getLang().equals("en_EN"));
    }


    @Test
    public void getLang() throws Exception
    {
        Assert.assertTrue("Current language is default", Translate.getLang().equals("da_DK"));
    }


    @Test
    public void t() throws Exception
    {
        Assert.assertTrue(Translate.t("welcome1").equals("Velkommen til spillet."));
        Assert.assertTrue("Translation takes parameters", Translate.t("writeName", new String[] {"2"}).equals("Nummer 2's navn"));

        Assert.assertTrue("Translation has en empty value", Translate.t("empty").equals("empty"));
        Assert.assertTrue("Translation does not exist", Translate.t("notexist").equals("notexist"));
    }

}