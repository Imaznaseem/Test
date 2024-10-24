package com.example.Cariogram_Backend.Services;

import java.util.ArrayList;
import java.util.List;


/*
 * Cariogram java version by:
 * Johan Börjesson, Lisa Berglund & Stefan Gustavsson
 * Date: 2011-06-01
 * Copyright Malmö Högskola 2011
 */
public class Advice0020 {
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cariogram/Bundle"); // NOI18N
    //Fields-------------------------------------------------
    //InputValues
    private int p1;
    private int p2;
    private int p3;//DIET,CONTENTS(p3)
    private int p4;//DIET,FREQUENCY(p4)
    private int p5;//BACTERIA,AMOUNT(p5)
    private int p6;//MUTANS STREPTOCOCCI(p6)
    private int p7;//FLUORIDE PROGRAM(p7)
    private int p8;//SALIVA SECRETION(p8)
    private int p9;//SALIVA BUFFER CAPACITY(p9)
    private int p10;//CLINICAL JUDGEMENT(p10)

    //Strings
    //Container for strings
    private List<String> memo;
    int temp;
    //Example String Memo11 = property.CH0020_Memo11
    private String Memo11;
    private String Memo12;
    private String Memo13;
    private String Memo14;
    private String Memo82;
    private String Memo81;
    private String Memo72;
    private String Memo71;
    private String Memo63;
    private String Memo62;
    private String Memo61;
    private String Memo55;
    private String Memo54;
    private String Memo53;
    private String Memo52;
    private String Memo51;
    private String Memo44;
    private String Memo43;
    private String Memo42;
    private String Memo41;
    private String Memo34;
    private String Memo33;
    private String Memo32;
    private String Memo31;
    private String Memo21;
    private String Memo91;


    Advice0020(String[] input)
    {
        p1 = ConvertToInteger(input[0]);
        p2 = ConvertToInteger(input[1]);
        p3 = ConvertToInteger(input[2]);
        p4 = ConvertToInteger(input[3]);
        p5 = ConvertToInteger(input[4]);
        p6 = ConvertToInteger(input[5]);
        p7 = ConvertToInteger(input[6]);
        p8 = ConvertToInteger(input[7]);
        p9 = ConvertToInteger(input[8]);
        p10 = ConvertToInteger(input[9]);

        memo = new ArrayList<String>();
        temp = 0;// equal to dummy from original code

        Memo11 = bundle.getString("CH0020_Memo11");
        Memo12 = bundle.getString("CH0020_Memo12");
        Memo13 = bundle.getString("CH0020_Memo13");
        Memo14 = bundle.getString("CH0020_Memo14");
        Memo21 = bundle.getString("CH0020_Memo21");
        Memo31 = bundle.getString("CH0020_Memo31");
        Memo32 = bundle.getString("CH0020_Memo32");
        Memo33 = bundle.getString("CH0020_Memo33");
        Memo34 = bundle.getString("CH0020_Memo34");
        Memo41 = bundle.getString("CH0020_Memo41");
        Memo42 = bundle.getString("CH0020_Memo42");
        Memo43 = bundle.getString("CH0020_Memo43");
        Memo44 = bundle.getString("CH0020_Memo44");
        Memo51 = bundle.getString("CH0020_Memo51");
        Memo52 = bundle.getString("CH0020_Memo52");
        Memo53 = bundle.getString("CH0020_Memo52");
        Memo54 = bundle.getString("CH0020_Memo54");
        Memo55 = bundle.getString("CH0020_Memo55");
        Memo61 = bundle.getString("CH0020_Memo61");
        Memo62 = bundle.getString("CH0020_Memo62");
        Memo63 = bundle.getString("CH0020_Memo63");
        Memo71 = bundle.getString("CH0020_Memo71");
        Memo72 = bundle.getString("CH0020_Memo72");
        Memo81 = bundle.getString("CH0020_Memo81");
        Memo82 = bundle.getString("CH0020_Memo82");
        Memo91 = bundle.getString("CH0020_Memo91");

    }

    /*
     * Checks for empty input
     * If in string is an number convert to int
     */
    private int ConvertToInteger(String strToConvert)
    {
        int i = 0;
        try
        {
            i = Integer.parseInt(strToConvert);
        }
        catch (Exception e)
        {
            i = 9;
        }
        return i;
    }

