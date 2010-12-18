package ServerCode.Factory;

import ServerCode.Factory.Composite.Decorator.GraphicsCard;
import ServerCode.Factory.Composite.Decorator.HardDrive;
import ServerCode.Factory.Composite.Decorator.Ram;
import ServerCode.Utilities.*;
import ServerCode.Factory.Composite.*;


/**
 *
 * @author User
 */
public class LaptopFactory extends AbstractFactory {

    private AbstractComponent cpu, ram, soundcard, keyboard, screen, powerunit, harddrive, graphicscard;
    private Composite motherboard, chassis, computer;

    /**
     * Constructor for laptop product family
     * @param config used to specify configuration for product type
     * @return a composite product representing a computer
     */
    public Composite instantiateComputer(Configurations config) {


        switch (config) {
            case GAMING: {
                return createGamingLaptop();
            }
            case STANDARD: {
                return createStandardLaptop();
            }
            default: {
                return createStandardLaptop();
            }
        }

    }

    //create Gaming configuration of product
    private Composite createGamingLaptop() {

        //instantiate components
        chassis = new Composite(ComponentType.CHASSIS, 20);
        motherboard = new Composite(ComponentType.MOTHERBOARD, 30);
        harddrive = new HardDrive(ComponentType.HARDDRIVE, 80, 200);
        powerunit = new PowerUnit(ComponentType.POWERUNIT, 20);
        ram = new Ram(ComponentType.RAM, 15, 2);
        graphicscard = new GraphicsCard(ComponentType.GRAPHICSCARD, 40);
        soundcard = new SoundCard(ComponentType.SOUNDCARD, 25);
        cpu = new Cpu(ComponentType.CPU, 30);
        keyboard = new Keyboard(ComponentType.KEYBOARD, 15);
        screen = new Monitor(ComponentType.MONITOR, 30);
        computer = new Composite(ComponentType.COMPUTER, 0);

        //add components to composite lists and create parent refs.
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

    //create Standard version
    private Composite createStandardLaptop() {

        //instantiate components
        chassis = new Composite(ComponentType.CHASSIS, 20);
        motherboard = new Composite(ComponentType.MOTHERBOARD, 30);
        harddrive = new HardDrive(ComponentType.HARDDRIVE, 50, 100);
        powerunit = new PowerUnit(ComponentType.POWERUNIT, 20);
        ram = new Ram(ComponentType.RAM, 10, 1);
        graphicscard = new GraphicsCard(ComponentType.GRAPHICSCARD, 40);
        soundcard = new SoundCard(ComponentType.SOUNDCARD, 25);
        cpu = new Cpu(ComponentType.CPU, 30);
        keyboard = new Keyboard(ComponentType.KEYBOARD, 15);
        screen = new Monitor(ComponentType.MONITOR, 30);
        computer = new Composite(ComponentType.COMPUTER, 0);

        //add components to composite lists and create parent refs.
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
