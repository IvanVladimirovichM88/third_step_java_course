import Lesson6.MyClass;
import org.junit.Assert;
import org.junit.Test;

public class TestSecondMethod {
    @Test
    public void test1() {
        int[] array = {1,1,1,1,1,1,1,1,1};
        Assert.assertFalse(MyClass.mySecondMethod(array));
    }

    @Test
    public void test2() {
        int[] array = {4,4,4,4,4,4};
        Assert.assertFalse(MyClass.mySecondMethod(array));
    }

    @Test
    public void test3() {
        int[] array = {4,4,4,4,4,4,1,1,1,1,1};
        Assert.assertTrue(MyClass.mySecondMethod(array));
    }

    @Test
    public void test4() {
        int[] array = {1,1,1,1,1,4,4,4,4,4,4};
        Assert.assertTrue(MyClass.mySecondMethod(array));
    }

    @Test
    public void test5() {
        int[] array = {1,1,1,1,1,4,4,4,4,4,4,1,1,1,1,1};
        Assert.assertTrue(MyClass.mySecondMethod(array));
    }

    @Test
    public void test6() {
        int[] array = {1,1,1,1,1,4,4,4,4,4,2,1,1,1,1,1};
        Assert.assertFalse(MyClass.mySecondMethod(array));
    }
}
