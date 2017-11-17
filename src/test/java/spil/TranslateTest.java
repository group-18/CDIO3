package spil;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslateTest {
    Translate translate;

    @Before
    public void setUp()
    {
        this.translate = new Translate("da_DK");
    }

    @Test
    public void getSetLang() throws Exception
    {
        assertTrue(this.translate.getLang().equals("da_DK"));
    }

    @Test
    public void changeLang()
    {
        Translate translate = this.translate.changeLang("en_EN");

        assertTrue(translate.getLang().equals("en_EN"));
        assertTrue(translate.t("welcome1").equals("Welcome."));
    }

    @Test
    public void t() throws Exception
    {
        assertTrue(this.translate.t("welcome1").equals("Velkommen til spillet."));
        assertTrue(this.translate.t("writeName", new String[] {"2"}).equals("Nummer 2's navn"));
        assertTrue(this.translate.t("empty").equals("empty"));
        assertTrue(this.translate.t("notexist").equals("notexist")); // If string does not exist.
    }
}