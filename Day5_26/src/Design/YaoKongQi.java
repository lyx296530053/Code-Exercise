package Design;

interface Command {
    void execute();
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class OffCommand implements Command {
    Light light;

    public OffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class Light {
    void on() {
        System.out.println("灯打开了");
    }

    void off() {
        System.out.println("灯灭了");
    }
}

class Invoke {
    Command[] commands;
    final int button = 2;


    public Invoke() {
        this.commands = new Command[button];
    }

    void setCommands(Command commands, int slot) {
        this.commands[slot] = commands;
    }

    void setButton(int button) {
        commands[button].execute();
    }
}

public class YaoKongQi {
    public static void main(String[] args) {
        Light light=new Light();
        Invoke invoke = new Invoke();
        invoke.setCommands(new LightOnCommand(light),1);
        invoke.setCommands(new OffCommand(light),0);
        invoke.setButton(0);
    }
}
