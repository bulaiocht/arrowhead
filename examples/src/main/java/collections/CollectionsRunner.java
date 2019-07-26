package collections;

import generics.Person;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsRunner {

    public static void main(String[] args) {

//        listExample();

//        queueExample();

//        setExample();

//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("a", "a");
//        map.put("c", "b");
//        map.put("e", "c");
//        map.put("d", "d");
//        map.put("f", "e");
//        map.put("b", "f");
//
//        System.out.println(map.values());

        mapExample();
    }

    private static void setExample() {

        Set<Person> set = new HashSet<>();

        List<Person> people = personGenerator();

//        System.out.println("====List====");
//        System.out.println("List size: " + people.size());
//
//        people.forEach(System.out::println);

        set.addAll(people);

        System.out.println("====Set====");
        System.out.println("Set size: " + set.size());
//        set.forEach(System.out::println);

        TreeSet<Person> treeSet = new TreeSet<>(set);

        treeSet.forEach(System.out::println);

    }

    private static void queueExample() {

        LinkedList<Person> queue2 = new LinkedList<>();

        ArrayDeque<Person> queue3 = new ArrayDeque<>();

        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);

        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);

        List<Person> people = personGenerator();
//        System.out.println(people);

        PriorityQueue<Person> queueOne = new PriorityQueue<>(ageComparator);
        PriorityQueue<Person> queueTwo = new PriorityQueue<>(nameComparator);

        queueOne.addAll(people);
        queueTwo.addAll(people);

//        while (!queueOne.isEmpty()){
//            System.out.println(queueOne.poll());
//        }

//        while (!queueTwo.isEmpty()){
//            System.out.println(queueTwo.poll());
//        }

        Collections.sort(people, ageComparator);

        people.forEach(System.out::println);

        Collections.shuffle(people);

        people.forEach(System.out::println);

    }

    private static void listExample() {

        ArrayList<String> strings = new ArrayList<>(250);
        strings.add(10, "hello");
        strings.add(null);
        strings.add("hello");
        strings.add("hello");
        strings.trimToSize();

        Iterator<String> iterator = strings.iterator();
        iterator.next();
        iterator.hasNext();
        iterator.remove();
        iterator.forEachRemaining(System.out::println);

        for (String string : strings) {
            System.out.println(string);
        }

        strings.forEach(System.out::println);

        ListIterator<String> stringListIterator = strings.listIterator();

        while (stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
            stringListIterator.remove();
        }

        System.out.println(strings);
    }

    private static List<Person> personGenerator() {

        Random random = new Random();

        return Stream
                .generate(Person::new)
                .peek(person -> {
                    person.setAge(random.nextInt(50) + 10);
                    person.setName("Bill");
                })
                .limit(100)
                .collect(Collectors.toList());
    }

    private static void mapExample() {


        MyKey key = new MyKey("Value", 10);

        Map<MyKey, String> myKeyMap = new HashMap<>();

        myKeyMap.put(key, "Hello");

        System.out.println(myKeyMap.containsKey(key));
        System.out.println(myKeyMap.get(key));

        key.setNum(12);

        MyKey copyKey = new MyKey("Value", 10);

        System.out.println(myKeyMap.containsKey(copyKey));
        System.out.println(myKeyMap.get(copyKey));


        Map<DaysEnum, String> enumMap = new EnumMap<>(DaysEnum.class);

        enumMap.put(DaysEnum.MONDAY, "I hate Mondays");
        enumMap.put(DaysEnum.TUESDAY, "I hate Tuesdays");
        enumMap.put(DaysEnum.WEDNESDAY, "Ok, that's better");

        String s = enumMap.get(DaysEnum.MONDAY);

        Set<DaysEnum> enumSet = EnumSet.allOf(DaysEnum.class);

        List<Person> people = personGenerator();

        //Before streams
        Map<Integer, List<Person>> peopleByAgeBefore = new HashMap<>();
        for (final Person person : people) {
            int age = person.getAge();
            if (peopleByAgeBefore.containsKey(age)){
                peopleByAgeBefore.get(age).add(person);
            } else {
                List<Person> persons = new ArrayList<>();
                persons.add(person);
                peopleByAgeBefore.put(age, persons);
            }
        }

        //After streams
        Map<Integer, List<Person>> peopleByAge
                = people
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }

}
