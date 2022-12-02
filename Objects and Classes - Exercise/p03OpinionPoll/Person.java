package p03OpinionPoll;

public class Person {

    //полета -> характеристики -> име и възраст
    private String name;
    private int age;

    //конструктор -> създаваме обекти от класа
    public Person (String name, int age) {
        //нов обект
        this.name = name;
        this.age = age;
    }

    //getter -> метод чрез който достъпваме стойност на поле
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

}
