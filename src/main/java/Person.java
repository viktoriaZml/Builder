import java.util.Objects;

public class Person {
  protected final String name;
  protected final String surname;
  protected int age;
  protected boolean hasAge = false;
  protected String address;

  public Person(String name, String surname, int age, String address) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.address = address;
    if (age > 0)
      hasAge = true;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return name +
            " " + surname +
            " (возраст=" + (age == 0 ? "неизвестен" : age) +
            ", город=" + (address == null ? "неизвестен" : address) + ")";
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, age, address);
  }

  public boolean hasAge() {
    return hasAge;
  }

  public boolean hasAddress() {
    if (address != null)
      return true;
    return false;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void happyBirthday() {
    if (hasAge)
      age += 1;
  }

  public PersonBuilder newChildBuilder() {
    return new PersonBuilder().setSurname(surname).setAddress(address);
  }
}
