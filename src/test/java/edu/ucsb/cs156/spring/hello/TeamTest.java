package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    public void equals_returns_true_if_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_if_different_class() {
        String testing = "test";
        assertEquals(false, team.equals(testing));
    }

    @Test
    public void equals_returns_true_if_names_and_members_are_equal() {
        Team otherTeam = new Team("test-team");
        assertEquals(true, team.equals(otherTeam));
    }

    @Test
    public void equals_returns_false_if_names_equal_but_members_not_equal() {
        Team otherTeam = new Team("test-team");
        otherTeam.addMember("Alice");
        assertEquals(false, team.equals(otherTeam));
    }

    @Test
    public void equals_returns_false_if_names_not_equal() {
        Team otherTeam = new Team("different-team");
        assertEquals(false, team.equals(otherTeam));
    }

    @Test
    public void hashCode_has_same_value_for_same_object() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
        public void hashCode_returns_correct_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        int expectedHashCode = t1.getName().hashCode() | t1.getMembers().hashCode();
        assertEquals(expectedHashCode, t1.hashCode());
    }

    @Test
        public void hashCode_is_different_for_different_objects() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        Team t2 = new Team();
        t2.setName("baz");
        t2.addMember("qux");

        assertFalse(t1.equals(t2));
        assertFalse(t1.hashCode() == t2.hashCode());
    }

}
