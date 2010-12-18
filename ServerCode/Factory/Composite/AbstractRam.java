package ServerCode.Factory.Composite;

import ServerCode.Factory.Composite.Decorator.RamDecorator;
import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public abstract class AbstractRam extends AbstractComponent {

    private int _size, _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;
    /**
     *
     */
    private RamDecorator myRamDecorator;

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
    @Override
    public abstract int getCost();

    /**
     *
     * @return
     */
    @Override
    public abstract ComponentType getName();

    /**
     *
     * @return
     */
    @Override
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
     * @param parent
     */
    public abstract void remove(AbstractComponent parent);

    /**
     *
     * @param parent
     */
    public abstract void setParent(AbstractComponent parent);
}
