package com.lifescore.pages.steps;

import com.lifescore.pages.MyDataPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import java.util.List;

public class MyDataPageSteps extends MyDataPage {
    public MyDataPageSteps(AppiumDriver driver) {
        super(driver);
    }

    public void checkIfScoresMatch(){
        List<String> scores = getVisibleScores();
        boolean scoreMatchs = allElementsAreSame(scores);
        Assert.assertTrue(scoreMatchs);
    }

    public void checkIfScoreSummatoryMatches(){

        double result = (double) sumStringList(getScoresPerCategory()) /6;
        boolean areMatching = areSummatoryMatching(result);
        Assert.assertTrue(areMatching,"Scores don't match, Average from Summatory: " +result + ", LifeScore value from UI:" + Double.parseDouble(getVisibleScores().get(0)));

    }

    public boolean areSummatoryMatching(double sum){
        double lifeScore = Double.parseDouble(getVisibleScores().get(0));
        double epsilon = 0.00001; // or whatever precision you need
        return Math.abs(sum - lifeScore) < epsilon;
    }

    public boolean allElementsAreSame(List<String> values) {
        if (values.isEmpty()) return true;

        String first = values.get(0);
        return values.stream().allMatch(v -> v.equals(first));
    }

    public int sumStringList(List<String> values) {
        return values.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
