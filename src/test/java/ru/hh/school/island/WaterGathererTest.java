package ru.hh.school.island;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.hh.school.island.service.WaterGatherer;

import java.util.Arrays;
import java.util.List;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class WaterGathererTest {

    private final WaterGatherer waterGatherer = new WaterGatherer();


    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{
                {Arrays.asList(
                        "2 2 2 2",
                        "2 1 1 2",
                        "2 1 1 2",
                        "2 2 2 2"
                ), 4},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void gatherWater(List<String> island, int expectedWaterVolume) {
    }

}