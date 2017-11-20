package spil;


import gui_fields.GUI_Street;

import java.awt.*;


public class Board {
    private GUI_Street[] fields;

    public Board()
    {
        this.initFields();
    }


    public GUI_Street[] getFields()
    {
        return this.fields;
    }


    public GUI_Street getField(int id)
    {
        if (id <= this.fields.length) {
            return this.fields[id];
        }

        return null;
    }


    private void initFields()
    {
        this.fields = new GUI_Street[24];

        this.fields[0] = new GUI_Street();
        this.fields[0].setTitle("Start");
        this.fields[0].setSubText("Modtag M2");
        this.fields[0].setBackGroundColor(Color.PINK);
        this.fields[0].setDescription("Start felt");

        this.fields[1] = new GUI_Street();
        this.fields[1].setTitle("Burgerbaren");
        this.fields[1].setBackGroundColor(Color.ORANGE);
        this.fields[1].setSubText("M1");

        this.fields[2] = new GUI_Street();
        this.fields[2].setTitle("Pizzeriaet");
        this.fields[2].setBackGroundColor(Color.ORANGE);
        this.fields[2].setSubText("M1");

        this.fields[3] = new GUI_Street();
        this.fields[3].setTitle("Chance");
        this.fields[3].setBackGroundColor(Color.WHITE);
        this.fields[3].setSubText("?");

        this.fields[4] = new GUI_Street();
        this.fields[4].setTitle("Slikbutikken");
        this.fields[4].setBackGroundColor(Color.GRAY);
        this.fields[4].setSubText("M1");

        this.fields[5] = new GUI_Street();
        this.fields[5].setTitle("Iskiosken");
        this.fields[5].setBackGroundColor(Color.GRAY);
        this.fields[5].setSubText("M1");

        this.fields[6] = new GUI_Street();
        this.fields[6].setTitle("Fængsel");
        this.fields[6].setBackGroundColor(Color.WHITE);
        this.fields[6].setSubText("På besøg");

        this.fields[7] = new GUI_Street();
        this.fields[7].setTitle("Museet");
        this.fields[7].setBackGroundColor(Color.PINK);
        this.fields[7].setSubText("M2");

        this.fields[8] = new GUI_Street();
        this.fields[8].setTitle("Biblioteket");
        this.fields[8].setBackGroundColor(Color.PINK);
        this.fields[8].setSubText("M2");

        this.fields[9] = new GUI_Street();
        this.fields[9].setTitle("Chance");
        this.fields[9].setBackGroundColor(Color.WHITE);
        this.fields[9].setSubText("?");

        this.fields[10] = new GUI_Street();
        this.fields[10].setTitle("Skaterparken");
        this.fields[10].setBackGroundColor(Color.YELLOW);
        this.fields[10].setSubText("M2");

        this.fields[11] = new GUI_Street();
        this.fields[11].setTitle("Swimmingpoolen");
        this.fields[11].setBackGroundColor(Color.YELLOW);
        this.fields[11].setSubText("M2");

        this.fields[12] = new GUI_Street();
        this.fields[12].setTitle("Gratis parkering");
        this.fields[12].setBackGroundColor(Color.WHITE);
        this.fields[12].setSubText("");

        this.fields[13] = new GUI_Street();
        this.fields[13].setTitle("Spillehallen");
        this.fields[13].setBackGroundColor(Color.RED);
        this.fields[13].setSubText("M3");

        this.fields[14] = new GUI_Street();
        this.fields[14].setTitle("Biografen");
        this.fields[14].setBackGroundColor(Color.RED);
        this.fields[14].setSubText("M3");

        this.fields[15] = new GUI_Street();
        this.fields[15].setTitle("Chance");
        this.fields[15].setBackGroundColor(Color.WHITE);
        this.fields[15].setSubText("?");

        this.fields[16] = new GUI_Street();
        this.fields[16].setTitle("Legetøjsbutikken");
        this.fields[16].setBackGroundColor(Color.YELLOW);
        this.fields[16].setSubText("M3");

        this.fields[17] = new GUI_Street();
        this.fields[17].setTitle("Dyrehandlen");
        this.fields[17].setBackGroundColor(Color.YELLOW);
        this.fields[17].setSubText("M3");

        this.fields[18] = new GUI_Street();
        this.fields[18].setTitle("Gå i fængsel");
        this.fields[18].setBackGroundColor(Color.WHITE);
        this.fields[18].setSubText("Gå i fængsel");

        this.fields[19] = new GUI_Street();
        this.fields[19].setTitle("Bowlinghallen");
        this.fields[19].setBackGroundColor(Color.GREEN);
        this.fields[19].setSubText("M4");

        this.fields[20] = new GUI_Street();
        this.fields[20].setTitle("Zoo");
        this.fields[20].setBackGroundColor(Color.GREEN);
        this.fields[20].setSubText("M4");

        this.fields[21] = new GUI_Street();
        this.fields[21].setTitle("Chance");
        this.fields[21].setBackGroundColor(Color.WHITE);
        this.fields[21].setSubText("?");

        this.fields[22] = new GUI_Street();
        this.fields[22].setTitle("Vandlandet");
        this.fields[22].setBackGroundColor(Color.BLUE);
        this.fields[22].setSubText("M5");

        this.fields[23] = new GUI_Street();
        this.fields[23].setTitle("Strandpromenaden");
        this.fields[23].setBackGroundColor(Color.BLUE);
        this.fields[23].setSubText("M5");
    }
}