package ServerCode.Factory.Composite.Decorator;

import ServerCode.Utilities.ComponentType;
import ServerCode.Factory.Composite.AbstractComponent;
import ServerCode.Factory.Composite.AbstractHardDrive;
import java.util.List;

/**
 *
 * @author User
 */
public class HardDrive extends AbstractHardDrive {

    private int _cost, _size;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     *
     * @param size
     * @param cost
     * @param basetype
     */
    public HardDrive(ComponentType basetype, int cost, int size) {
        _size = size;
        _cost = cost;
        _name = basetype;

    }

    public int getSize() {
        return _size;
    }

    /**
     *
     */
    /**
     *
     * @return
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
    public void remove(AbstractComponent component) {
        _parent.remove(this);
        setParent(null);
        
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
        _parent = parent;
    }

    /**
     *
     * @return
     */
    public AbstractComponent getParent() {
        return _parent;
    }
}
