package ServerCode.Factory.Composite;

import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public class Monitor extends AbstractMonitor {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     *
     * @param cost
     * @param basetype
     */
    public Monitor(ComponentType basetype, Integer cost) {
        _cost = cost;
        _name = basetype;
    }

    /**
     *
     */
    public int getCost() {
        return _cost;
    }

    /**
     *
     * @return
     */
    public ComponentType getName() {
        return _name;
    }

    /**
     *
     * @return
     */
    public AbstractComponent getComposite() {
        return null;
    }

    /**
     *
     * @param parent
     */
    private void setParent(AbstractComponent parent) {
        _parent = (AbstractComponent) parent;
    }

    /**
     *
     * @return
     */
    public AbstractComponent getParent() {
        return _parent;
    }

    /**
     *
     * @param component
     */
    public void add(AbstractComponent component) {
        setParent(component);
    }

    /**
     *
     */
    public void remove(AbstractComponent component) {
        setParent(null);
    }
}
