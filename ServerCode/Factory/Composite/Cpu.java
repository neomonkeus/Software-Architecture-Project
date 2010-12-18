package ServerCode.Factory.Composite;

import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public class Cpu extends AbstractCPU {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     * Instantiate the component
     * @param basecost cost of component
     * @param basetype used for type identification
     */
    public Cpu(ComponentType basetype, Integer basecost) {
        _cost = basecost;
        _name = basetype;
    }

    /**
     * Cost of the component
     * @return cost
     */
    public int getCost() {
        return _cost;
    }

    /**
     * get the type of the component
     * @return enum of component type
     */
    public ComponentType getName() {
        return _name;
    }

    /**
     * create the parent reference.
     * @param component parent component
     */
    public void add(AbstractComponent component) {
        setParent(component);
    }

    /**
     * remove the parent reference
     */
    public void remove(AbstractComponent parent) {
        parent.remove(this);
    }

    /**
     * check to see if composite, used for type checking
     * @return null or reference to component
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
