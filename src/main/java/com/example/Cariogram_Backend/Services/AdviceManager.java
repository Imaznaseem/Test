package com.example.Cariogram_Backend.Services;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * Cariogram java version by:
 * Johan Börjesson, Lisa Berglund & Stefan Gustavsson
 * Date: 2011-06-01
 * Copyright Malmö Högskola 2011
 */

@Service
public class AdviceManager
{
    /*
     * Constructor
     */
    public AdviceManager(){

    }

    /*
     * return List with advice Strings
     * depending on the chans to avoid caries
     * input for this is the procent calculation result
     * from InputHandler
     */
    public List getAdvice(double procent, String[] input)
    {
        List<String> advice = new ArrayList<String>();

        if (procent <= 20D){
            //intervall 0 - 20%
            Advice0020 ad0020 = new Advice0020(input);
            advice = ad0020.procedure();

        }else if (procent > 20D && procent <= 40D){
            //intervall 20 - 40%
            Advice2040 ad2040 = new Advice2040(input);
            advice = ad2040.procudure();

        }else if (procent > 40D && procent <= 60D){
            //intervalll 40 - 60%
            Advice4060 ad4060 = new Advice4060(input);
            advice = ad4060.procedure();

        }else if (procent > 60D && procent <= 80D){
            //intervall 60 - 80%
            Advice6080 ad6080 = new Advice6080(input);
            advice = ad6080.procedure();

        }else{
            //intervall 80 - 100%
            Advice80100 ad80100 = new Advice80100(input);
            advice = ad80100.procedure();
        }

        return advice;
    }
}
