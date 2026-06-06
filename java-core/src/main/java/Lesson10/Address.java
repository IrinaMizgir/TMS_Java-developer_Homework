package Lesson10;

import java.util.Objects;

/**
 * @author Ирина Мизгир
 * @date 04.04.2026 15:29
 */
public class Address implements Cloneable {
    private final String street;
    private final String houseNumber;
    private final int apartmentNumber;

    public Address(String street, String houseNumber, int apartmentNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;

        return apartmentNumber == address.apartmentNumber
                && Objects.equals(street, address.street)
                && Objects.equals(houseNumber, address.houseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, houseNumber, apartmentNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", objectId='" + getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(this)) + '\'' +
                '}';
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}
