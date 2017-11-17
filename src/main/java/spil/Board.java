package spil;


import desktop_fields.Street;
import desktop_fields.Field;
import desktop_resources.*;

import java.awt.*;


public class Board {
    public static void boardgame(Translate translate)
    {
        //Creating fields in the GUI, with the different values stated in the assignment.
        Field[] fields = new Field[24];

        fields[0] = new Street.Builder()
                .setTitle("Start")
                .setSubText("Modtag M2")
                .setBgColor(Color.PINK)
                .setDescription("Start felt")
                .build();

        fields[1] = new Street.Builder()
                .setTitle("Burgerbaren")
                .setBgColor(Color.ORANGE)
                .setSubText("M1")
                //.setDescription(translate.t("field.tower.description"))
                .build();
        fields[2] = new Street.Builder()
                .setTitle("Pizzeriaet")
                .setBgColor(Color.ORANGE)
                .setSubText("M1")
                //.setDescription(translate.t("field.crater.description"))
                .build();
        fields[3] = new Street.Builder()
                .setTitle("Chance")
                .setBgColor(Color.WHITE)
                .setSubText("?")
                //.setDescription(translate.t("field.palace_gates.description"))
                .build();
        fields[4] = new Street.Builder()
                .setTitle("Slikbutikken")
                .setBgColor(Color.GRAY)
                .setSubText("M1")
                //.setDescription(translate.t("field.cold_desert.description"))
                .build();
        fields[5] = new Street.Builder()
                .setTitle("Iskiosken")
                .setBgColor(Color.GRAY)
                .setSubText("M1")
                //.setDescription(translate.t("field.walled_city.description"))
                .build();
        fields[6] = new Street.Builder()
                .setTitle("Fængsel")
                .setBgColor(Color.WHITE)
                .setSubText("På besøg")
                //.setDescription(translate.t("field.monastery.description"))
                .build();
        fields[7] = new Street.Builder()
                .setTitle("Museet")
                .setBgColor(Color.PINK)
                .setSubText("M2")
                //.setDescription(translate.t("field.black_cave.description"))
                .build();
        fields[8] = new Street.Builder()
                .setTitle("Biblioteket")
                .setBgColor(Color.PINK)
                .setSubText("M2")
                //.setDescription(translate.t("field.huts_in_the_mountain.description"))
                .build();
        fields[9] = new Street.Builder()
                .setTitle("Chance")
                .setBgColor(Color.WHITE)
                .setSubText("?")
                //.setDescription(translate.t("field.the_werewall.description"))
                .build();
        fields[10] = new Street.Builder()
                .setTitle("Skaterparken")
                .setBgColor(Color.YELLOW)
                .setSubText("M2")
                //.setDescription(translate.t("field.the_pit.description"))
                .build();
        fields[11] = new Street.Builder()
                .setTitle("Swimmingpoolen")
                .setBgColor(Color.YELLOW)
                .setSubText("M2")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[12] = new Street.Builder()
                .setTitle("Gratis parkering")
                .setBgColor(Color.WHITE)
                .setSubText("")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[13] = new Street.Builder()
                .setTitle("Spillehallen")
                .setBgColor(Color.RED)
                .setSubText("M3")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[14] = new Street.Builder()
                .setTitle("Biografen")
                .setBgColor(Color.RED)
                .setSubText("M3")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[15] = new Street.Builder()
                .setTitle("Chance")
                .setBgColor(Color.WHITE)
                .setSubText("?")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[16] = new Street.Builder()
                .setTitle("Legetøjsbutikken")
                .setBgColor(Color.YELLOW)
                .setSubText("M3")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[17] = new Street.Builder()
                .setTitle("Dyrehandlen")
                .setBgColor(Color.YELLOW)
                .setSubText("M3")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[18] = new Street.Builder()
                .setTitle("Gå i fængsel")
                .setBgColor(Color.WHITE)
                .setSubText("Gå i fængsel")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[19] = new Street.Builder()
                .setTitle("Bowlinghallen")
                .setBgColor(Color.GREEN)
                .setSubText("M4")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[20] = new Street.Builder()
                .setTitle("Zoo")
                .setBgColor(Color.GREEN)
                .setSubText("M4")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[21] = new Street.Builder()
                .setTitle("Chance")
                .setBgColor(Color.WHITE)
                .setSubText("?")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[22] = new Street.Builder()
                .setTitle("Vandlandet")
                .setBgColor(Color.BLUE)
                .setSubText("M5")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();
        fields[23] = new Street.Builder()
                .setTitle("Strandpromenaden")
                .setBgColor(Color.BLUE)
                .setSubText("M5")
                //.setDescription(translate.t("field.goldmine.description"))
                .build();

                GUI.create(fields);

    }
}