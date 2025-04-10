package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("Benjamin C.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_gihubId() {
        assertEquals("bennyyyyy", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s25-00", t.getName());
        assertTrue(t.getMembers().contains("Benjamin C."), "Team should contain Benjamin C.");
        assertTrue(t.getMembers().contains("Phil C."), "Team should contain Phil C.");
    }
}
