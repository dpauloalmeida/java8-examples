package br.com.k19.java8.cap6;

import br.com.k19.java8.util.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

// method reference
public class Cap6 {
    public static void main(String[] args) {
        User user1 = new User("Danilo Almeida", 150);
        User user2 = new User("Diogo Almeida", 120);
        User user3 = new User("Daniele Almeida", 190);
        List<User> users = Arrays.asList(user1, user2, user3);

        users.forEach(User::becomeModerator);

        users.sort(Comparator.comparing(User::getName));

        Function<User, String> byName = User::getName;
        users.sort(Comparator.comparing(byName));

        users.sort(Comparator.comparingInt(User::getPoints).thenComparing(User::getName));
        System.out.println();
        users.forEach(user -> System.out.println(user.getName()));

        // null end list
        users.sort(Comparator.nullsLast(Comparator.comparing(User::getName)));

        // null start list
        users.sort(Comparator.nullsFirst(Comparator.comparing(User::getName)));

        // inverse order
        users.sort(Comparator.comparingInt(User::getPoints).reversed());
        System.out.println();
        users.forEach(user -> System.out.println(user.getName()));

        // reference method receive argument
        System.out.println();
        users.forEach(System.out::println);

        // reference constructor without argument
        Supplier<User> createUserWithoutArgument = User::new;
        User userWithoutArgument = createUserWithoutArgument.get();

        // reference constructor with argument
        BiFunction<String, Integer, User> createUserWithArgument = User::new;
        User danilo = createUserWithArgument.apply("Danilo", 50);
        System.out.println();
        System.out.println(danilo);

    }
}

@FunctionalInterface
interface Supplier<T> {
    T get();
}
