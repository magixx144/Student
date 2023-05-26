package com.example.student.Test;

import com.example.student.Contribution;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class ContributionTest {
    private Contribution contribution;

    @Before
    public void setUp() {
        contribution = new Contribution(1, "First contribution", 1, "This is the first contribution.");
    }

    @Test
    public void testContributionNumber() {
        assertEquals(1, contribution.getContributionNumber());
        contribution.setContributionNumber(2);
        assertEquals(2, contribution.getContributionNumber());
    }

    @Test
    public void testContribution() {
        assertEquals("First contribution", contribution.getContribution());
        contribution.setContribution("Second contribution");
        assertEquals("Second contribution", contribution.getContribution());
    }

    @Test
    public void testSemester() {
        assertEquals(1, contribution.getSemester());
        contribution.setSemester(2);
        assertEquals(2, contribution.getSemester());
    }

    @Test
    public void testDetail() {
        assertEquals("This is the first contribution.", contribution.getDetail());
        contribution.setDetail("This is the second contribution.");
        assertEquals("This is the second contribution.", contribution.getDetail());
    }

}