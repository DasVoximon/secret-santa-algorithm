package com.dasvoximon.project;

import lombok.Data;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Data
public class SecretSantaMatcher {

    public List<Student> students() {
        List<Student> studentsList = new ArrayList<>();

        studentsList.add(new Student("Tunde", "M", "2348140449072"));
        studentsList.add(new Student("Tobiloba", "M", "2348114779597"));
        studentsList.add(new Student("Maverick", "M", "2348021293940"));
        studentsList.add(new Student("Warith", "M", "2347049958006"));
        studentsList.add(new Student("Nayuma", "F", "2347040379249"));
        studentsList.add(new Student("Dauda", "M", "2349165187961"));
        studentsList.add(new Student("Qawi", "M", "+2347039451271"));
        studentsList.add(new Student("Mayokun", "M", "2347049643200"));
        studentsList.add(new Student("Elderly", "M", "2348088682096"));
        studentsList.add(new Student("Hillary", "F", "2349153231708"));
        studentsList.add(new Student("Precious", "F", "2348028226282"));
        studentsList.add(new Student("Faith", "F", "2348106606997"));
        studentsList.add(new Student("Oyin", "F", "2349084236961"));
        studentsList.add(new Student("Carl", "M", "2348148993222"));
        studentsList.add(new Student("Rahmat", "F", "2348169400610"));
        studentsList.add(new Student("Mubi", "M", "2347017322870"));
        studentsList.add(new Student("Skynet", "M", "2348160188549"));
        studentsList.add(new Student("Sharon", "M", "2349135228851"));
        studentsList.add(new Student("Fauzia", "F", "2349065213952"));
        studentsList.add(new Student("Joan", "F", "2348124336254"));
        studentsList.add(new Student("Ibrahim", "M", "2349152764327"));
        studentsList.add(new Student("Fareed", "M", "2349060289772"));
        studentsList.add(new Student("Oladayo", "M", "2349161349654"));
        studentsList.add(new Student("Wills", "M", "2348060104643"));

        return studentsList;
    }

    public void studentsCounter(List<Student> students) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Size of students: " + students.size());

        int maleCount = 0;
        int femaleCount = 0;

        for (Student s : students) {
            if (s.gender.equals("M")) {
                maleCount++;
            } else if (s.gender.equals("F")) {
                femaleCount++;
            }
        }

        System.out.println("Total Males: " +  maleCount);
        System.out.println("Total Females: " +  femaleCount);

        if (femaleCount > maleCount) {
            System.out.println("ERROR: Logic Impossible");
            System.out.println("Female cannot be more than males. Males must be more than Females");
            System.exit(1);
        } else {
            System.out.println("Status: OK. Proceeding to matching....");
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    public void generatePairs(List<Student> students) {
        Stack<Student> males = new Stack<>();
        Stack<Student> females = new Stack<>();

        // 1. Bucket the students
        for (Student s : students) {
            if (s.gender.equalsIgnoreCase("M")) males.push(s);
            else females.push(s);
        }

//        if (females.size() > males.size()) {
//            System.out.println("ERROR: Not enough males to separate the females.");
//            return;
//        }

        // 2. Shuffle for randomness
        Collections.shuffle(males);
        Collections.shuffle(females);

        // 3. Build the Ordered Chain
        List<Student> chain = new ArrayList<>();

        // Objective 1 & 2: Alternate F and M to prevent F-F
        while (!females.isEmpty()) {
            chain.add(females.pop()); // Add F
            chain.add(males.pop());   // Add M
        }

        // Objective 3: Add remaining Males (M-M pairing allowed here)
        while (!males.isEmpty()) {
            chain.add(males.pop());
        }

        // 4. Execution: Create the Circular Assignments
        System.out.println("--- SECRET SANTA ---");

        for (int i = 0; i < chain.size(); i++) {
            Student giver = chain.get(i);
            Student receiver;

            // If we are at the last person, they give to the FIRST person.
            // Objective 4: This ensures the last person (likely M) gives to the first (Guaranteed F).
            if (i == chain.size() - 1) {
                receiver = chain.getFirst();
            } else {
                receiver = chain.get(i + 1);
            }

            // sendWhatsappLink(giver, receiver);
            sendReminder(giver);
        }
    }

    private void sendWhatsappLink(Student giver, Student receiver) {
        String message = "Hello " + giver.name + ", \uD83C\uDF85\n" +
                "You have been assigned " + receiver.name + " as your Secret Santa recipient. Please prepare a thoughtful gift \uD83C\uDF81.";

        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
        String whatsappUrl = "https://wa.me/" + giver.contactInfo + "?text=" + encodedMessage;

        System.out.println("To: " + giver.name + " (" + giver.gender + ")");
        System.out.println("   Target: " + receiver.name + " (" + receiver.gender + ")");
        System.out.println("   LINK: " + whatsappUrl);
        System.out.println("--------------------------------------------------");

        // System.out.println(message);

    }

    private void sendReminder(Student giver) {
        String message = "Reminder 🎁\n" +
                "If you haven't gotten your gift yet, now's the time to start!\n" +
                "Secret Santa gifting holds on 15th January. Don't be the one without a gift 😏";

        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
        String whatsappUrl = "https://wa.me/" + giver.contactInfo + "?text=" + encodedMessage;

        System.out.println("To: " + giver.name);
        System.out.println("   LINK: " + whatsappUrl);
        System.out.println("--------------------------------------------------");

//        System.out.println(message);

    }
}
