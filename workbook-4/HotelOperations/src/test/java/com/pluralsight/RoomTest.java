package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;
class RoomTest {

    @org.junit.jupiter.api.Test
    void checkedIn_Test() {
        //arrange
        Room room = new Room();
        //act
        room.checkedIn();
        //assertion
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @org.junit.jupiter.api.Test
    void checkedOut_Test() {
        //arrange
        Room room = new Room();
        //act
        room.checkedOut();
        //assertion
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @org.junit.jupiter.api.Test
    void cleanRoom_Test() {
        //arrange
        Room room = new Room();
        //act
        room.cleanRoom();
        //assertion
        assertFalse(room.isDirty());
    }
}