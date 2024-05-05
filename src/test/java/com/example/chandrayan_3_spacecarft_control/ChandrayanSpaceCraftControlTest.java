package com.example.chandrayan_3_spacecarft_control;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChandrayanSpaceCraftControlTest {

    private ChandrayanSpaceCraftControl spaceCraft;

    @Before
    public void setUp() {
        spaceCraft = new ChandrayanSpaceCraftControl(0, 0, 0, Direction.N);
    }

    @Test
    public void testSequenceOfCommands() {
        spaceCraft.sendCommands(new String[]{"f", "r", "u", "b", "l"});
        assertEquals(0, spaceCraft.getX());
        assertEquals(1, spaceCraft.getY());
        assertEquals(-1, spaceCraft.getZ());
        assertEquals(Direction.N, spaceCraft.getDirection());
    }

}