package ServerCode.Factory.Composite;

import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public abstract class AbstractComponent {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     * Returns Base Cost for component
     * @return Component cost
     */
    public int getCost() {
        return _cost;
    }

    /**
     * Used for type checking
     * @return Enum of type component
     */
    public ComponentType getName() {
        return null;
    }

    /**
     * used to create parent relationship component
     * @param component parent
     */
    public abstract void add(AbstractComponent component);
    /**
     * used to remove parent relationship
     * @param component parent
     */
    public abstract void remove(AbstractComponent component);

    /**
     * used as composite check for casting
     * @return null or composite of self
     */
    public AbstractComponent getComposite() {
        return null;
    }
}
