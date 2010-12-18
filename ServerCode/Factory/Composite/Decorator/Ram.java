package ServerCode.Factory.Composite.Decorator;

import ServerCode.Factory.Composite.AbstractComponent;
import ServerCode.Factory.Composite.AbstractRam;
import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public class Ram extends AbstractRam {

    private int _size, _cost;
    private ComponentType _name;
    private AbstractComponent _parent;
    private List<ComponentType> components;

    /**
     *
     * @param size
     * @param cost
     * @param basetype
     */
    public Ram(ComponentType basetype, int cost, int size) {
        _size = size;
        _cost = cost;
        _name = basetype;

    }

    public int getSize() {
        return _size;
    }

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
     * @param parent
     */
    public void remove(AbstractComponent parent) {
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

    public AbstractComponent getParent() {
        return _parent;
    }

    /**
     *
     * @param parent
     */
    public void setParent(AbstractComponent parent) {
        _parent = (AbstractComponent) parent;
        System.out.println(this._name);
    }
}
