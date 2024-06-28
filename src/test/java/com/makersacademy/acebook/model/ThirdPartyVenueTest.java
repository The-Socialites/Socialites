package com.makersacademy.acebook.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThirdPartyVenueTest {
    @Test
    public void testCreateThirdPartyVenue(){
        ThirdPartyVenue venue = new ThirdPartyVenue();
        venue.setFull_address("1 Station Road, Wandsworth, London, UK SW17 9RT");

        assertEquals("1 Station Road, Wandsworth, London, UK SW17 9RT", venue.getFull_address());
    }
}
