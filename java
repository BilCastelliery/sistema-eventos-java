import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class EventService {
    private final Storage storage;
    private final List<Event> events;

    public EventService(String filename) {
        this.storage = new Storage(filename);
        this.events = new ArrayList<>(storage.loadEvents());
        // Ordena por data/hora asc ao carregar (qualquer listagem pode reordenar de novo)
        this.events.sort(Comparator.comparing(Event::getDateTime));
    }

    public void save() { storage.saveEvents(events); }

    public Event addEvent(String name, String address, String city, Category category,
                          LocalDateTime dateTime, String description) {
        Event e = new Event(null, name, address, city, category, dateTime, description);
        events.add(e);
        events.sort(Comparator.comparing(Event::getDateTime));
        save();
        return e;
    }

    public List<Event> listAll() {
        return Collections.unmodifiableList(events);
    }

    public Optional<Event> findByIdPrefix(String idPrefix) {
        String p = idPrefix.toLowerCase();
        return events.stream().filter(e -> e.getId().toString().toLowerCase().startsWith(p)).findFirst();
    }

    public List<Event> upcomingSorted(LocalDateTime now) {
        return events.stream()
                .filter(e -> !e.isPast(now))
                .sorted(Comparator.comparing(Event::getDateTime))
                .collect(Collectors.toList());
    }

    public List<Event> ongoing(LocalDateTime now) {
        return events.stream().filter(e -> e.isOngoing(now)).collect(Collectors.toList());
    }

    public List<Event> past(LocalDateTime now) {
        return events.stream().filter(e -> e.isPast(now)).sorted(Comparator.comparing(Event::getDateTime).reversed()).collect(Collectors.toList());
    }

    public List<Event> byCity(String city) {
        return events.stream().filter(e -> e.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }

    public List<Event> byCategory(Category c) {
        return events.stream().filter(e -> e.getCategory() == c).collect(Collectors.toList());
    }
}
