package ServerCode.Factory.Composite;

import ServerCode.Factory.Composite.Decorator.HardDriveDecorator;
import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public abstract class AbstractHardDrive extends AbstractComponent {

    private int _cost, _size;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;
    /**
     *
     */
    public HardDriveDecorator myHardDriveDecorator;

    /**
     *
     * @return
     */
    public abstract int getSize();

    /**
     *
     * @return
     */
    /**
     *
     * @param component
     */
    public abstract void add(AbstractComponent component);

    /**
     *
     * @return
     */
    public abstract int getCost();

    /**
     *
     * @return
     */
    public abstract ComponentType getName();

    /**
     *
     * @return
     */
    public AbstractComponent getComposite() {
        return null;
    }

    /**
     *
     * @return
     */
    public abstract AbstractComponent getParent();

    /**
     *
     */
    public abstract void remove(AbstractComponent component);
}
