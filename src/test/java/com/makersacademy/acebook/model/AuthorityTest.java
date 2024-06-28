package com.makersacademy.acebook.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthorityTest {

    @Test
    public void test_create_authority_with_valid_username_and_authority() {
        Authority authority = new Authority("user1", "ROLE_USER");
        assertNotNull(authority);
        assertEquals("user1", authority.getUsername());
        assertEquals("ROLE_USER", authority.getAuthority());
    }
}
