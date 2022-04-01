package net.genspark.projects;

import java.io.IOException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class AppTest {

    @Test
    void Price() throws IOException {
        assertEquals("75.0",App.getTicketPrice(4,12,"MALE"));
        assertEquals("37.5",App.getTicketPrice(4,12,"FEMALE"));
        assertEquals("75.0",App.getTicketPrice(4,50,"FEMALE"));
        assertEquals("100.0",App.getTicketPrice(4,50,"MALE"));
        assertEquals("85.0",App.getTicketPrice(4,60,"MALE"));
        assertEquals("45.0",App.getTicketPrice(4,60,"FEMALE"));
    }

    @Test
    void ArrivalTime() throws IOException {
        assertEquals("2022-03-31T16:20",App.getArrivalTime(4,"12:20","2022-03-31"));
    }
}