    /*
     * set advices and return
     * List of Strings
     */
    public List procedure()
    {
        memo = new ArrayList<String>();

        //{SALIVA SECRETION(p8) och FLUORIDE PROGRAM(p7)}----------------------
        //if  (p8=3) and  (p7=3)  then minmemo  := memo11 else
        if ((p8 == 3)&&(p7 == 3))
        {
            memo.add(Memo11);

        }
        else
        {
            //if ((p8=3) and ((p7=0) or(p7=1)  or(p7=2) or (p7=9)))
            if ((p8 == 3)&&(p7 == 0 || p7 == 1 || p7 == 2 || p7 == 9))
            {
                //then minmemo  := memo12 else
                memo.add(Memo12);
            }
            else
            {
                //if ((p7=3) and ((p8=0) or (p8=1) or(p8=2) or (p8=9)))
                if ((p7 == 3)&&(p8 == 0 || p8 == 1 || p8 == 2 || p8 == 9))
                {
                    //then minmemo  := memo13 else
                    memo.add(Memo13);
                }
                else
                {
                    //minmemo  := memo14;
                    memo.add(Memo14);
                }
            }
        }

        //{FAST TEXT}
        //minmemo := memo21;
        //InMemo.Lines.Add(' ');
        memo.add(Memo21);

        //{DIET,CONTENTS(p3) och DIET,FREQUENCY(p4)}----------------------
        //if ((p3=0) and (p4<2)) or ((p3=1) and (p4<2))
        if (((p3 == 0)&&(p4 < 2))||((p3 == 1)&&(p4 < 2)))
        {
            //then dummy := 1 else
            temp = 1;
        }
        else
        {
            //if ((p3=2) or (p3=3)) and ((p4=2) or (p4=3))
            if (((p3 == 2)||(p3 == 3))&&((p4 == 2)||(p4 == 3)))
            {
                //then minmemo  := memo31 else
                memo.add(Memo31);
            }
            else
            {
                //if ((p3=2) or (p3=3)) and ((p4=0) or (p4=1)) then
                if(((p3 == 2)||(p3 == 3))&&((p4 == 0)||(p4 == 1)))
                {
                    //minmemo  := memo32 else
                    memo.add(Memo32);
                }
                else
                {
                    //if ((p4=2) or (p4=3)) and ((p3=0) or (p3=1)) then
                    if(((p4 == 2)||(p4 == 3))&&((p3 == 0)||(p3 == 1)))
                    {
                        //minmemo  := memo33 else
                        memo.add(Memo33);
                    }
                    else
                    {
                        //if ((p3=9) or (p4=9)) then minmemo  := memo34;
                        if ((p3 == 9)||(p4  == 9))
                        {
                            memo.add(Memo34);
                        }
                    }
                }
            }
        }


        //{BACTERIA,AMOUNT(p5) och MUTANS STREPTOCOCCI(p6)}--------------
        //if ((p5=0) and (p6<2)) or ((p5=1) and (p6<2)) then
        if(((p5 == 0)&&(p6 < 2))||((p5 == 1)&&(p6 < 2)))
        {
            //dummy := 1 else
            temp = 1;
        }
        else
        {
            //if ((p5=2) or(p5=3)) and ((p6=2) or (p6=3)) then
            if (((p5 == 2)||(p5 == 3))&&((p6 == 2)||(p6 == 3)))
            {
                //minmemo  := memo41 else
                memo.add(Memo41);
            }
            else
            {
                //if ((p5=2) or(p5=3)) and ((p6=0) or (p6=1)) then
                if(((p5 == 2)||(p5 == 3))&&((p6 == 0)||(p6 == 1)))
                {
                    //minmemo  := memo42 else
                    memo.add(Memo42);
                }
                else
                {
                    //if ((p6=2) or (p6=3))and ((p5=0) or (p5=1)) then
                    if (((p6 == 2)||(p6 == 3))&&((p5 == 0)||(p5 == 1)))
                    {
                        //minmemo  := memo43 else
                        memo.add(Memo43);
                    }
                    else
                    {
                        //if  (p6=9) or (p5=9) then
                        if ((p6 == 9)||(p5 == 9))
                        {
                            //minmemo  := memo44;
                            memo.add(Memo44);
                        }
                    }
                }
            }
        }

        //{FLUORIDE PROGRAM(p7)}--------------------------------------
        //if (p7=3) then
        if (p7 == 3)
        {
            //minmemo  := memo51 else
            memo.add(Memo51);
        }
        else
        {
            //if (p7=2) then
            if (p7 == 2)
            {
                //minmemo  := memo52 else
                memo.add(Memo52);
            }
            else
            {
                //if (p7=1) then
                if(p7 == 1)
                {
                    //minmemo  := memo53 else
                    memo.add(Memo53);
                }
                else
                {
                    //if (p7=0)
                    if (p7 == 0)
                    {
                        //then minmemo  := memo54 else
                        memo.add(Memo54);
                    }
                    else
                    {
                        //if (p7=9) then minmemo  := memo55;
                        if (p7 == 9)
                        {
                            memo.add(Memo55);
                        }
                    }
                }
            }
        }


        //{SALIVA SECRETION(p8)}----------------------------------
        //if (p8>0) then   {  (p8=0) skall ej ge någon utskrift;  }
        if (p8 > 0)
        {
            //if (p8=2) or (p8=3) then
            if (p8 == 2 || p8 == 3)
            {
                //minmemo  := memo61 else
                memo.add(Memo61);
            }
            else
            {
                //if (p8=1) then minmemo  := memo62 else
                if(p8 == 1)
                {
                    //minmemo  := memo62 else
                    memo.add(Memo62);
                }
                else
                {
                    //if (p8=9) then
                    if(p8 == 9)
                    {
                        //minmemo  := memo63;
                        memo.add(Memo63);
                    }
                }
            }
        }

        //{SALIVA BUFFER CAPACITY(p9)}------------------------------------
        //if (p9>0) then     {  (p9=0) skall ej ge någon utskrift;  }
        if(p9 > 0)
        {
            //if (p9=1) or (p9=2) then
            if(p9 == 1 || p9 == 2)
            {
                //minmemo  := memo71 else
                memo.add(Memo71);
            }
            else
            {
                //if (p9=9)           then
                if(p9 == 9)
                {
                    //minmemo  := memo72;
                    memo.add(Memo72);
                }
            }
        }

        //{CLINICAL JUDGEMENT(p10)}------------------------------------------
        //if (p10=0) or (p10=1) or (p10 = 9) then
        if(p10 == 0 || p10 == 1 || p10 == 9)
        {
            //dummy := 1 else
            temp = 1;
        }
        else
        {
            //if (p10=2)then
            if(p10 == 2)
            {
                //minmemo  := memo81;
                memo.add(Memo81);
            }
            else
            {
                //if (p10=3)then minmemo  := memo82;
                if(p10 == 3)
                {
                    memo.add(Memo82);
                }
            }
        }

        //{FAST EFTERTEXT, speciell för varje procentgrupp}
        //minmemo := memo91;
        memo.add(Memo91);

        return memo;
    }//procedure
}//Advice0020

