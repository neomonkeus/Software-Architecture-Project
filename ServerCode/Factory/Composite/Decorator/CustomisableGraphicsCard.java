package ServerCode.Factory.Composite.Decorator;

import ServerCode.Factory.Composite.AbstractComponent;
import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public class CustomisableGraphicsCard extends GraphicsCardDecorator {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;
    private GraphicsCard _basereference;

    /**
     *
     * @param g
     * @param cost
     */
    public CustomisableGraphicsCard(GraphicsCard g, int cost) {
        super(g);
        _basereference = g;
        _name = g.getName();
        _cost += cost;
        _parent = g.getParent();
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
     */
    public final void add() {
        _basereference.add(this);
    }

    /**
     *
     * @return
     */
    public AbstractComponent getComponent() {
        return null;
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
