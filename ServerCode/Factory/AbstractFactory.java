package ServerCode.Factory;

import ServerCode.Factory.Composite.Decorator.*;
import ServerCode.Utilities.*;
import ServerCode.Factory.Composite.*;

/**
 *
 * @author User
 */
public abstract class AbstractFactory {

    /**
     *
     * @param config Use configuration enum to choose which configuration you wish to generate
     * @return Composite object consisting of initiated product
     */
    protected abstract Composite instantiateComputer(Configurations config);

    /**
     * Instantiate base components
     * @param config Enum for configuration type for specifies product
     * @return Composite object consisting of initiated product
     */
    public Composite orderComputer(Configurations config) {
        return instantiateComputer(config);
    }

    /**
     * Add additional items to the product
     * @param computer pass the product to be decorated
     * @param decorator type of additional component to be added
     */
    public void decorate(Composite computer, Decoratable decorator) {
        switch (decorator) {
            case RAM: {
                //recursively traverse tree to find obj to be decorated
                Ram baseram = (Ram) computer.find(ComponentType.RAM);
                int size = baseram.getSize();
                int cost = baseram.getCost();
                //maintain reference to parent obj.
                AbstractComponent parent = baseram.getParent();
                //remove links.
                baseram.remove(parent);
                //decorate object.
                CustomisableRam ramwrapper = new CustomisableRam(baseram, cost, size);
                //remove initial parent ref
                baseram.setParent(ramwrapper);
                //update ref to wrapper
                parent.add(ramwrapper);
                break;
            }
            case GRAPHICSCARD: {
                GraphicsCard basecard = (GraphicsCard) computer.find(ComponentType.GRAPHICSCARD);
                int cost = basecard.getCost();
                AbstractComponent parent = basecard.getParent();
                basecard.remove(parent);
                CustomisableGraphicsCard cardwrapper = new CustomisableGraphicsCard(basecard, cost);
                cardwrapper.setParent(parent);
                parent.add(cardwrapper);
                break;
            }
            case HARDDRIVE: {
                HardDrive basedrive = (HardDrive) computer.find(ComponentType.HARDDRIVE);
                int cost = basedrive.getCost();
                int size = basedrive.getSize();
                AbstractComponent parent = basedrive.getParent();
                basedrive.remove(parent);
                CustomisableHardDrive cardwrapper = new CustomisableHardDrive(basedrive, cost, size);
                cardwrapper.setParent(parent);
                parent.add(cardwrapper);
                break;
            }
        }
    }

    /**
     * Reset Component to base configuration, removes decoration
     * @param computer pass the product to be reset.
     * @param decorator type of decoration to be removed
     */
    public void removeDecoration(Composite computer, Decoratable decorator) {
        switch (decorator) {
            case RAM: {
                //find Ram recursively
                CustomisableRam ram = (CustomisableRam) computer.find(ComponentType.RAM);
                //find parent component, may not have decoration
                AbstractComponent motherboard = computer.find(ComponentType.MOTHERBOARD);
                //remove from list of components
                motherboard.remove(ram);
                //initial check to find base.
                boolean found = false;
                //used to hlod base ref to be use for reinititalisation.
                Ram baseram = null;
                while (!found) {
                    //if decorated ram
                    if (ram instanceof CustomisableRam) {
                        //found base
                        if (!(ram.getbase() instanceof Ram)) {
                            //cast to correct type
                            baseram = (Ram) ram.getbase();
                        }
                    }
                }
                motherboard.add((baseram));
            }
            case HARDDRIVE: {
                CustomisableHardDrive harddrive = (CustomisableHardDrive) computer.find(ComponentType.RAM);
                AbstractComponent motherboard = computer.find(ComponentType.MOTHERBOARD);
                motherboard.remove(harddrive);
                boolean found = false;
                while (!found) {

                    if (harddrive instanceof CustomisableHardDrive) {
                        if (!(harddrive.getbase() instanceof Ram)) {
                            harddrive = (CustomisableHardDrive) harddrive.getbase();
                        }
                    } else {
                        motherboard.add((HardDrive) harddrive.getbase());
                        found = true;
                    }
                }
            }
            case GRAPHICSCARD: {
                CustomisableGraphicsCard graphicscard = (CustomisableGraphicsCard) computer.find(ComponentType.RAM);
                AbstractComponent motherboard = computer.find(ComponentType.MOTHERBOARD);
                motherboard.remove(graphicscard);
                boolean found = false;
                while (!found) {

                    if (graphicscard instanceof CustomisableGraphicsCard) {
                        if (!(graphicscard.getbase() instanceof Ram)) {
                            graphicscard = (CustomisableGraphicsCard) graphicscard.getbase();
                        }
                    } else {
                        motherboard.add((GraphicsCard) graphicscard.getbase());
                        found = true;
                    }
                }
            }
        }

    }
}
