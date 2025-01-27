package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void profilesAdd() {
        Address address = new Address("Moscow", "Lenina", 8, 13);
        Address address2 = new Address("Moscow", "Kirova", 243, 1);
        Profiles profiles = new Profiles();
        List<Profile> profile = new ArrayList<>();
        profile.add(new Profile(address));
        profile.add(new Profile(address2));
        List<Address> rsl = profiles.collect(profile);
        List<Address> expected = List.of(
                new Address("Moscow", "Lenina", 8, 13),
                new Address("Moscow", "Kirova", 243, 1)
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void profileSort() {
        Address address = new Address("Moscow", "Lenina", 8, 13);
        Address address2 = new Address("Moscow", "Lenina", 243, 1);
        Address address3 = new Address("Moscow", "Lenina", 243, 1);
        Address address4 = new Address("Abakan", "Lenina", 243, 1);
        Profiles profiles = new Profiles();
        List<Profile> profile = new ArrayList<>();
        profile.add(new Profile(address));
        profile.add(new Profile(address2));
        profile.add(new Profile(address3));
        profile.add(new Profile(address4));
        List<Address> rsl = profiles.collect(profile);
        List<Address> expected = List.of(
                new Address("Abakan", "Lenina", 243, 1),
                new Address("Moscow", "Lenina", 8, 13),
                new Address("Moscow", "Lenina", 243, 1)
        );
        assertThat(rsl, is(expected));
    }
}