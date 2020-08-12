import Lesson6.MyClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class TestFirstMethodWithParam {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList( new Object[][]{
                { new int[]{5,6,7,8,9}, new int[]{1,2,3,4,5,6,7,8,9} },
                { new int[]{8,9}, new int[]{1,2,3,4,5,6,7,4,8,9} },
                { new int[]{8}, new int[]{1,2,3,4,5,6,7,4,8} },
        });
    }

    private int[] arrayIn;
    private int[] arrayOut;

    public TestFirstMethodWithParam(int[] arrayOut, int[] arrayIn){
        this.arrayOut = arrayOut;
        this.arrayIn = arrayIn;
    }

    MyClass myClass;

    @Before
    public  void init (){
        myClass = new MyClass();
    }

    @Test
    public void testFirstMethodWP() throws Exception {
        Assert.assertArrayEquals(arrayOut, myClass.myFirstMethod(arrayIn));
    }
}
