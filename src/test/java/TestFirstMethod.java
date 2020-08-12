import Lesson6.MyClass;
import org.junit.Assert;
import org.junit.Test;

public class TestFirstMethod {

    @Test
    public void test1() throws Exception {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Assert.assertArrayEquals(new int[]{5,6,7,8,9}, MyClass.myFirstMethod(array));
    }

    @Test
    public void test2() throws Exception {
        int[] array = {1,2,3,4,5,6,7,4,8,9};
        Assert.assertArrayEquals(new int[]{8,9}, MyClass.myFirstMethod(array));
    }

    @Test
    public void test3() throws Exception {
        int[] array = {1,2,3,4,5,6,7,4,8};
        Assert.assertArrayEquals(new int[]{8}, MyClass.myFirstMethod(array));
    }

    @Test( expected = RuntimeException.class )
    public void test4() throws Exception {
        int[] array = {1,2,3,4,5,6,7,8,9,4};
        MyClass.myFirstMethod(array);
    }

    @Test( expected = RuntimeException.class )
    public void test5() throws Exception {
        int[] array = {1,2,3,4};
        MyClass.myFirstMethod(array);
    }

    @Test(expected = RuntimeException.class)
    public void test6() throws Exception {
        int[] array = {1,2,3,5,6,7,8};
        MyClass.myFirstMethod(array);
    }
}
