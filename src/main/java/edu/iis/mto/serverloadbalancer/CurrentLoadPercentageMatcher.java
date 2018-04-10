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
    public void describeTo(Description description) {
        description.appendText("a server with load percentage of").appendValue(expectedLoadPercentage);

    }

    protected boolean matchesSafely(Server server) {
        double d1 = this.expectedLoadPercentage;
        double d2 = server.currentLoadPercentage;
        return doubleAreEqual(d1, d2);
    }

    private boolean doubleAreEqual(double d1, double d2) {
        return d1 == d2
                || Math.abs(d1 - d2) < EPSILON;
    }

    public static CurrentLoadPercentageMatcher hasCurrentLoadPercentageOf(double expectedLoadPercentage) {
        return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
    }
}
