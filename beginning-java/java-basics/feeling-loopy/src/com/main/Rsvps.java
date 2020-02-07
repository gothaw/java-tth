package com.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rsvps {

    public static String[] shuffled() {
        List<String> attendees = Arrays.asList(
                "August von Trapp", "Sara Jensen", "Mike Lindsay",
                "David Garber", "Nathan Brenner", "Carrie Scott",
                "Kathryn Peterson", "Hung Kha", "Kimberly Stanley",
                "Tim", "David D", "Adin", "Dan Nelson",
                "Mat Sanders", "Carlo", "Amoreena", "Andrea Anger", "Kristine",
                "Ivy Haller", "Adron Hall", "Mehequanna", "Stephen Emery",
                "Lee Zamastil", "Nic Hampton", "Jill Kuchman", "Michael",
                "Jack Cain", "Matt", "Treasure", "Michel", "Kegan", "Keith",
                "George Akinian", "Ryan Tinker", "Tessa", "Greg Kaleka",
                "Andrew VanVlack", "Randolph Judy", "amanda houle", "Jeff L.",
                "John Kuzda", "K VanOrman", "Ken W. Alger", "William DeHaven",
                "Brian Meyer", "Jocelyn Alsdorf",
                "Tom Holland", "Faddah Steve Yuetsu Wolf", "David Postlethwaite",
                "Jennifer.H", "Johnny Why", "Joy", "Aimee", "Molly Waggett",
                "Jen", "dan", "Ashley Sullins", "Juliana Suzuki", "derek shirk",
                "Marcus", "Zak Mac", "Jenn", "Dustin", "Nataliya",
                "Nathan Clevenger", "Chase Swanson", "John Broxton",
                "Raquel", "Judy", "Joni Carlson", "Jennifer L. Minetree",
                "Yvonne Peng", "Markus Gilham", "Virginia Lee Cherry",
                "Adam", "Sarah Long", "Beth van Elswyk", "Summer",
                "Maggie O'Neill", "Jeanette Fairless", "Ajay Arya",
                "PassPose", "Holly L", "Jesse James", "Simone Flore",
                "Eric Ewers");
        Collections.shuffle(attendees);
        return attendees.toArray(new String[0]);
    }

}
