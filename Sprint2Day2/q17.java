import java.util.*;
import java.util.stream.Collectors;

class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() { return city; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

public class AddressSorter {
    public static List<Address> sortAddresses(List<Address> addresses) {
        Comparator<Address> comparator = Comparator.comparing(Address::getCity)
                                                   .thenComparing(Address::getCountry);

        return addresses.stream()
                        .sorted(comparator)
                        .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Address> addresses = Arrays.asList(
            new Address("Paris", "France"),
            new Address("Lyon", "France"),
            new Address("Berlin", "Germany"),
            new Address("Munich", "Germany"),
            new Address("Paris", "USA")
        );

        List<Address> sorted = sortAddresses(addresses);
        sorted.forEach(System.out::println);
    }
}
