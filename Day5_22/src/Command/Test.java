package Command;

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
        this.light.on();
    }
}

class LigthOffCommand implements Command {
    Light light;

    public LigthOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.off();
    }
}

class TvOnCommand implements Command {
    Tv tv;

    public TvOnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.on();
    }
}

class TvOffCommand implements Command {
    Tv tv;

    public TvOffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.off();
    }
}

class YaoKongQi {
    private Command[] commands;

    public YaoKongQi() {
        this.commands = new Command[button];
    }

    private final int button = 7;

    public void setCommands(Command commands, int a) {
        this.commands[a] = commands;
    }

    public void push(int a) {
        commands[a].execute();
    }
}

class Tv {
    void on() {
        System.out.println("电视打开了");
    }

    void off() {
        System.out.println("电视关闭了");
    }
}

class Light {
    void on() {
        System.out.println("灯打开了");
    }

    void off() {
        System.out.println("灯关了");
    }
}

public class Test {
    public static void main(String[] args) {
        YaoKongQi qi = new YaoKongQi();
        Light light = new Light();
        Tv tv = new Tv();
        qi.setCommands(new LightOnCommand(light), 1);
        qi.setCommands(new LigthOffCommand(light), 2);
        qi.setCommands(new TvOffCommand(tv), 4);
        qi.setCommands(new TvOnCommand(tv), 3);
        qi.push(1);
        qi.push(2);
        qi.push(3);
        qi.push(4);
    }
}
