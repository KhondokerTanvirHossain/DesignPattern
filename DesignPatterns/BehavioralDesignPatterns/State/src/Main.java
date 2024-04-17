package DesignPatterns.BehavioralDesignPatterns.State.src;

interface State {
    void clickLock();
    void clickPlay();
    void clickNext();
    void clickPrevious();
}

class AudioPlayer {
    private State state;
    // Other fields like UI, volume, playlist, currentSong can be added here

    public AudioPlayer() {
        this.state = new ReadyState(this);
        // Initialize other fields here
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void clickLock() {
        state.clickLock();
    }

    public void clickPlay() {
        state.clickPlay();
    }

    public void clickNext() {
        state.clickNext();
    }

    public void clickPrevious() {
        state.clickPrevious();
    }

    // Other methods like startPlayback, stopPlayback, nextSong, previousSong, fastForward, rewind can be added here
}

class LockedState implements State {
    private AudioPlayer player;

    public LockedState(AudioPlayer player) {
        this.player = player;
    }

    public void clickLock() {
        // Implement behavior here
    }

    public void clickPlay() {
        // Implement behavior here
    }

    public void clickNext() {
        // Implement behavior here
    }

    public void clickPrevious() {
        // Implement behavior here
    }
}

class ReadyState implements State {
    private AudioPlayer player;

    public ReadyState(AudioPlayer player) {
        this.player = player;
    }

    public void clickLock() {
        // Implement behavior here
    }

    public void clickPlay() {
        // Implement behavior here
    }

    public void clickNext() {
        // Implement behavior here
    }

    public void clickPrevious() {
        // Implement behavior here
    }
}

class PlayingState implements State {
    private AudioPlayer player;

    public PlayingState(AudioPlayer player) {
        this.player = player;
    }

    public void clickLock() {
        // Implement behavior here
    }

    public void clickPlay() {
        // Implement behavior here
    }

    public void clickNext() {
        // Implement behavior here
    }

    public void clickPrevious() {
        // Implement behavior here
    }
}

public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.clickPlay();
        player.clickNext();
        // Add more interactions here
    }
}
