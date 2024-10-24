package com.example.Cariogram_Backend.Services;
//import java.lang.Math;
//import java.math.RoundingMode;

import org.springframework.stereotype.Service;

/*
 * Author: Johan Börjesson, Lisa Berglund & Stefan Gustavsson
 * Date: 2011-05-09
 */
@Service
public class InputHandlerService implements InputHandlerServiceImpl {

    //Fields
    private double[] rawNumJvalue;
    private String[] rawStr;
    private double[] workValues; //D3_17
    private double[] EviktValue;
    private double[] FviktValue;
    private double[] GviktValue;
    private double[] HviktValue;
    private double[] FlourH27_29;
    private double LandAldVikt;
    private double EviktSum;
    private double FviktSum;
    private double GviktSum;
    private double HviktSum;
    private double FlourSumH29;
    private double KostbaktSum;
    private double MuntorrH34;
    private double SumXtF18;
    private double antifluorH36;
    private double kostC21, baktC22, mottaglC23, omstC24;
    private double totgrundpC27, justgrundpC30, basC34, muntorrC35, antifluorC36;
    private double totpbakbrC28, sumC38, A21;
    private double SumOmdH42;
    private double chansC20;
    private double procC20, procC21, procC22, procC23, procC24;
    private double land, alder;

    /*--------------------------------------------------------------------------
     * Constructor for InputHandler
     */
    public InputHandlerService()
    {
        initDoubles();
    }

    public void initDoubles()
    {
        rawNumJvalue = new double[12];
        rawStr = new String[10];
        workValues = new double[12];// D3_17
        EviktValue = new double[12];// E9_17
        FviktValue = new double[12];// F9_18
        GviktValue = new double[12];// G9_17
        HviktValue = new double[12];// H9__17
        FlourH27_29 = new double[12];// H27_29
        LandAldVikt = 10D;// K_O land + alder 5 + 5 = 10
        EviktSum = 0D;// E17
        FviktSum = 0D;// F17
        GviktSum = 0D;// F17
        HviktSum = 0D;// H17
        FlourSumH29 = 0D;// (* H29   *)
        KostbaktSum = 0D;// (* H33   *)
        MuntorrH34 = 0D;//  (* H34   *)
        SumXtF18 = 0D;//    (* F18   *)
        antifluorH36 = 0D;//(* H36   *)

        kostC21 = 0D;
        baktC22 = 0D;
        mottaglC23 = 0D;
        omstC24 = 0D;

        totgrundpC27 = 0D;
        justgrundpC30 = 0D;
        basC34 = 0D;
        muntorrC35 = 0D;
        antifluorC36 = 0D;

        totpbakbrC28 = 0D;
        sumC38 = 0D;
        A21 = 0D;

        SumOmdH42 = 0D;

        chansC20 = 0D;

        procC20 = 0D;
        procC21 = 0D;
        procC22 = 0D;
        procC23 = 0D;
        procC24 = 0D;
        land = 5D;
        alder = 5D;
    }

    private int Values()
    {

        double[] rawNum = new double[10];
        String[] tillfStr = new String[10];


        tillfStr[0] = rawStr[0];
        tillfStr[1] = rawStr[1];
        tillfStr[3] = rawStr[2];
        tillfStr[4] = rawStr[3];
        tillfStr[5] = rawStr[4];
        tillfStr[6] = rawStr[5];
        tillfStr[7] = rawStr[6];
        tillfStr[8] = rawStr[7];
        tillfStr[9] = rawStr[8];
        tillfStr[2] = rawStr[9];


        //check for missing values.
        int saknas = 0;
        for (int i = 0; i <= 9; i++)
        {
            rawNum[i] = ParseToDouble(tillfStr[i]);
            if ("".equals(tillfStr[i]) || "-".equals(tillfStr[i]))
            {
                rawNum[i] = 9;
                saknas += 1;
            }
        }

        System.arraycopy(rawNum, 0, rawNumJvalue, 0, 10);

        //Set ddefaultvalues if not all values are entered
        if (rawNum[0] == 9){ rawNumJvalue[0]= 2;}
        if (rawNum[1] == 9){ rawNumJvalue[1]= 1;}
        if (rawNum[2] == 9){ rawNumJvalue[2]= 1;}
        if (rawNum[3] == 9){ rawNumJvalue[3]= 2;}
        if (rawNum[4] == 9){ rawNumJvalue[4]= 2;}
        if (rawNum[5] == 9){ rawNumJvalue[5]= 2;}
        if (rawNum[6] == 9){ rawNumJvalue[6]= 2;}
        if (rawNum[7] == 9){ rawNumJvalue[7]= 2;}
        if (rawNum[8] == 9){ rawNumJvalue[8]= 1;}
        if (rawNum[9] == 9){ rawNumJvalue[9]= 1;}

        return saknas;
    }



