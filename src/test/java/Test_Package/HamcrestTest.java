package Test_Package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import impl.HandlerImpl;
import impl.Person;
import impl.PersonData;
import java.io.IOException;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 *
 * @author micha
 */
public class HamcrestTest {

    HandlerImpl hi;
    PersonData pd;
    Person p;

    public HamcrestTest() {
        this.pd = new PersonData();
        this.hi = new HandlerImpl();
    }

    @Test
    public void testAddPersons() throws IOException {
        System.out.println("AddPersons");
        String firstName;
        String lastName;
        int age;
        pd.addData();
        ArrayList<Person> expectedArray = pd.getPersons();
        int expectedLength = expectedArray.size() - 1;
        ArrayList<Person> actualArray = hi.addPersons();
        assertThat(actualArray.size() - 1, is(equalTo(expectedLength)));
        for (int i = 0; i < expectedArray.size() -1; i++) {
            firstName = expectedArray.get(i).getFirstName();
            lastName = expectedArray.get(i).getLastName();
            age = expectedArray.get(i).getAge();
            assertThat(actualArray.get(i).getFirstName(), is(equalTo(firstName)));
            assertThat(actualArray.get(i).getLastName(), is(equalTo(lastName)));
            assertThat(actualArray.get(i).getAge(), is(equalTo(age)));
        }
    }

    @Test
    public void testIsAdultCount() throws IOException {
        System.out.println("IsAdultCount");
        pd.addData();
        int expected = 3;
        int actual = hi.isAdultCount();
        assertThat(actual, is(equalTo(expected)));
        assertThat(actual, is(not(equalTo(0))));
        assertThat(actual, is(not(equalTo(2))));
        assertThat(actual, is(not(equalTo(4))));
    }
}
