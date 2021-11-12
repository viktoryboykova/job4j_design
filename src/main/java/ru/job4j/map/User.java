package ru.job4j.map;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Date birthday;

    public User(String name, int children, Date birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1990, Calendar.DECEMBER, 10);
        Date date = Date.from(calendar2.toInstant());
        User user3 = new User("Олег", 2, date);
        User user4 = new User("Олег", 2, date);
        Map<User, Object> map2 = new HashMap<>();
        map2.put(user3, "object_1");
        map2.put(user4, "object_2");
        System.out.println("Переопределен только hashCode: " + map2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }
}