    /*--------------------------------------------------------------------------
     * Converts a string to an double.
     * if exception cought returns 9
     * witch counts as a missing value
     */
    private double ParseToDouble(String strToConvert)
    {
        double d = 0D;
        try
        {
            d = Double.parseDouble(strToConvert);
        }
        catch (Exception e)
        {
            d = 9D;
        }
        return d;
    }

    private void MakeWorkListD3_17()
    {


        System.arraycopy(rawNumJvalue, 0, workValues, 0, 10);

        workValues[10] = (rawNumJvalue[0] + rawNumJvalue[1]) / 1.54;

        workValues[11] = 0;

        for (int i = 3;i <= 9; i++)
        {
            workValues[11] += rawNumJvalue[i];
        }
    }

    private void EviktningE9_17()
    {
        if ( workValues[3] == 2){ EviktValue[3] = 5; }
        else{EviktValue[3] = 0;}

        if (workValues[4] == 2){EviktValue[4] = 6; }
        else{EviktValue[4] = 0;}

        if (workValues[5] == 2){EviktValue[5] = 5;}
        else{EviktValue[5] = 0;}

        if (workValues[6] == 2){EviktValue[6] = 7;}
        else{EviktValue[6] = 0;}

        if (workValues[7] == 2){EviktValue[7] = 5;}
        else{EviktValue[7] = 0;}

        if (workValues[8] > 0){EviktValue[8] = 3;}
        else{EviktValue[8] = 0;}

        if (workValues[9] > 0){EviktValue[9] = 3;}
        else{EviktValue[9] = 0;}

        if (workValues[5] == 1){EviktValue[10] = 2;}
        else{EviktValue[10] = 0;}

        EviktSum = 0D;

        for (int i = 3; i <= 10; i++)
        {
            EviktSum += EviktValue[i];
        }
    }


    private void FviktningF9_18()
    {
        if (workValues[3] == 3){FviktValue[3] = 8;}
        else{FviktValue[3] = 0;}

        if (workValues[4] == 3){FviktValue[4] = 10;}
        else{FviktValue[4] = 0;}

        if (workValues[5] == 3){FviktValue[5] = 8;}
        else{FviktValue[5] = 0;}

        if (workValues[6] == 3){FviktValue[6] = 12;}
        else{FviktValue[6] = 0;}

        if (workValues[7] == 3){FviktValue[7] = 30;}
        else{FviktValue[7] = 0;}

        if (workValues[8] == 2){FviktValue[8] = 3;}
        else{FviktValue[8] = 0;}

        if (workValues[9] == 2){FviktValue[9] = 3;}
        else{FviktValue[9] = 0;}

        for (int i = 3; i <= 9; i++)
        {
            FviktSum += FviktValue[i];
        }
    }

    private void GviktningG9_17()
    {
        if (workValues[3] + workValues[4] == 6){GviktValue[0] = 10;}
        else{GviktValue[0] = 0;}

        if (workValues[3] + workValues[4] == 5){GviktValue[1] = 5;}
        else{GviktValue[1] = 0;}

        if (workValues[5] + workValues[6] == 6){GviktValue[2] = 10;}
        else{GviktValue[2] = 0;}

        if (workValues[5] + workValues[6] == 5){GviktValue[3] = 5;}
        else{GviktValue[3] = 0;}

        if (workValues[8] + workValues[9] == 4){GviktValue[4] = 5;}
        else{GviktValue[4] = 0;}

        if (workValues[8] + workValues[9] == 5){GviktValue[5] = 10;}
        else{GviktValue[5] = 0;}

        for (int i = 0; i <= 5; i++)
        {
            GviktSum += GviktValue[i];
        }
    }

    private void HviktningH9_17()
    {
        if (workValues[3] + workValues[4] + workValues[5] > 7){HviktValue[0] = 10;}
        else{HviktValue[0] = 0;}

        if (workValues[3] + workValues[4] + workValues[6] > 6){HviktValue[1] = 17;}
        else{HviktValue[1] = 0;}

        if (workValues[3] == 0){HviktValue[2] = -10;}
        else{HviktValue[2] = 0;}

        if (workValues[3] + workValues[4] + workValues[5] + workValues[6] + workValues[7] > 9){HviktValue[3] = 14;}
        else{HviktValue[3] = 0;}

        for (int i = 0; i <= 3; i++)
        {
            HviktSum += HviktValue[i];
        }

        if (GviktSum + HviktSum < 8){SumXtF18 = 1;}
        else{SumXtF18 = GviktSum + HviktSum;}

    }

    private void FlourProgrH27_29()
    {
        //Fields
        double flour0 = 0D;
        double flour1 = 0D;

        if (workValues[7] == 0D){ flour0 = 0.51 * ((workValues[11] + (EviktSum + FviktSum)) + 1.73);}
        else{flour0 = 0D;}

        if (workValues[7] == 1D){flour1 = 0.67 * workValues[11];}
        else{flour1 = 0D;}

        FlourSumH29 = flour0 + flour1;

    }

