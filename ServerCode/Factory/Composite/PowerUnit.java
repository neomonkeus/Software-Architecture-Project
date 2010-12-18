package ServerCode.Factory.Composite;

import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public class PowerUnit extends AbstractPowerUnit {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     *
     * @param basecost
     * @param basetype
     */
    public PowerUnit(ComponentType basetype, int basecost) {
        _cost = basecost;
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
     * @param component
     */
    public void add(AbstractComponent component) {
        setParent(component);
    }

    /**
     *
     */
    public void remove(AbstractComponent parent) {
        parent.remove(this);
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
     * @return
     */
    public AbstractComponent getParent() {
        return _parent;
    }

    /**
     * 
     * @param parent
     */
    private void setParent(AbstractComponent parent) {
        _parent = parent;
    }
}
