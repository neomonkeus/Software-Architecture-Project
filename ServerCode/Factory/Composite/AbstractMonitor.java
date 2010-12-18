package ServerCode.Factory.Composite;

import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public abstract class AbstractMonitor extends AbstractComponent {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     *
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
