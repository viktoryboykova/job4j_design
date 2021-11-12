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
        User user5 = new User("Степан", 2, date);
        User user6 = new User("Степан", 2, date);
        Map<User, Object> map3 = new HashMap<>();
        map3.put(user5, "object_1");
        map3.put(user6, "object_2");
        System.out.println("Переопределен только equals: " + map3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
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
