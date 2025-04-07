package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    } 

    @Test
    public void equals_returns_false_for_different_names() {
        Team t1 = new Team("team1");
        Team t2 = new Team("team2");
        boolean result = t1.equals(t2);
        assert(!result);
    }   

    @Test
    public void equals_returns_true_for_same_team() {
        Team t1 = new Team("team1");
        boolean result = t1.equals(t1);
        assert(result);
    }

    @Test
    public void equals_returns_false_for_different_object() {
        Team t1 = new Team("team1");
        String str = "not a team";
        boolean result = t1.equals(str);
        assert(!result);
    }

    @Test
    public void hashcode_returns_correctly() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}