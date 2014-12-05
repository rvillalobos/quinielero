package com.iteso.sweng.Pool;

import junit.framework.TestCase;

/**
 * Created by Mauricio Landeros on 05/12/2014.
 */
public class SelectPoolModeTest extends TestCase{

    public void testPoolMode(){

        SelectPoolMode p = new SelectPoolMode();

        p.SelectPoolMode(0,"Pool_10","Mauricio");

        assertEquals(1,p.flag);

    }



}
