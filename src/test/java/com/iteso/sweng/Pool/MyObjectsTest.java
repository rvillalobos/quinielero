package com.iteso.sweng.Pool;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Mauricio Landeros on 05/12/2014.
 */
public class MyObjectsTest extends TestCase

{


    public void testLeagues(){
        MyObjects o = new MyObjects();

        ArrayList<String> resultado = o.getMyLeagues("Mauricio");

        assertEquals(resultado,resultado);

    }

    public void testTeams(){

        MyObjects o = new MyObjects();

        ArrayList<String> resultado = o.getMyTeams("Mauricio");

        assertEquals(resultado,resultado);
    }



}
