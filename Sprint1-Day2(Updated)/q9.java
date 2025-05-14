import java.util.*;

class Event {
    String title;
    String time;
    String description;

    public Event(String title, String time, String description) {
        this.title = title;
        this.time = time;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Time: " + time + ", Description: " + description;
    }
}

public class EventCalendar {
    private static final TreeMap<String, List<Event>> calendar = new TreeMap<>();

    public static void addEvent(String date, String title, String time, String description) {
        Event newEvent = new Event(title, time, description);
        calendar.putIfAbsent(date, new ArrayList<>());
        calendar.get(date).add(newEvent);
        System.out.println("Event added successfully.");
    }

    public static void removeEvent(String date, String title) {
        if (calendar.containsKey(date)) {
            List<Event> events = calendar.get(date);
            boolean removed = events.removeIf(event -> event.title.equalsIgnoreCase(title));
            if (removed) {
                System.out.println("Event removed successfully.");
            } else {
                System.out.println("Event with title \"" + title + "\" not found on " + date);
            }
        } else {
            System.out.println("No events found for the date: " + date);
        }
    }

    public static void displayEventsForDate(String date) {
        if (calendar.containsKey(date)) {
            System.out.println("Events on " + date + ":");
            for (Event event : calendar.get(date)) {
                System.out.println(event);
            }
        } else {
            System.out.println("No events scheduled for " + date);
        }
    }

    public static void displayUpcomingEvents() {
        if (calendar.isEmpty()) {
            System.out.println("No events scheduled.");
            return;
        }

        System.out.println("\nUpcoming Events:");
        for (Map.Entry<String, List<Event>> entry : calendar.entrySet()) {
            String date = entry.getKey();
            System.out.println("\nOn " + date + ":");
            for (Event event : entry.getValue()) {
                System.out.println(event);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Event Calendar Menu ---");
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Display Events for a Date");
            System.out.println("4. Display Upcoming Events");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter event title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter event time: ");
                    String time = scanner.nextLine();
                    System.out.print("Enter event description: ");
                    String description = scanner.nextLine();
                    addEvent(date, title, time, description);
                    break;

                case 2:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String removeDate = scanner.nextLine();
                    System.out.print("Enter event title to remove: ");
                    String removeTitle = scanner.nextLine();
                    removeEvent(removeDate, removeTitle);
                    break;

                case 3:
                    System.out.print("Enter date (YYYY-MM-DD) to view events: ");
                    String viewDate = scanner.nextLine();
                    displayEventsForDate(viewDate);
                    break;

                case 4:
                    displayUpcomingEvents();
                    break;

                case 5:
                    System.out.println("Exiting the Event Calendar.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        } while (option != 5);

        scanner.close();
    }
}
