package ServerCode.Factory.Composite.Decorator;

import ServerCode.Factory.Composite.AbstractComponent;
import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public class CustomisableHardDrive extends HardDriveDecorator {

    private int _cost, _size;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;
    private HardDrive _basereference;

    /**
     *
     * @param hd
     * @param size
     * @param cost
     */
    public CustomisableHardDrive(HardDrive hd, int cost, int size) {
        super(hd);
        _basereference = hd;
        _size = size;
        _cost = cost;
        _parent = hd.getParent();
        _name = hd.getName();
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
        _basereference.add(this);
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
        _parent = parent;
    }

    /**
     *
     * @return
     */
    public AbstractComponent getbase() {
        return _basereference;
    }
}
