package com.lucas.javase.mavendemo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testApp() throws InterruptedException
    {
        assertTrue( true );
		assertEquals(2,App.sum(1, 1));
		new App();
    }
    
}
