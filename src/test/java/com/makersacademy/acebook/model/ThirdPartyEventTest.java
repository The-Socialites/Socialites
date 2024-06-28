package com.makersacademy.acebook.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ThirdPartyEventTest {

    @Test
    public void test_create_third_party_event_instance_with_valid_data() {
        ThirdPartyEvent thirdPartyEvent = new ThirdPartyEvent();
        thirdPartyEvent.setName("Music Gig");
        thirdPartyEvent.setLink("www.musicgig.com");
        thirdPartyEvent.setDescription("Greatest music gig ever! You must come along");
        thirdPartyEvent.setStartTime("2024-12-01 00:00:00");
        thirdPartyEvent.setEndTime("2024-12-01 23:59:12");
        thirdPartyEvent.setThumbnail("https://example.com/thumbnail.jpg");
        ThirdPartyVenue venue = new ThirdPartyVenue();
        thirdPartyEvent.setVenue(venue);

        assertEquals("Music Gig", thirdPartyEvent.getName());
        assertEquals("www.musicgig.com", thirdPartyEvent.getLink());
        assertEquals("Greatest music gig ever! You must come along", thirdPartyEvent.getDescription());
        assertEquals("2024-12-01 00:00:00", thirdPartyEvent.getStartTime());
        assertEquals("2024-12-01 23:59:12", thirdPartyEvent.getEndTime());
        assertEquals("https://example.com/thumbnail.jpg", thirdPartyEvent.getThumbnail());
        assertEquals(venue, thirdPartyEvent.getVenue());
    }

    @Test
    public void test_correctly_formats_start_time() {
        ThirdPartyEvent event = new ThirdPartyEvent();
        event.setStartTime("2023-10-01 15:30:00");
        String formattedStartTime = event.getFormattedStartTime();
        assertEquals("01-10-2023 15:30", formattedStartTime);
    }

    @Test
    public void test_correctly_formats_end_time() {
        ThirdPartyEvent event = new ThirdPartyEvent();
        event.setEndTime("2022-12-31 23:59:59");
        String formattedEndTime = event.getFormattedEndTime();
        assertEquals("31-12-2022 23:59", formattedEndTime);
    }

    @Test
    public void test_handles_empty_start_time_string() {
        ThirdPartyEvent event = new ThirdPartyEvent();
        event.setStartTime("");
        String formattedStartTime = event.getFormattedStartTime();
        assertNull(formattedStartTime);
    }

    @Test
    public void test_handles_empty_end_time_string() {
        ThirdPartyEvent event = new ThirdPartyEvent();
        event.setEndTime("");
        String formattedEndTime = event.getFormattedEndTime();
        assertNull(formattedEndTime);
    }

    @Test
    public void test_ignores_unknown_json_properties() {
        ThirdPartyEvent event = new ThirdPartyEvent();
        String json = "{\"event_id\":\"12345\",\"name\":\"Test Event\",\"link\":\"www.testevent.com\",\"unknown\":\"This is unknown\",\"description\":\"This is a test event\"}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            event = mapper.readValue(json, ThirdPartyEvent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assertNull(event.getStartTime());
        assertNull(event.getEndTime());
        assertNull(event.getVenue());
        assertNull(event.getThumbnail());
        assertEquals("12345", event.getEventId());
        assertEquals("Test Event", event.getName());
    }

}
