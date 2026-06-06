package Lesson10;

import java.util.Objects;

/**
 * @author Ирина Мизгир
 * @date 04.04.2026 14:14
 */
public class User implements Cloneable {

    private final int id;
    private final String name;
    private final int age;
    private final String email;
    private final Address address;

    public User(int id, String name, int age, String email, Address address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        return id == user.id
                && age == user.age
                && Objects.equals(name, user.name)
                && Objects.equals(email, user.email)
                && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public User deepClone() throws CloneNotSupportedException {
        User cloneUser = clone();
        return new User(cloneUser.id, cloneUser.name, cloneUser.age, cloneUser.email, address.clone());
    }
}
