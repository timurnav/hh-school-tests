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
        Object[][] array = new Object[10000][1];
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 1 + i + "";
        }
        return array;
//        return new Object[][]{
//                {"709"},
//                {"9101"},
//                {"9109"},
//                {"21"},
//                {"31"},
//                {"32"},
//        };
    }

    @BeforeSuite
    public void init() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 1000002; i++) {
            stringBuilder.append(i);
        }
        sequence = stringBuilder.toString();
        System.out.println(sequence.length());
    }

    @Test(dataProvider = "getData")
    public void getIndexInSequence(String value) throws Exception {
        FirstNumber firstElement = numbersComparator.getFirstElementOfSequence(new Sequence(value));
        System.out.println(firstElement);
        BigInteger index = indexQualifier.getIndexInSequence(firstElement);
        System.out.println(index);
        Assert.assertEquals(
                index,
                BigInteger.valueOf(sequence.indexOf(value) + 1)
        );
    }
}