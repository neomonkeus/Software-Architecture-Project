package ServerCode.Factory.Composite.Decorator;

import ServerCode.Utilities.ComponentType;
import ServerCode.Factory.Composite.AbstractComponent;
import java.util.List;

/**
 *
 * @author User
 */
public class CustomisableRam extends RamDecorator {

    private int _cost, _size;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;
    private Ram _basereference;

    /**
     *
     * @param r
     * @param size
     * @param cost
     */
    public CustomisableRam(Ram r, int cost, int size) {
        super(r);
        _basereference = r;
        _size = size;
        _cost = cost;
        _parent = r.getParent();
        _name = r.getName();
        add();
    }

    /**
     *
     * @return
     */
    @Override
    public int getCost() {
        int totalcost = _basereference.getCost();
        return totalcost + _cost;
    }

    /**
     *
     * @return
     */
    @Override
    public int getSize() {
        int totalsize = _basereference.getSize();
        return totalsize + _size;
    }

    /**
     *
     */
    public final void add() {
        _basereference.setParent(this);
    }

    /**
     *
     * @return
     */
    @Override
    public ComponentType getName() {
        return _name;
    }

    /**
     *
     * @param component
     */
    @Override
    public void add(AbstractComponent component) {
        setParent(component);
    }

    /**
     *
     */
    public void remove() {
        _basereference = null;
        _parent = null;
    }

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
    @Override
    public AbstractComponent getParent() {
        return _parent;
    }

    /**
     *
     * @param parent
     */
    @Override
    public void setParent(AbstractComponent parent) {
        _parent = (AbstractComponent) parent;
    }

    /**
     *
     * @return
     */
    public AbstractComponent getbase() {
        return _basereference;
    }
}
