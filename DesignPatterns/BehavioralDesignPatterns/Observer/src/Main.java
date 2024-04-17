package DesignPatterns.BehavioralDesignPatterns.Observer.src;

import java.util.*;

interface EventListener {
    void update(String filename);
}

class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        if (users == null) {
            users = new ArrayList<>();
            listeners.put(eventType, users);
        }
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        if (users != null) {
            users.remove(listener);
        }
    }

    public void notify(String eventType, String data) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(data);
        }
    }
}

class Editor {
    public EventManager events;
    private String file;

    public Editor() {
        this.events = new EventManager();
    }

    public void openFile(String path) {
        this.file = path;
        events.notify("open", file);
    }

    public void saveFile() {
        events.notify("save", file);
    }
}

class LoggingListener implements EventListener {
    private String log;
    private String message;

    public LoggingListener(String log, String message) {
        this.log = log;
        this.message = message;
    }

    public void update(String filename) {
        System.out.println(log + ": " + message.replace("%s", filename));
    }
}

class EmailAlertsListener implements EventListener {
    private String email;
    private String message;

    public EmailAlertsListener(String email, String message) {
        this.email = email;
        this.message = message;
    }

    public void update(String filename) {
        System.out.println("Email sent to " + email + ": " + message.replace("%s", filename));
    }
}

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();

        LoggingListener logger = new LoggingListener("/path/to/log.txt", "Someone has opened the file: %s");
        editor.events.subscribe("open", logger);

        EmailAlertsListener emailAlerts = new EmailAlertsListener("admin@example.com", "Someone has changed the file: %s");
        editor.events.subscribe("save", emailAlerts);

        editor.openFile("test.txt");
        editor.saveFile();
    }
}
