public class Main {
  public static void main(String[] args) {
    Person mom = new PersonBuilder()
            .setName("Анна")
            .setSurname("Вольф")
            .setAge(31)
            .setAddress("Сидней")
            .build();
    Person son = mom.newChildBuilder()
            .setName("Антошка")
            .build();
    System.out.println("У " + mom + " есть сын " + son);
    mom.happyBirthday();
    son.happyBirthday();
    System.out.println("У " + mom + " есть сын " + son);
    Person person = new PersonBuilder()
            .setName("Анна")
            .setSurname("Петрова")
            .build();
    System.out.println(person);

    try {
      // Не хватает обяхательных полей
      new PersonBuilder().build();
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }

    try {
      // Возраст недопустимый
      new PersonBuilder().setAge(-100).build();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }
}
