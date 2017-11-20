package spil;


import gui_fields.*;
import gui_fields.GUI_Field;
import gui_main.GUI;
import gui_resources.*;

import java.awt.*;


public class Board {
    public static void boardgame(Translate translate)
    {
        //Creating fields in the GUI, with the different values stated in the assignment.
        GUI_Field[] fields = new GUI_Field[24];

        fields[0] = new GUI_Start();
        fields[0].setTitle("Start");
        fields[0].setSubText("Modtag M2");
        fields[0].setBackGroundColor(Color.PINK);
        fields[0].setDescription("Start felt");

        fields[1] = new GUI_Street();
        fields[1].setTitle("Burgerbaren");
        fields[1].setBackGroundColor(Color.ORANGE);
        fields[1].setSubText("M1");

        fields[2] = new GUI_Street();
        fields[2].setTitle("Pizzeriaet");
        fields[2].setBackGroundColor(Color.ORANGE);
        fields[2].setSubText("M1");

        fields[3] = new GUI_Chance();
        fields[3].setTitle("Chance");
        fields[3].setBackGroundColor(Color.WHITE);
        fields[3].setSubText("?");

        fields[4] = new GUI_Street();
        fields[4].setTitle("Slikbutikken");
        fields[4].setBackGroundColor(Color.GRAY);
        fields[4].setSubText("M1");

        fields[5] = new GUI_Street();
        fields[5].setTitle("Iskiosken");
        fields[5].setBackGroundColor(Color.GRAY);
        fields[5].setSubText("M1");

        fields[6] = new GUI_Chance();
        fields[6].setTitle("Chance");
        fields[6].setBackGroundColor(Color.WHITE);
        fields[6].setSubText("?");

        fields[7] = new GUI_Street();
        fields[7].setTitle("Museet");
        fields[7].setBackGroundColor(Color.PINK);
        fields[7].setSubText("M2");

        fields[8] = new GUI_Street();
        fields[8].setTitle("Biblioteket");
        fields[8].setBackGroundColor(Color.PINK);
        fields[8].setSubText("M2");

        fields[9] = new GUI_Chance();
        fields[9].setTitle("Chance");
        fields[9].setBackGroundColor(Color.WHITE);
        fields[9].setSubText("?");

        fields[10] = new GUI_Street();
        fields[10].setTitle("Skaterparken");
        fields[10].setBackGroundColor(Color.YELLOW);
        fields[10].setSubText("M2");

        fields[11] = new GUI_Street();
        fields[11].setTitle("Swimmingpoolen");
        fields[11].setBackGroundColor(Color.YELLOW);
        fields[11].setSubText("M2");

        fields[12] = new GUI_Street();
        fields[12].setTitle("Gratis parkering");
        fields[12].setBackGroundColor(Color.WHITE);
        fields[12].setSubText("");

        fields[13] = new GUI_Street();
        fields[13].setTitle("Spillehallen");
        fields[13].setBackGroundColor(Color.RED);
        fields[13].setSubText("M3");

        fields[14] = new GUI_Street();
        fields[14].setTitle("Biografen");
        fields[14].setBackGroundColor(Color.RED);
        fields[14].setSubText("M3");

        fields[15] = new GUI_Chance();
        fields[15].setTitle("Chance");
        fields[15].setBackGroundColor(Color.WHITE);
        fields[15].setSubText("?");

        fields[16] = new GUI_Street();
        fields[16].setTitle("Legetøjsbutikken");
        fields[16].setBackGroundColor(Color.YELLOW);
        fields[16].setSubText("M3");

        fields[17] = new GUI_Street();
        fields[17].setTitle("Dyrehandlen");
        fields[17].setBackGroundColor(Color.YELLOW);
        fields[17].setSubText("M3");

        fields[18] = new GUI_Chance();
        fields[18].setTitle("Chance");
        fields[18].setBackGroundColor(Color.WHITE);
        fields[18].setSubText("?");

        fields[19] = new GUI_Street();
        fields[19].setTitle("Bowlinghallen");
        fields[19].setBackGroundColor(Color.GREEN);
        fields[19].setSubText("M4");

        fields[20] = new GUI_Street();
        fields[20].setTitle("Zoo");
        fields[20].setBackGroundColor(Color.GREEN);
        fields[20].setSubText("M4");

        fields[21] = new GUI_Chance();
        fields[21].setTitle("Chance");
        fields[21].setBackGroundColor(Color.WHITE);
        fields[21].setSubText("?");

        fields[22] = new GUI_Street();
        fields[22].setTitle("Vandlandet");
        fields[22].setBackGroundColor(Color.BLUE);
        fields[22].setSubText("M5");

        fields[23] = new GUI_Street();
        fields[23].setTitle("Strandpromenaden");
        fields[23].setBackGroundColor(Color.BLUE);
        fields[23].setSubText("M5");

    }
}