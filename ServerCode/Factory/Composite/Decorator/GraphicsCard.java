package ServerCode.Factory.Composite.Decorator;

import ServerCode.Factory.Composite.AbstractComponent;
import ServerCode.Factory.Composite.AbstractGraphicsCard;
import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public class GraphicsCard extends AbstractGraphicsCard {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     * Initialise component
     * @param basecost cost of component
     * @param basetype type identifier
     */
    public GraphicsCard(ComponentType basetype, Integer basecost) {
        _cost = basecost;
        _name = basetype;
    }

    /**
     * get the cost of the component
     * @return cost
     */
    public int getCost() {
        return _cost;
    }

    /**
     * return the type for the component
     * @return type
     */
    public ComponentType getName() {
        return _name;
    }

    /**
     * used to set parent
     * @param parent
     */
    public void add(AbstractComponent component) {
        setParent(component);
    }

    /**
     * remove the parent reference
     */
    public void remove(AbstractComponent component) {
        _parent.remove(this);
        setParent(null);
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
     * @param parent
     */
    private void setParent(AbstractComponent parent){
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
