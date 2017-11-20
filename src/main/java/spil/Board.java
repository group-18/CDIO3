package spil;


import gui_fields.GUI_Field;
import gui_fields.GUI_Field;
import gui_main.GUI;
import gui_resources.*;

import java.awt.*;


public class Board {
    public static void boardgame(Translate translate)
    {
        //Creating fields in the GUI, with the different values stated in the assignment.
        GUI_Field[] fields = new GUI_Field[24];
        //Field[] fields = new Field[24];

        //fields[0] = new GUI_Street()
        //.setBackGroundColor(Color.ORANGE)
        fields[0] = new GUI_Street();
        fields[0].setTitle("Start");
        fields[0].setSubText("Modtag M2");
        fields[0].setBackGroundColor(Color.PINK);
        fields[0].setDescription("Start felt");

        fields[1] = new GUI_Street();
        fields[1].setTitle("Burgerbaren")
        fields[1].setBackGroundColor(Color.ORANGE)
        fields[1].setSubText("M1")
                //.setDescription(translate.t("field.tower.description"))

        fields[2] = new GUI_Street();
        fields[2].setTitle("Pizzeriaet");
        fields[2].setBackGroundColor(Color.ORANGE);
        fields[2].setSubText("M1");
                //.setDescription(translate.t("field.crater.description"))

        fields[3] = new GUI_Street();
        fields[3].setTitle("Chance");
        fields[3].setBackGroundColor(Color.WHITE);
        fields[3].setSubText("?");
                //.setDescription(translate.t("field.palace_gates.description"))

        fields[4] = new GUI_Street();
        fields[4].setTitle("Slikbutikken");
        fields[4].setBackGroundColor(Color.GRAY);
        fields[4].setSubText("M1");
                //.setDescription(translate.t("field.cold_desert.description"))

        fields[5] = new GUI_Street();
        fields[5].setTitle("Iskiosken");
        fields[5].setBackGroundColor(Color.GRAY);
        fields[5].setSubText("M1");
                //.setDescription(translate.t("field.walled_city.description"))

        fields[6] = new GUI_Street();
        fields[6].setTitle("Fængsel");
        fields[6].setBackGroundColor(Color.WHITE);
        fields[6].setSubText("På besøg");
                //.setDescription(translate.t("field.monastery.description"))

        fields[7] = new GUI_Street();
        fields[7].setTitle("Museet");
        fields[7].setBackGroundColor(Color.PINK);
        fields[7].setSubText("M2");
                //.setDescription(translate.t("field.black_cave.description"))

        fields[8] = new GUI_Street();
        fields[8].setTitle("Biblioteket");
        fields[8].setBackGroundColor(Color.PINK);
        fields[8].setSubText("M2");
                //.setDescription(translate.t("field.huts_in_the_mountain.description"))

        fields[9] = new GUI_Street();
        fields[9].setTitle("Chance");
        fields[9].setBackGroundColor(Color.WHITE);
        fields[9].setSubText("?");
                //.setDescription(translate.t("field.the_werewall.description"))

        fields[10] = new GUI_Street();
        fields[10].setTitle("Skaterparken");
        fields[10].setBackGroundColor(Color.YELLOW);
        fields[10].setSubText("M2");
                //.setDescription(translate.t("field.the_pit.description"))

        fields[11] = new GUI_Street();
        fields[11].setTitle("Swimmingpoolen")
        fields[11].setBackGroundColor(Color.YELLOW)
        fields[11].setSubText("M2")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[12] = new GUI_Street()
                .setTitle("Gratis parkering")
                .setBackGroundColor(Color.WHITE)
                .setSubText("")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[13] = new GUI_Street()
                .setTitle("Spillehallen")
                .setBackGroundColor(Color.RED)
                .setSubText("M3")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[14] = new GUI_Street()
                .setTitle("Biografen")
                .setBackGroundColor(Color.RED)
                .setSubText("M3")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[15] = new GUI_Street()
                .setTitle("Chance")
                .setBackGroundColor(Color.WHITE)
                .setSubText("?")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[16] = new GUI_Street()
                .setTitle("Legetøjsbutikken")
                .setBackGroundColor(Color.YELLOW)
                .setSubText("M3")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[17] = new GUI_Street()
                .setTitle("Dyrehandlen")
                .setBackGroundColor(Color.YELLOW)
                .setSubText("M3")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[18] = new GUI_Street()
                .setTitle("Gå i fængsel")
                .setBackGroundColor(Color.WHITE)
                .setSubText("Gå i fængsel")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[19] = new GUI_Street()
                .setTitle("Bowlinghallen")
                .setBackGroundColor(Color.GREEN)
                .setSubText("M4")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[20] = new GUI_Street()
                .setTitle("Zoo")
                .setBackGroundColor(Color.GREEN)
                .setSubText("M4")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[21] = new GUI_Street()
                .setTitle("Chance")
                .setBackGroundColor(Color.WHITE)
                .setSubText("?")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[22] = new GUI_Street()
                .setTitle("Vandlandet")
                .setBackGroundColor(Color.BLUE)
                .setSubText("M5")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[23] = new GUI_Street()
                .setTitle("Strandpromenaden")
                .setBackGroundColor(Color.BLUE)
                .setSubText("M5")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();

                //GUI.create(fields);
                //GUI(GUI_Field[24]);
                GUI gui = new GUI(fields);
    }
}