package builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import example.builder.Person;

class PersonTest {

    @Test
    void testBuilder() {
        String firstName = "foo";
        String middleName = "bar";
        String lastName = "baz";
        int age = 50;

        Person person1 = Person.getBuilder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .age(age)
                .build();

        assertEquals(firstName, person1.getFirstName());
        assertEquals(middleName, person1.getMiddleName());
        assertEquals(lastName, person1.getLastName());
        assertEquals(age, person1.getAge());

    }

}