    private void BlandatH31_36()
    {
        double kostbakt1 = 0D;
        double kostbakt2 = 0D;

        if ((workValues[3] + workValues[4] + workValues[5] + workValues[6]) < 7){kostbakt1 = 1.63 * workValues[11];}
        else{kostbakt1 = 0D;}

        if ((workValues[3] + workValues[4] + workValues[5] + workValues[6]) > 6){kostbakt2 = 1.00 * workValues[11];}
        else{kostbakt2 = 0D;}

        KostbaktSum = kostbakt1 + kostbakt2;

        if (workValues[8] == 3){MuntorrH34 = KostbaktSum;}
        else{MuntorrH34 = 0;}

        if (workValues[7] == 3){antifluorH36 = 1.04 *
                workValues[3]
                + workValues[4]
                + workValues[5]
                + workValues[6]
                + workValues[7]
                + workValues[8];
        }
        else{antifluorH36 = 0;}
    }


    private void BlandatC21_24()
    {
        if (workValues[7] + workValues[8] + workValues[9] + MuntorrH34 + antifluorH36 == 0){mottaglC23 = 1.00;}
        else{mottaglC23 = workValues[7] + workValues[8] + workValues[9] + MuntorrH34 + antifluorH36;}

        if (workValues[5] + workValues[6] == 0){baktC22 = 0.5;}
        else{baktC22 = workValues[5] + workValues[6];}

        if (workValues[3] + workValues[4] == 0){kostC21 = 0.3;}
        else{kostC21 = workValues[3] + workValues[4];}

        omstC24 = workValues[10];

        if (omstC24 == 0){omstC24 = 0.5;}

    }

    private void BlandatC27_36()
    {
        totgrundpC27 = kostC21 + baktC22 + mottaglC23 + omstC24;

        justgrundpC30 = totgrundpC27 - FlourSumH29;

        basC34 = 20;

        muntorrC35 = KostbaktSum;


        antifluorC36 = antifluorH36;

    }

    private void ComputeA21()
    {
        justgrundpC30 = totgrundpC27 - FlourSumH29;

        sumC38 = basC34 + muntorrC35 + antifluorC36;

        if (EviktSum + FviktSum + SumXtF18 == 0){totpbakbrC28 = 1;}
        else{totpbakbrC28 = EviktSum + FviktSum + SumXtF18;}

        A21 = (sumC38 - justgrundpC30) * (LandAldVikt / totpbakbrC28);

    }

    private void ComputeH42()
    {

        double omd0;
        double omd1;
        double omd2;
        double kariesfriH44;


        if (workValues[2] == 0){omd0 = 2.37 * A21;}
        else{omd0 = 0;}

        if (workValues[2] == 1){omd1 = 1.00 * A21;}
        else{omd1 = 0;}

        if (workValues[2] == 2){omd2 = 0.29 * A21;}
        else{omd2 = 0;}


        if (workValues[0] == 0){kariesfriH44 = 1.75 * A21;}
        else{kariesfriH44 = 0;}


        SumOmdH42 = (omd0 + omd1 + omd2) + kariesfriH44;

    }


    private void ComputeChansC20()
    {
        double A22;
        double chansA20;

        A22 = SumOmdH42;

        if (workValues[2] == 3){chansA20 = 0.1;}
        else{
            chansA20 = A22;
            chansC20 = chansA20;
        }
    }


    private void ComputeProcent()
    {

        double sum = chansC20 + kostC21 + baktC22 + mottaglC23 + omstC24;

        //Calculate procent
        procC20 = 100 * chansC20/sum;
        procC21 = 100 * kostC21/sum;
        procC22 = 100 * baktC22/sum;
        procC23 = 100 * mottaglC23/sum;
        procC24 = 100 * omstC24/sum;
        procC20 = roundDouble(procC20);
        procC21 = roundDouble(procC21);
        procC22 = roundDouble(procC22);
        procC23 = roundDouble(procC23);
        procC24 = roundDouble(procC24);
    }// END; (* ComputeProcent *)




    @Override
    public double[] RunAlgorithm(String[] inputValues)
    {
        rawStr = inputValues;
        int saknas = Values();
        if (saknas < 4)
        {
            MakeWorkListD3_17();
            EviktningE9_17();
            FviktningF9_18();
            GviktningG9_17();
            HviktningH9_17();
            FlourProgrH27_29();
            BlandatH31_36();
            BlandatC21_24();
            BlandatC27_36();
            ComputeA21();
            ComputeH42();
            ComputeChansC20();
            ComputeProcent();
        }
        double[] returnValue = {procC20, procC21, procC22, procC23, procC24};
        return returnValue;
    }

    private double roundDouble(double doubleToRound)
    {
        doubleToRound = Math.round(doubleToRound * 100)/100.0d;

        return doubleToRound;
    }
}
