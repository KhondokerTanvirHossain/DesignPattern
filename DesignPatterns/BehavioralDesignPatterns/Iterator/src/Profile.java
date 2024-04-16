package DesignPatterns.BehavioralDesignPatterns.Iterator.src;

import java.util.List;
import java.util.ArrayList;

interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileId);
    ProfileIterator createCoworkersIterator(String profileId);
}

class Facebook implements SocialNetwork {
    // ... The bulk of the collection's code should go here ...

    // Iterator creation code.
    public ProfileIterator createFriendsIterator(String profileId) {
        return new FacebookIterator(this, profileId, "friends");
    }

    public ProfileIterator createCoworkersIterator(String profileId) {
        return new FacebookIterator(this, profileId, "coworkers");
    }

    public List<Profile> socialGraphRequest(String profileId, String type) {
        // For now, let's just return a dummy list of profiles.
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("2", "Jane Doe", "jane.doe@example.com", "Facebook"));
        profiles.add(new Profile("3", "Bob Smith", "bob.smith@example.com", "Facebook"));
        return profiles;
    }
}

public class Profile {
    private String id;
    private String name;
    private String email;
    private String network;

    public Profile(String id, String name, String email, String network) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.network = network;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNetwork() {
        return network;
    }
    
}

interface ProfileIterator {
    Profile getNext();
    boolean hasMore();
}

class FacebookIterator implements ProfileIterator {
    private Facebook facebook;
    private String profileId, type;
    private int currentPosition;
    private List<Profile> cache;

    public FacebookIterator(Facebook facebook, String profileId, String type) {
        this.facebook = facebook;
        this.profileId = profileId;
        this.type = type;
    }

    private void lazyInit() {
        if (cache == null) {
            cache = facebook.socialGraphRequest(profileId, type);
        }
    }

    public Profile getNext() {
        if (hasMore()) {
            return cache.get(currentPosition++);
        }
        return null;
    }

    public boolean hasMore() {
        lazyInit();
        return currentPosition < cache.size();
    }
}

class SocialSpammer {
    public void send(ProfileIterator iterator, String message) {
        while (iterator.hasMore()) {
            Profile profile = iterator.getNext();
            System.out.println("Sending email to " + profile.getEmail() + " with message: " + message);
        }
    }
}

class Application {
    private SocialNetwork network;
    private SocialSpammer spammer;

    public void config() {
        // if working with Facebook
        this.network = new Facebook();
        this.spammer = new SocialSpammer();
    }

    public void sendSpamToFriends(Profile profile) {
        ProfileIterator iterator = network.createFriendsIterator(profile.getId());
        spammer.send(iterator, "Very important message");
    }

    public void sendSpamToCoworkers(Profile profile) {
        ProfileIterator iterator = network.createCoworkersIterator(profile.getId());
        spammer.send(iterator, "Very important message");
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.config();
        Profile profile = new Profile("1", "John Doe", "john.doe@example.com", "Facebook");
        System.out.println("Sending spam to friends...");
        app.sendSpamToFriends(profile);
        System.out.println("Sending spam to coworkers...");
        app.sendSpamToCoworkers(profile);
    }
}