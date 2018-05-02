package com.valdioveliu.valdio.audioplayer.PitchesAndWords;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richard on 20.03.2018.
 */
public class MakePitchesList {


    String[] pitches;
    List<Pitch> listOfPitches = new ArrayList<Pitch>();

    public List<Pitch> getListOfPitches(){
        getPitches();
        for (String pitchString: pitches) {
            Pitch pitch = new Pitch();
            makeListOfPitches(pitch, pitchString);
        }
        return listOfPitches;
    }

    public void makeListOfPitches(Pitch pitch, String pitchString){
        pitch.setPitch(getPitchesInfo(pitchString, 1));
        pitch.setOccuranceTime(getPitchesInfo(pitchString, 0));
        listOfPitches.add(pitch);
    }


    public String[] getPitches() {
        pitches = pitchesRaw.split("\\r?\\n");
        return pitches;
    }

    private float getPitchesInfo(String pitch, int position){
        String[] frequencyAndTime = pitch.split("\\:");
        if(position == 0){
            return Float.parseFloat(frequencyAndTime[0].replace(',', '.'));
        }
        if(position == 1){
            return Float.parseFloat(frequencyAndTime[1].replace(',', '.'));
        }
        else return 0;
    }

    String pitchesRaw =
            "0,14:23281,61\n" +
            "0,23:53,65\n" +
            "0,37:72,53\n" +
            "0,56:86,09\n" +
            "0,60:88,58\n" +
            "0,65:87,45\n" +
            "0,70:87,11\n" +
            "0,74:89,56\n" +
            "0,79:96,22\n" +
            "0,84:23288,24\n" +
            "0,88:103,92\n" +
            "0,93:107,46\n" +
            "0,98:108,02\n" +
            "1,02:107,51\n" +
            "1,07:104,92\n" +
            "1,11:105,94\n" +
            "1,16:106,40\n" +
            "1,21:104,43\n" +
            "1,25:104,93\n" +
            "1,30:108,01\n" +
            "1,35:316,81\n" +
            "1,39:103,98\n" +
            "1,44:23297,42\n" +
            "1,49:23357,42\n" +
            "1,53:23359,74\n" +
            "1,58:23393,04\n" +
            "1,63:23244,18\n" +
            "1,67:23220,51\n" +
            "1,72:23250,06\n" +
            "1,76:23288,84\n" +
            "1,81:23241,81\n" +
            "1,86:23295,22\n" +
            "1,90:23268,04\n" +
            "1,95:23252,78\n" +
            "2,00:23224,22\n" +
            "2,04:23429,71\n" +
            "2,09:23214,58\n" +
            "2,14:23240,70\n" +
            "2,18:23237,71\n" +
            "2,23:23231,22\n" +
            "2,28:23222,77\n" +
            "2,32:23239,73\n" +
            "2,37:23235,98\n" +
            "2,41:23222,16\n" +
            "2,46:23224,01\n" +
            "2,51:23214,26\n" +
            "2,55:23223,20\n" +
            "2,60:23234,11\n" +
            "2,65:23221,65\n" +
            "2,69:23213,45\n" +
            "2,74:23217,44\n" +
            "2,79:23235,93\n" +
            "2,83:11122,79\n" +
            "2,88:23234,58\n" +
            "2,93:23229,52\n" +
            "2,97:23255,48\n" +
            "3,02:23254,44\n" +
            "3,07:23355,41\n" +
            "3,44:105,48\n" +
            "3,48:115,45\n" +
            "3,53:117,78\n" +
            "3,58:127,36\n" +
            "3,62:131,24\n" +
            "3,67:130,33\n" +
            "3,72:131,93\n" +
            "3,76:127,32\n" +
            "3,81:117,18\n" +
            "3,85:117,80\n" +
            "3,90:117,15\n" +
            "3,95:121,04\n" +
            "3,99:131,22\n" +
            "4,04:130,38\n" +
            "4,09:130,34\n" +
            "4,13:129,57\n" +
            "4,18:120,38\n" +
            "4,23:121,06\n" +
            "4,32:100,12\n" +
            "4,37:23483,16\n" +
            "4,41:112,95\n" +
            "4,46:23448,04\n" +
            "4,50:23396,09\n" +
            "4,55:23292,90\n" +
            "4,60:117,21\n" +
            "4,64:116,58\n" +
            "4,69:116,62\n" +
            "4,74:119,18\n" +
            "4,78:131,19\n" +
            "4,83:130,34\n" +
            "4,88:129,59\n" +
            "4,92:132,64\n" +
            "4,97:129,68\n" +
            "5,02:132,71\n" +
            "5,06:133,57\n" +
            "5,11:128,94\n" +
            "5,15:131,09\n" +
            "5,20:132,75\n" +
            "5,25:129,68\n" +
            "5,29:131,26\n" +
            "5,34:131,22\n" +
            "5,39:130,38\n" +
            "5,43:146,01\n" +
            "5,48:140,43\n" +
            "5,57:23450,16\n" +
            "5,62:130,46\n" +
            "5,67:132,02\n" +
            "5,71:23243,22\n" +
            "5,76:23456,28\n" +
            "5,85:23246,64\n" +
            "5,90:23274,97\n" +
            "5,94:23310,30\n" +
            "5,99:23229,71\n" +
            "6,08:23214,33\n" +
            "6,13:23221,53\n" +
            "6,18:23263,48\n" +
            "6,22:23213,17\n" +
            "6,27:23235,04\n" +
            "6,32:23222,02\n" +
            "6,36:23214,90\n" +
            "6,41:23230,05\n" +
            "6,46:23212,55\n" +
            "6,50:23221,33\n" +
            "6,55:23226,70\n" +
            "6,59:23217,07\n" +
            "6,64:23272,07\n" +
            "6,69:11102,74\n" +
            "6,73:23263,38\n" +
            "6,78:23217,53\n" +
            "6,97:23243,63\n" +
            "7,11:23214,11\n" +
            "7,15:23229,58\n" +
            "7,20:23225,70\n" +
            "7,24:23244,82\n" +
            "7,29:23243,09\n" +
            "7,34:23249,66\n" +
            "7,38:23226,67\n" +
            "7,43:23246,31\n" +
            "7,48:23258,55\n" +
            "7,52:23230,34\n" +
            "7,57:23225,60\n" +
            "7,62:23280,25\n" +
            "7,66:23238,08\n" +
            "7,71:23221,47\n" +
            "7,85:117,87\n" +
            "7,89:117,19\n" +
            "7,94:117,21\n" +
            "7,99:117,21\n" +
            "8,03:116,57\n" +
            "8,08:119,10\n" +
            "8,13:44,01\n" +
            "8,17:129,52\n" +
            "8,22:132,72\n" +
            "8,27:143,19\n" +
            "8,31:141,13\n" +
            "8,36:139,35\n" +
            "8,45:132,82\n" +
            "8,50:129,76\n" +
            "8,54:130,43\n" +
            "8,68:94,20\n" +
            "8,78:132,70\n" +
            "8,82:130,43\n" +
            "8,87:129,60\n" +
            "8,92:130,56\n" +
            "8,96:128,92\n" +
            "9,01:119,19\n" +
            "9,06:118,45\n" +
            "9,10:103,41\n" +
            "9,15:103,41\n" +
            "9,20:103,89\n" +
            "9,24:106,46\n" +
            "9,29:214,93\n" +
            "9,33:23427,95\n" +
            "9,38:23356,01\n" +
            "9,43:106,41\n" +
            "9,47:100,57\n" +
            "9,52:106,39\n" +
            "9,57:104,40\n" +
            "9,61:99,70\n" +
            "9,66:106,42\n" +
            "9,71:103,50\n" +
            "9,75:104,47\n" +
            "9,80:106,97\n" +
            "9,85:99,68\n" +
            "9,89:23454,22\n" +
            "9,94:23299,56\n" +
            "9,98:23275,30\n" +
            "10,03:23222,72\n" +
            "10,08:23246,09\n" +
            "10,12:23221,14\n" +
            "10,17:23240,54\n" +
            "10,22:23246,81\n" +
            "10,26:23224,74\n" +
            "10,31:23249,41\n" +
            "10,36:23214,79\n" +
            "10,40:23213,46\n" +
            "10,45:23259,51\n" +
            "10,50:23217,39\n" +
            "10,54:23215,36\n" +
            "10,59:23224,87\n" +
            "10,63:23242,27\n" +
            "10,68:23270,82\n" +
            "10,73:23243,19\n" +
            "10,77:23222,75\n" +
            "10,82:23268,78\n" +
            "10,87:23321,62\n" +
            "10,91:23259,65\n" +
            "11,05:23226,24\n" +
            "11,10:23222,92\n" +
            "11,15:23218,83\n" +
            "11,19:23211,71\n" +
            "11,24:11112,28\n" +
            "11,28:23261,03\n" +
            "11,33:23265,31\n" +
            "11,38:23245,92\n" +
            "11,42:57,09\n" +
            "11,61:103,45\n" +
            "11,66:103,91\n" +
            "11,70:102,02\n" +
            "11,75:107,96\n" +
            "11,80:105,43\n" +
            "11,84:104,46\n" +
            "11,89:116,64\n" +
            "11,94:115,99\n" +
            "11,98:114,77\n" +
            "12,03:121,72\n" +
            "12,07:123,16\n" +
            "12,12:125,12\n" +
            "12,17:128,85\n" +
            "12,21:120,37\n" +
            "12,26:116,52\n" +
            "12,31:130,55\n" +
            "12,35:131,06\n" +
            "12,40:131,89\n" +
            "12,45:128,88\n" +
            "12,49:23397,75\n" +
            "12,59:118,45\n" +
            "12,63:116,54\n" +
            "12,68:119,70\n" +
            "12,72:115,45\n" +
            "12,77:115,30\n" +
            "12,82:119,86\n" +
            "12,86:116,59\n" +
            "12,91:114,13\n" +
            "12,96:119,04\n" +
            "13,00:118,47\n" +
            "13,05:115,38\n" +
            "13,10:128,92\n" +
            "13,14:23376,55\n" +
            "13,19:23274,66\n" +
            "13,42:23251,56\n" +
            "13,47:23489,82\n" +
            "13,51:23344,61\n" +
            "13,56:23378,44\n" +
            "13,61:23246,47\n" +
            "13,65:23230,42\n" +
            "13,93:23252,82\n" +
            "13,98:23213,07\n" +
            "14,02:23214,84\n" +
            "14,07:11103,54\n" +
            "14,63:11128,77\n" +
            "14,72:23221,60\n" +
            "14,77:23232,20\n" +
            "14,81:23230,43\n" +
            "14,86:23214,80\n" +
            "14,91:23213,97\n" +
            "14,95:23227,10\n" +
            "15,00:23217,53\n" +
            "15,09:23252,50\n" +
            "15,14:11126,70\n" +
            "15,19:23219,86\n" +
            "15,23:23331,66\n" +
            "15,42:116,64\n" +
            "15,46:124,48\n" +
            "15,51:132,81\n" +
            "15,56:130,29\n" +
            "15,74:132,03\n" +
            "15,79:128,82\n" +
            "15,84:115,43\n" +
            "15,88:116,71\n" +
            "15,93:102,98\n" +
            "15,98:105,93\n" +
            "16,02:113,04\n" +
            "16,07:102,54\n" +
            "16,11:23255,43\n" +
            "16,16:23379,15\n" +
            "16,25:117,83\n" +
            "16,30:119,14\n" +
            "16,35:116,62\n" +
            "16,39:124,46\n" +
            "16,44:130,33\n" +
            "16,49:128,88\n" +
            "16,53:132,85\n" +
            "16,58:131,20\n" +
            "16,63:129,57\n" +
            "16,67:131,94\n" +
            "16,72:130,35\n" +
            "16,76:131,92\n" +
            "16,81:119,10\n" +
            "16,86:119,73\n" +
            "16,90:111,22\n" +
            "16,95:106,45\n" +
            "17,00:105,43\n" +
            "17,04:23360,68\n" +
            "17,09:23326,16\n" +
            "17,14:23233,81\n" +
            "17,18:23267,23\n" +
            "17,23:23278,08\n" +
            "17,28:23437,54\n" +
            "17,32:23307,65\n" +
            "17,37:23267,90\n" +
            "17,41:23256,09\n" +
            "17,46:23230,78\n" +
            "17,51:23244,80\n" +
            "17,55:23216,40\n" +
            "17,60:23215,01\n" +
            "17,65:23214,28\n" +
            "17,69:23229,33\n" +
            "17,74:23216,00\n" +
            "17,79:23226,55\n" +
            "17,83:23216,80\n" +
            "17,88:23233,67\n" +
            "17,93:23222,08\n" +
            "17,97:23263,27\n" +
            "18,02:23231,24\n" +
            "18,07:23226,94\n" +
            "18,11:23223,19\n" +
            "18,16:23254,43\n" +
            "18,20:23248,09\n" +
            "18,34:23286,10\n" +
            "18,53:23227,99\n" +
            "18,58:23258,46\n" +
            "18,62:23216,49\n" +
            "18,67:23274,78\n" +
            "18,95:23292,97\n" +
            "18,99:23393,46\n" +
            "19,04:74,48\n" +
            "19,18:142,11\n" +
            "19,23:139,52\n" +
            "19,27:141,22\n" +
            "19,32:155,14\n" +
            "19,37:153,17\n" +
            "19,41:156,29\n" +
            "19,46:156,19\n" +
            "19,50:154,13\n" +
            "19,55:157,41\n" +
            "19,60:155,05\n" +
            "19,64:154,31\n" +
            "19,69:156,34\n" +
            "19,74:156,21\n" +
            "19,78:132,70\n" +
            "19,83:133,50\n" +
            "20,11:116,55\n" +
            "20,15:100,66\n" +
            "20,20:103,90\n" +
            "20,25:103,47\n" +
            "20,29:102,92\n" +
            "20,34:104,49\n" +
            "20,39:109,65\n" +
            "20,43:105,94\n" +
            "20,48:103,97\n" +
            "20,53:106,44\n" +
            "20,57:104,44\n" +
            "20,62:104,46\n" +
            "20,67:23324,48\n" +
            "20,71:23337,59\n" +
            "21,04:107,51\n" +
            "21,08:103,47\n" +
            "21,13:107,03\n" +
            "21,22:23322,14\n" +
            "21,32:23386,30\n" +
            "21,36:23235,78\n" +
            "21,41:23242,06\n" +
            "21,46:23287,61\n" +
            "21,50:23264,78\n" +
            "21,55:23223,80\n" +
            "21,59:23241,07\n" +
            "21,64:23223,09\n" +
            "21,69:23272,33\n" +
            "21,73:23227,73\n" +
            "21,78:23213,38\n" +
            "21,83:23212,92\n" +
            "21,87:23216,29\n" +
            "21,92:23243,09\n" +
            "21,97:11112,14\n" +
            "22,01:23249,22\n" +
            "22,06:23220,27\n" +
            "22,29:23223,00\n" +
            "22,34:23248,48\n" +
            "22,38:23294,26\n" +
            "22,43:23228,62\n" +
            "22,48:23279,21\n" +
            "22,52:11113,77\n" +
            "22,57:86,81\n" +
            "22,62:23247,79\n" +
            "22,71:23233,06\n" +
            "22,76:23443,76\n" +
            "22,80:285,63\n" +
            "22,99:98,53\n" +
            "23,03:102,15\n" +
            "23,13:103,01\n" +
            "23,17:102,03\n" +
            "23,27:117,25\n" +
            "23,31:114,13\n" +
            "23,36:121,71\n" +
            "23,45:104,98\n" +
            "23,59:128,14\n" +
            "23,64:130,38\n" +
            "23,68:136,06\n" +
            "23,73:136,96\n" +
            "23,78:23419,53\n" +
            "23,82:23429,37\n" +
            "23,87:123,85\n" +
            "23,92:130,43\n" +
            "23,96:131,85\n" +
            "24,01:137,71\n" +
            "24,06:138,63\n" +
            "24,10:133,61\n" +
            "24,15:138,52\n" +
            "24,20:137,75\n" +
            "24,24:135,15\n" +
            "24,29:139,44\n" +
            "24,33:138,58\n" +
            "24,38:137,72\n" +
            "24,43:139,48\n" +
            "24,47:135,17\n" +
            "24,52:136,92\n" +
            "24,57:141,13\n" +
            "24,61:137,75\n" +
            "24,66:138,60\n" +
            "24,71:142,10\n" +
            "24,75:144,10\n" +
            "24,80:135,16\n" +
            "24,85:271,49\n" +
            "24,89:133,57\n" +
            "24,94:131,18\n" +
            "24,98:131,20\n" +
            "25,03:130,54\n" +
            "25,08:130,38\n" +
            "25,12:131,90\n" +
            "25,17:130,37\n" +
            "25,22:117,77\n" +
            "25,26:117,14\n" +
            "25,31:119,08\n" +
            "25,36:117,14\n" +
            "25,40:118,51\n" +
            "25,45:23361,31\n" +
            "25,50:122,36\n" +
            "25,77:131,91\n" +
            "25,82:121,68\n" +
            "25,87:119,07\n" +
            "25,91:99,90\n" +
            "25,96:99,67\n" +
            "26,01:109,59\n" +
            "26,05:105,41\n" +
            "26,10:104,94\n" +
            "26,15:105,47\n" +
            "26,19:106,97\n" +
            "26,24:23232,66\n" +
            "26,28:23224,24\n" +
            "26,61:23316,61\n" +
            "26,66:23220,58\n" +
            "26,70:23225,89\n" +
            "26,75:80,41\n" +
            "26,80:91,08\n" +
            "26,84:96,61\n" +
            "26,89:99,83\n" +
            "26,94:105,95\n" +
            "26,98:105,93\n" +
            "27,03:109,64\n" +
            "27,07:119,03\n" +
            "27,12:123,12\n" +
            "27,17:23572,52\n" +
            "27,40:119,05\n" +
            "27,45:121,66\n" +
            "27,49:132,67\n" +
            "27,54:130,33\n" +
            "27,59:136,81\n" +
            "27,63:23263,40\n" +
            "27,68:23260,71\n" +
            "27,72:106,48\n" +
            "27,77:105,42\n" +
            "27,82:105,95\n" +
            "27,91:117,82\n" +
            "27,96:114,79\n" +
            "28,00:118,45\n" +
            "28,05:119,07\n" +
            "28,10:114,78\n" +
            "28,14:116,00\n" +
            "28,19:119,12\n" +
            "28,24:116,00\n" +
            "28,28:114,81\n" +
            "28,33:119,78\n" +
            "28,37:116,63\n" +
            "28,42:114,77\n" +
            "28,47:117,87\n" +
            "28,51:117,86\n" +
            "28,56:116,00\n" +
            "28,61:117,18\n" +
            "28,65:117,19\n" +
            "28,70:117,86\n" +
            "28,79:104,51\n" +
            "28,84:104,46\n" +
            "28,89:103,42\n" +
            "28,93:109,08\n" +
            "28,98:119,81\n" +
            "29,02:116,00\n" +
            "29,12:130,48\n" +
            "29,16:129,56\n" +
            "29,21:133,51\n" +
            "29,26:131,06\n" +
            "29,54:111,87\n" +
            "29,58:149,94\n" +
            "29,63:136,81\n" +
            "29,68:141,25\n" +
            "29,72:153,97\n" +
            "29,77:153,11\n" +
            "29,81:156,35\n" +
            "29,86:164,30\n" +
            "29,91:156,24\n" +
            "29,95:152,91\n" +
            "30,00:158,55\n" +
            "30,05:154,33\n" +
            "30,14:23439,32\n" +
            "30,28:156,24\n" +
            "30,33:154,14\n" +
            "30,56:156,28\n" +
            "30,60:156,14\n" +
            "30,65:162,34\n" +
            "30,70:176,51\n" +
            "30,74:173,63\n" +
            "30,93:135,92\n" +
            "30,98:117,78\n" +
            "31,02:117,79\n" +
            "31,07:125,15\n" +
            "31,11:125,95\n" +
            "31,16:123,14\n" +
            "31,21:23497,95\n" +
            "31,25:127,44\n" +
            "31,49:118,48\n" +
            "31,53:119,05\n" +
            "31,58:121,78\n" +
            "31,63:132,86\n" +
            "31,67:129,59\n" +
            "31,72:129,65\n" +
            "31,76:133,50\n" +
            "31,81:130,33\n" +
            "31,86:129,65\n" +
            "31,90:135,09\n" +
            "31,95:131,06\n" +
            "32,00:131,08\n" +
            "32,04:133,50\n" +
            "32,09:131,89\n" +
            "32,14:129,64\n" +
            "32,18:132,70\n" +
            "32,23:132,64\n" +
            "32,28:126,67\n" +
            "32,32:116,64\n" +
            "32,37:117,17\n" +
            "32,42:118,41\n" +
            "32,46:118,42\n" +
            "32,51:116,60\n" +
            "32,55:123,12\n" +
            "32,60:132,09\n" +
            "32,65:130,32\n" +
            "32,69:129,55\n" +
            "32,74:132,67\n" +
            "32,79:131,88\n" +
            "32,83:128,81\n" +
            "32,88:131,11\n" +
            "32,93:134,29\n" +
            "32,97:131,84\n" +
            "33,02:129,59\n" +
            "33,07:131,13\n" +
            "33,11:131,23\n" +
            "33,16:132,77\n" +
            "33,20:125,95\n" +
            "33,25:117,18\n" +
            "33,30:123,80\n" +
            "33,34:121,76\n" +
            "33,39:117,13\n" +
            "33,44:117,15\n" +
            "33,48:130,31\n" +
            "33,53:136,83\n" +
            "33,58:131,89\n" +
            "33,62:138,61\n" +
            "33,67:23391,73\n" +
            "33,72:23267,53\n" +
            "33,76:23313,09\n" +
            "33,81:23239,96\n" +
            "33,85:23243,04\n" +
            "33,90:23254,79\n" +
            "33,95:23272,63\n" +
            "34,18:23363,32\n" +
            "34,23:23274,59\n" +
            "34,27:23217,47\n" +
            "34,32:23421,38\n" +
            "34,37:124,44\n" +
            "34,41:121,66\n" +
            "34,46:132,68\n" +
            "34,50:131,84\n" +
            "34,55:23321,43\n" +
            "34,60:23436,93\n" +
            "34,64:131,93\n" +
            "34,69:131,16\n" +
            "34,74:116,02\n" +
            "34,78:119,73\n" +
            "34,83:103,46\n" +
            "34,88:104,47\n" +
            "34,92:103,90\n" +
            "34,97:104,89\n" +
            "35,02:105,99\n" +
            "35,06:103,01\n" +
            "35,11:23515,10\n" +
            "35,16:23476,61\n" +
            "35,20:23275,18\n" +
            "35,25:23407,24\n" +
            "35,29:107,99\n" +
            "35,34:121,70\n" +
            "35,39:118,47\n" +
            "35,43:124,42\n" +
            "35,48:132,74\n" +
            "35,53:129,63\n" +
            "35,57:128,80\n" +
            "35,62:134,28\n" +
            "35,67:132,68\n" +
            "35,71:131,85\n" +
            "35,76:132,74\n" +
            "35,81:131,85\n" +
            "35,85:131,13\n" +
            "35,90:135,98\n" +
            "35,94:132,68\n" +
            "35,99:131,06\n" +
            "36,04:132,71\n" +
            "36,08:126,65\n" +
            "36,13:114,22\n" +
            "36,18:117,21\n" +
            "36,22:118,50\n" +
            "36,27:121,68\n" +
            "36,32:117,19\n" +
            "36,36:118,45\n" +
            "36,41:128,78\n" +
            "36,46:131,87\n" +
            "36,50:129,57\n" +
            "36,55:132,72\n" +
            "36,59:131,92\n" +
            "36,64:130,40\n" +
            "36,69:134,29\n" +
            "36,73:130,39\n" +
            "36,78:130,35\n" +
            "36,83:132,78\n" +
            "36,87:132,66\n" +
            "36,92:134,28\n" +
            "36,97:23409,39\n" +
            "37,01:23348,57\n" +
            "37,06:23327,69\n" +
            "37,11:23235,92\n" +
            "37,15:23245,72\n" +
            "37,20:121,68\n" +
            "37,24:119,03\n" +
            "37,29:123,75\n" +
            "37,34:133,49\n" +
            "37,38:130,33\n" +
            "37,43:129,63\n" +
            "37,52:23445,11\n" +
            "37,71:23364,79\n" +
            "37,80:23373,94\n" +
            "38,03:23301,54\n" +
            "38,13:119,81\n" +
            "38,17:117,77\n" +
            "38,22:125,30\n" +
            "38,27:133,61\n" +
            "38,31:129,56\n" +
            "38,36:131,06\n" +
            "38,41:23506,00\n" +
            "38,45:23512,42\n" +
            "38,50:120,39\n" +
            "38,55:119,10\n" +
            "38,64:99,67\n" +
            "38,68:102,99\n" +
            "38,73:104,41\n" +
            "38,78:104,92\n" +
            "38,82:104,46\n" +
            "38,87:104,90\n" +
            "38,92:23289,69\n" +
            "38,96:23219,95\n" +
            "39,01:23234,57\n" +
            "39,10:115,42\n" +
            "39,15:126,60\n" +
            "39,20:130,43\n" +
            "39,24:132,80\n" +
            "39,29:139,67\n" +
            "39,33:138,53\n" +
            "39,38:133,60\n" +
            "39,43:138,59\n" +
            "39,47:138,61\n" +
            "39,52:136,12\n" +
            "39,57:140,45\n" +
            "39,61:139,38\n" +
            "39,66:137,85\n" +
            "39,71:139,47\n" +
            "39,75:138,49\n" +
            "39,80:140,33\n" +
            "39,85:129,70\n" +
            "39,89:23264,52\n" +
            "39,94:23254,48\n" +
            "40,03:125,92\n" +
            "40,08:119,25\n" +
            "40,12:117,77\n" +
            "40,17:128,83\n" +
            "40,22:137,87\n" +
            "40,26:129,53\n" +
            "40,31:129,71\n" +
            "40,36:130,53\n" +
            "40,40:136,86\n" +
            "40,45:136,96\n" +
            "40,50:138,50\n" +
            "40,54:120,35\n" +
            "40,59:125,97\n" +
            "40,63:116,01\n" +
            "40,68:108,06\n" +
            "40,73:109,66\n" +
            "40,77:109,07\n" +
            "40,82:107,50\n" +
            "40,87:108,07\n" +
            "40,91:108,53\n" +
            "40,96:108,00\n" +
            "41,01:104,41\n" +
            "41,05:104,43\n" +
            "41,10:105,47\n" +
            "41,15:105,40\n" +
            "41,19:103,41\n" +
            "41,24:107,44\n" +
            "41,29:106,44\n" +
            "41,33:101,56\n" +
            "41,38:23322,58\n" +
            "41,42:23264,08\n" +
            "41,47:23223,64\n" +
            "41,52:23256,89\n" +
            "41,56:23459,20\n" +
            "41,61:23264,43\n" +
            "41,66:23400,68\n" +
            "41,70:23471,37\n" +
            "41,75:23236,36\n" +
            "41,80:23218,31\n" +
            "41,84:23272,22\n" +
            "41,89:85,42\n" +
            "41,94:84,73\n" +
            "41,98:80,70\n" +
            "42,03:80,16\n" +
            "42,07:23474,91\n" +
            "42,12:81,64\n" +
            "42,17:23439,39\n" +
            "42,21:23510,48\n" +
            "42,26:79,88\n" +
            "42,31:23294,24\n" +
            "42,35:23404,26\n" +
            "42,40:23466,70\n" +
            "42,45:88,90\n" +
            "42,49:91,10\n" +
            "42,86:23302,21\n" +
            "42,91:116,53\n" +
            "42,96:117,76\n" +
            "43,00:116,54\n" +
            "43,05:128,26\n" +
            "43,10:132,01\n" +
            "43,14:128,82\n" +
            "43,19:131,95\n" +
            "43,24:132,00\n" +
            "43,28:131,09\n" +
            "43,33:133,53\n" +
            "43,37:131,86\n" +
            "43,42:129,69\n" +
            "43,47:134,33\n" +
            "43,51:131,93\n" +
            "43,56:131,16\n" +
            "43,61:131,98\n" +
            "43,65:130,31\n" +
            "43,70:130,54\n" +
            "43,75:131,87\n" +
            "43,79:130,44\n" +
            "43,84:130,44\n" +
            "43,89:131,16\n" +
            "43,93:131,11\n" +
            "43,98:130,39\n" +
            "44,03:131,30\n" +
            "44,07:131,21\n" +
            "44,12:130,33\n" +
            "44,16:131,09\n" +
            "44,21:137,67\n" +
            "44,26:140,40\n" +
            "44,30:137,78\n" +
            "44,35:139,43\n" +
            "44,40:136,07\n" +
            "44,44:131,92\n" +
            "44,49:132,71\n" +
            "44,54:129,60\n" +
            "44,63:44,72\n" +
            "44,68:179,04\n" +
            "44,77:119,85\n" +
            "44,81:116,56\n" +
            "44,86:117,81\n" +
            "44,91:117,82\n" +
            "44,95:114,18\n" +
            "45,00:117,21\n" +
            "45,05:23482,44\n" +
            "45,09:23302,28\n" +
            "45,14:23397,39\n" +
            "45,19:23379,75\n" +
            "45,51:23252,22\n" +
            "45,56:23438,57\n" +
            "45,60:23278,23\n" +
            "45,70:120,37\n" +
            "45,74:117,79\n" +
            "45,79:119,03\n" +
            "45,84:132,69\n" +
            "45,88:131,87\n" +
            "45,93:130,40\n" +
            "45,98:131,99\n" +
            "46,02:131,86\n" +
            "46,07:126,66\n" +
            "46,11:117,22\n" +
            "46,16:23507,84\n" +
            "46,21:103,43\n" +
            "46,25:112,46\n" +
            "46,30:113,58\n" +
            "46,67:119,17\n" +
            "46,72:117,29\n" +
            "46,76:117,81\n" +
            "46,81:130,41\n" +
            "46,86:129,58\n" +
            "46,90:129,61\n" +
            "46,95:133,66\n" +
            "47,00:131,17\n" +
            "47,04:129,67\n" +
            "47,09:133,52\n" +
            "47,14:129,57\n" +
            "47,18:131,14\n" +
            "47,42:117,76\n" +
            "47,46:125,84\n" +
            "47,51:131,88\n" +
            "47,55:130,36\n" +
            "47,60:119,04\n" +
            "47,65:116,62\n" +
            "47,69:125,18\n" +
            "47,74:131,93\n" +
            "47,79:128,16\n" +
            "47,83:132,72\n" +
            "47,88:131,93\n" +
            "47,93:128,90\n" +
            "47,97:133,57\n" +
            "48,02:129,60\n" +
            "48,07:130,33\n" +
            "48,11:132,12\n" +
            "48,34:117,14\n" +
            "48,39:116,75\n" +
            "48,44:117,30\n" +
            "48,48:117,20\n" +
            "48,53:116,52\n" +
            "48,58:119,07\n" +
            "48,62:118,49\n" +
            "48,67:46,03\n" +
            "48,72:23264,74\n" +
            "48,76:23274,37\n" +
            "48,81:23271,18\n" +
            "48,85:23250,33\n" +
            "48,90:23236,41\n" +
            "48,95:23226,71\n" +
            "48,99:23221,07\n" +
            "49,04:23410,75\n" +
            "49,32:23286,86\n" +
            "49,37:23266,54\n" +
            "49,46:117,83\n" +
            "49,50:116,65\n" +
            "49,55:126,67\n" +
            "49,60:131,16\n" +
            "49,64:129,53\n" +
            "49,69:132,69\n" +
            "49,74:120,38\n" +
            "49,78:127,34\n" +
            "49,83:126,60\n" +
            "49,88:117,21\n" +
            "49,92:114,18\n" +
            "49,97:104,41\n" +
            "50,02:104,93\n" +
            "50,06:104,42\n" +
            "50,11:23376,71\n" +
            "50,16:104,43\n" +
            "50,20:104,41\n" +
            "50,43:118,51\n" +
            "50,48:117,91\n" +
            "50,53:115,93\n" +
            "50,57:128,18\n" +
            "50,62:132,67\n" +
            "50,67:128,08\n" +
            "50,71:135,10\n" +
            "50,76:134,33\n" +
            "50,81:129,56\n" +
            "50,85:133,51\n" +
            "50,90:134,30\n" +
            "50,94:130,30\n" +
            "50,99:131,06\n" +
            "51,04:131,08\n" +
            "51,08:131,86\n" +
            "51,13:133,50\n" +
            "51,18:123,78\n" +
            "51,22:121,73\n" +
            "51,27:121,11\n" +
            "51,32:117,79\n" +
            "51,36:117,19\n" +
            "51,41:117,20\n" +
            "51,46:121,06\n" +
            "51,50:131,18\n" +
            "51,55:129,69\n" +
            "51,59:128,81\n" +
            "51,64:133,53\n" +
            "51,69:131,91\n" +
            "51,73:130,40\n" +
            "51,78:133,57\n" +
            "51,83:132,66\n" +
            "51,87:129,63\n" +
            "51,92:131,07\n" +
            "51,97:131,88\n" +
            "52,01:131,91\n" +
            "52,06:132,71\n" +
            "52,11:131,95\n" +
            "52,15:123,81\n" +
            "52,20:117,84\n" +
            "52,24:117,18\n" +
            "52,29:117,13\n" +
            "52,34:117,77\n" +
            "52,38:123,11\n" +
            "52,43:136,05\n" +
            "52,48:23401,04\n" +
            "52,52:23440,95\n" +
            "52,57:23260,72\n" +
            "52,62:23260,77\n" +
            "52,66:23239,96\n" +
            "52,71:23242,98\n" +
            "52,76:23226,05\n" +
            "52,80:23229,74\n" +
            "52,85:23248,85\n" +
            "52,90:23442,51\n" +
            "53,17:23324,63\n" +
            "53,22:23336,60\n" +
            "53,31:124,44\n" +
            "53,36:124,46\n" +
            "53,41:131,29\n" +
            "53,45:131,88\n" +
            "53,50:140,96\n" +
            "53,55:23451,23\n" +
            "53,64:126,55\n" +
            "53,68:119,04\n" +
            "53,73:123,84\n" +
            "53,78:102,49\n" +
            "53,82:110,22\n" +
            "53,87:110,21\n" +
            "53,92:108,59\n" +
            "53,96:103,97\n" +
            "54,01:106,99\n" +
            "54,06:103,92\n" +
            "54,10:105,40\n" +
            "54,29:128,04\n" +
            "54,33:128,88\n" +
            "54,38:134,42\n" +
            "54,43:140,26\n" +
            "54,47:135,14\n" +
            "54,52:140,46\n" +
            "54,57:140,24\n" +
            "54,61:137,62\n" +
            "54,66:142,99\n" +
            "54,71:140,34\n" +
            "54,75:138,52\n" +
            "54,80:139,51\n" +
            "54,85:138,65\n" +
            "54,89:137,71\n" +
            "54,94:138,61\n" +
            "54,98:138,67\n" +
            "55,17:121,69\n" +
            "55,22:116,52\n" +
            "55,26:119,09\n" +
            "55,31:129,53\n" +
            "55,36:131,84\n" +
            "55,40:131,87\n" +
            "55,45:132,65\n" +
            "55,50:131,09\n" +
            "55,54:131,11\n" +
            "55,59:132,63\n" +
            "55,64:124,42\n" +
            "55,68:121,69\n" +
            "55,73:116,58\n" +
            "55,77:104,89\n" +
            "55,82:23557,18\n" +
            "55,87:102,45\n" +
            "55,91:23310,91\n" +
            "55,96:23467,09\n" +
            "56,01:23444,57\n" +
            "56,05:144,95\n" +
            "56,10:151,99\n" +
            "56,15:102,96\n" +
            "56,19:101,60\n" +
            "56,24:101,05\n" +
            "56,29:105,45\n" +
            "56,33:23548,98\n" +
            "56,38:101,05\n" +
            "56,42:23366,70\n" +
            "56,47:23261,14\n" +
            "56,52:23260,03\n" +
            "56,56:23237,43\n" +
            "56,61:23249,25\n" +
            "56,66:23218,32\n" +
            "56,70:23236,17\n" +
            "56,75:23291,37\n" +
            "56,80:23219,29\n" +
            "56,84:23279,94\n" +
            "56,89:23228,32\n" +
            "56,94:23211,26\n" +
            "56,98:23291,49\n" +
            "57,03:90,65\n" +
            "57,07:83,76\n" +
            "57,12:23539,63\n" +
            "57,17:23371,33\n" +
            "57,21:23520,04\n" +
            "57,26:23331,44\n" +
            "57,31:23276,23\n" +
            "57,35:90,31\n" +
            "57,40:104,02\n" +
            "57,45:104,43\n" +
            "57,49:109,12\n" +
            "57,54:117,78\n" +
            "57,59:116,52\n" +
            "57,63:117,77\n" +
            "57,68:109,57\n" +
            "57,72:104,43\n" +
            "57,77:104,90\n" +
            "57,82:102,97\n" +
            "57,86:112,58\n" +
            "57,91:116,54\n" +
            "57,96:115,34\n" +
            "58,00:119,12\n" +
            "58,05:117,85\n" +
            "58,10:114,77\n" +
            "58,14:119,13\n" +
            "58,19:117,82\n" +
            "58,24:115,35\n" +
            "58,28:119,13\n" +
            "58,33:119,16\n" +
            "58,37:113,63\n" +
            "58,42:117,84\n" +
            "58,47:127,46\n" +
            "58,51:23381,24\n" +
            "58,56:23302,04\n" +
            "58,61:128,82\n" +
            "58,75:23330,42\n" +
            "58,79:23279,46\n" +
            "58,84:23270,22\n" +
            "58,89:23225,67\n" +
            "58,93:23241,90\n" +
            "58,98:23367,98\n" +
            "59,03:23256,71\n" +
            "59,16:23288,96\n" +
            "59,21:23220,96\n" +
            "59,26:23291,46\n" +
            "59,30:23224,04\n" +
            "59,35:23435,09\n" +
            "59,40:23417,60\n";
}