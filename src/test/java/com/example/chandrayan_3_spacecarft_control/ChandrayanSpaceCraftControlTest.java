package com.example.chandrayan_3_spacecarft_control;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChandrayanSpaceCraftControlTest {

    private static ChandrayanSpaceCraftControl spaceCraft;

    @BeforeClass
    public static void setUp() {
        spaceCraft = new ChandrayanSpaceCraftControl(0, 0, 0, Direction.N);
    }

    @Test
    public void test1MoveForeword() {
        spaceCraft.sendCommands(new String[]{"f"});
        assertEquals(0, spaceCraft.getX());
        assertEquals(1, spaceCraft.getY());
        assertEquals(0, spaceCraft.getZ());
        assertEquals(Direction.N, spaceCraft.getDirection());
    }

    @Test
    public void test2TurnRight() {
        spaceCraft.sendCommands(new String[]{"r"});
        assertEquals(0, spaceCraft.getX());
        assertEquals(1, spaceCraft.getY());
        assertEquals(0, spaceCraft.getZ());
        assertEquals(Direction.E, spaceCraft.getDirection());
    }

    @Test
    public void test3MoveUp() {
        spaceCraft.sendCommands(new String[]{"u"});
        assertEquals(0, spaceCraft.getX());
        assertEquals(1, spaceCraft.getY());
        assertEquals(0, spaceCraft.getZ());
        assertEquals(Direction.Up, spaceCraft.getDirection());
    }

    @Test
    public void test4MoveBack() {
        spaceCraft.sendCommands(new String[]{"b"});
        assertEquals(0, spaceCraft.getX());
        assertEquals(1, spaceCraft.getY());
        assertEquals(-1, spaceCraft.getZ());
        assertEquals(Direction.Up, spaceCraft.getDirection());
    }

    @Test
    public void test5TurnLeft() {
        spaceCraft.sendCommands(new String[]{"l"});
        assertEquals(0, spaceCraft.getX());
        assertEquals(1, spaceCraft.getY());
        assertEquals(-1, spaceCraft.getZ());
        assertEquals(Direction.N, spaceCraft.getDirection());
    }

    @Test
    public void test6ResetAndTestWithArray(){
        spaceCraft = new ChandrayanSpaceCraftControl(0, 0, 0, Direction.N);
        spaceCraft.sendCommands(new String[]{"f", "r", "u", "b", "l"});
        assertEquals(0, spaceCraft.getX());
        assertEquals(1, spaceCraft.getY());
        assertEquals(-1, spaceCraft.getZ());
        assertEquals(Direction.N, spaceCraft.getDirection());
    }
}