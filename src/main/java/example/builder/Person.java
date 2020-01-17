package example.builder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    // default constructor so the builder can create an empty version
    private Person() {
    }

    private Person(Person person) {
        this.firstName = person.getFirstName();
        this.middleName = person.getMiddleName();
        this.lastName = person.getLastName();
        this.age = person.getAge();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private final Person person = new Person();

        public Builder firstName(String firstName) {
            this.person.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.person.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.person.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.person.age = age;
            return this;
        }

        public Builder name(Name name) {
            this.person.firstName = name.getFirstName();
            this.person.middleName = name.getMiddleName();
            this.person.lastName = name.getLastName();
            return this;
        }

        //a new person is created here so that if a method in this instance of the Builder is called it will not change the value of the Person being returned.
        public Person build() {
            return new Person(person);
        }
    }
}
