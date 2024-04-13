package DesignPatterns.StructuralDesignPatterns.Bridge.src;

// The "implementation" interface declares methods common to all concrete implementation classes.
interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}

// All devices follow the same interface.
class Tv implements Device {

    private boolean on = false;
    private int volume = 30;
    private int channel = 1;
    
    // ...
    @Override
    public void enable() {
        on = true;
        System.out.println("TV is enabled");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("TV is disabled");
    }

    @Override
    public void setVolume(int volume) {
        // ...
        System.out.println("TV volume set to " + this.volume);
    }

    @Override
    public void setChannel(int channel) {
        // ...
        System.out.println("TV channel set to " + this.channel);
    }

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public int getChannel() {
        return this.channel;
    }
}

class Radio implements Device {

    private boolean on = false;
    private int volume = 50;
    private int channel = 1;
    
    // ...
    @Override
    public void enable() {
        on = true;
        System.out.println("Radio is enabled");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio is disabled");
    }

    @Override
    public void setVolume(int volume) {
        // ...
        System.out.println("Radio volume set to " + this.volume);
    }

    @Override
    public void setChannel(int channel) {
        // ...
        System.out.println("Radio channel set to " + this.channel);
    }

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public int getChannel() {
        return this.channel;
    }
}
// The "abstraction" defines the interface for the "control" part of the two class hierarchies.
class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }
    
    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
            System.out.println("Powering down");
        } else {
            device.enable();
            System.out.println("Powering up");
        }
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
        System.out.println("Volume down");
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
        System.out.println("Volume up");
    }

    public void channelDown() {
        device.setChannel(device.getChannel() - 1);
        System.out.println("Channel down");
    }

    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
        System.out.println("Channel up");
    }
}

// You can extend classes from the abstraction hierarchy independently from device classes.
class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}

// Somewhere in client code.
public class Main {
    public static void main(String[] args) {
        Device tv = new Tv();
        RemoteControl remote = new RemoteControl(tv);
        remote.togglePower();

        Device radio = new Radio();
        remote = new AdvancedRemoteControl(radio);
        remote.togglePower();
    }
}