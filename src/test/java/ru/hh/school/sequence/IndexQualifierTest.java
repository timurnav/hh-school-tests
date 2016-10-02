package ru.hh.school.sequence;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class IndexQualifierTest {

    private NumbersComparator numbersComparator = new NumbersComparator();
    private IndexQualifier indexQualifier = new IndexQualifier();


    private String sequence;

    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"91"},
//                {"99"},
        };
    }

    @DataProvider
    public static Object[][] getAllData() {
        Object[][] array = new Object[10000][1];
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 1 + i + "";
        }
        return array;
    }

    @BeforeSuite
    public void init() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 1000002; i++) {
            stringBuilder.append(i);
        }
        sequence = stringBuilder.toString();
    }

    @Test(dataProvider = "getAllData")
//    @Test(dataProvider = "getData")
    public void getIndexInSequence(String value) throws Exception {
        Sequence sequence = new Sequence(value);
        FirstNumber firstElement = numbersComparator.getFirstElementOfSequence(sequence);
        System.out.println(firstElement);
        BigInteger index = indexQualifier.getIndexInSequence(firstElement);
        System.out.println(index);
        Assert.assertEquals(
                index,
                BigInteger.valueOf(this.sequence.indexOf(value) + 1)
        );
    }
}