package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server>{
    final static double EPSILON = 0.01d;
    private double expectedLoadPercentage;

    public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {

        this.expectedLoadPercentage = expectedLoadPercentage;
    }

    protected boolean matchesSafely(Server server) {


        return expectedLoadPercentage == server.currentLoadPercentage
                || Math.abs(expectedLoadPercentage- server.currentLoadPercentage) < EPSILON;
    }

    public void describeTo(Description description) {
        description.appendText("a server with load percentage of").appendValue(expectedLoadPercentage);

    }
}
