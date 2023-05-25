package clowoodive.example.designpattern.structure;

interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int vol);

    void printStatus();
}

class Tv implements Device {
    private boolean on;

    private int volume = 30;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int vol) {
        if (vol > 100) {
            this.volume = 100;
        } else if (vol < 0) {
            this.volume = 0;
        } else {
            this.volume = vol;
        }
    }

    @Override
    public void printStatus() {
        System.out.println("---------------- TV ----------------");
        System.out.println("| Power is " + (on ? "enabled" : "disabled"));
        System.out.println("| Volume is " + volume + "%");
        System.out.println("------------------------------------\n");
    }
}

class Radio implements Device {
    private boolean on;

    private int volume = 30;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int vol) {
        if (vol > 100) {
            this.volume = 100;
        } else if (vol < 0) {
            this.volume = 0;
        } else {
            this.volume = vol;
        }
    }

    @Override
    public void printStatus() {
        System.out.println("--------------- Radio ---------------");
        System.out.println("| Power is " + (on ? "enabled" : "disabled"));
        System.out.println("| Volume is " + volume + "%");
        System.out.println("------------------------------------\n");
    }
}

interface Remote {
    void power();

    void volumeUp();

    void volumeDown();
}

class SimpleRemote implements Remote {
    protected Device device;

    public SimpleRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: volume down");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: volume up");
        device.setVolume(device.getVolume() - 10);
    }
}

class PremiumRemote extends SimpleRemote {

    public PremiumRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}

