package ServerCode.Factory;

import ServerCode.Factory.Composite.Decorator.GraphicsCard;
import ServerCode.Factory.Composite.Decorator.Ram;
import ServerCode.Factory.Composite.Decorator.HardDrive;
import ServerCode.Utilities.*;
import ServerCode.Factory.Composite.*;

/**
 *
 * @author User
 */
public class DesktopFactory extends AbstractFactory {

    private AbstractComponent cpu, ram, soundcard, keyboard, screen, powerunit, harddrive, graphicscard;
    private Composite chassis, computer, motherboard;
    private int _cost;

    /**
    * Constructor for laptop product family
    * @param config used to specify configuration for product type
    * @return a composite product representing a computer
    */
    public Composite instantiateComputer(Configurations config) {
        switch (config) {
            case GAMING: {
                return createGamingDesktop();
            }
            case STANDARD: {
                return createStandardDesktop();
            }
            default: {
                return createStandardDesktop();
            }
        }

    }

    private Composite createGamingDesktop() {

        //Instantiate components
        chassis = new Composite(ComponentType.CHASSIS, 20);
        motherboard = new Composite(ComponentType.MOTHERBOARD, 30);
        harddrive = new HardDrive(ComponentType.HARDDRIVE, 100, 300);
        powerunit = new PowerUnit(ComponentType.POWERUNIT, 20);
        ram = new Ram(ComponentType.RAM, 20, 4);
        graphicscard = new GraphicsCard(ComponentType.GRAPHICSCARD, 40);
        soundcard = new SoundCard(ComponentType.SOUNDCARD, 25);
        cpu = new Cpu(ComponentType.CPU, 30);
        keyboard = new Keyboard(ComponentType.KEYBOARD, 15);
        screen = new Monitor(ComponentType.MONITOR, 30);
        computer = new Composite(ComponentType.COMPUTER, 0);

        //create hierarchy, parent relationship
        motherboard.add(cpu);
        motherboard.add(ram);
        motherboard.add(graphicscard);
        motherboard.add(soundcard);

        chassis.add(motherboard);
        chassis.add(powerunit);
        chassis.add(harddrive);

        computer.add(chassis);
        computer.add(keyboard);
        computer.add(screen);

        return computer;
    }

    private Composite createStandardDesktop() {

        //Instantiate components
        chassis = new Composite(ComponentType.CHASSIS, 20);
        motherboard = new Composite(ComponentType.MOTHERBOARD, 30);
        harddrive = new HardDrive(ComponentType.HARDDRIVE, 50, 100);
        powerunit = new PowerUnit(ComponentType.POWERUNIT, 20);
        ram = new Ram(ComponentType.RAM, 15, 2);
        graphicscard = new GraphicsCard(ComponentType.GRAPHICSCARD, 40);
        soundcard = new SoundCard(ComponentType.SOUNDCARD, 25);
        cpu = new Cpu(ComponentType.CPU, 30);
        keyboard = new Keyboard(ComponentType.KEYBOARD, 15);
        screen = new Monitor(ComponentType.MONITOR, 30);
        computer = new Composite(ComponentType.COMPUTER, 0);

        //create hierarchy, parent relationship
        motherboard.add(ram);
        motherboard.add(graphicscard);
        motherboard.add(soundcard);
        motherboard.add(cpu);

        chassis.add(motherboard);
        chassis.add(powerunit);
        chassis.add(harddrive);

        computer.add(chassis);
        computer.add(keyboard);
        computer.add(screen);

        return computer;
    }
}
