package ServerCode.Factory.Composite;

import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 * 
 * @author User
 */
public abstract class AbstractCPU extends AbstractComponent {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     * add parent ref
     * @param component parent component
     */
    public abstract void add(AbstractComponent component);

    /**
     * returns the cost of the component
     * @return base cost
     */
    public abstract int getCost();

    /**
     * Used for type checking and decoration
     * @return configuration enum for component type
     */
    public abstract ComponentType getName();

    /**
     * Use to check for base type
     * @return composite or null
     */
    public AbstractComponent getComposite() {
        return null;
    }

    /**
     * Use to maintain parent child referencing
     * @return parent composite of object
     */
    public abstract AbstractComponent getParent();

    /**
     * remove parent reference
     */
    public abstract void remove(AbstractComponent component);
}
