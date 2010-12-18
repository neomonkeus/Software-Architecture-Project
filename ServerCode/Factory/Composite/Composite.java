package ServerCode.Factory.Composite;

import ServerCode.Utilities.ComponentType;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author User
 */
public class Composite extends AbstractComponent {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;

    /**
     * Initialise the component
     * @param basetype component type
     * @param cost cost of component
     */
    public Composite(ComponentType basetype, int cost) {
        _name = basetype;
        _cost = cost;
        _components = new ArrayList();
        _parent = null;
    }

    /**
     * recursive function to get combined component
     * @return total cost of component and subparts
     */
    @Override
    public int getCost() {
        //if(observer.hasChanged())
        System.out.println("ok start");
        int _totalcost = 0;
        System.out.println(_totalcost);
        for (AbstractComponent n : _components) {
            System.out.println(n.getName().toString() + n.getCost());
            _totalcost += n.getCost();
        }
        _totalcost += _cost;
        return _totalcost;
    }

    /**
     * used to check for component type
     * @return component enum
     */
    @Override
    public ComponentType getName() {
        return _name;
    }

    /**
     * adds component to component list and establishes parent ref
     * @param component component used to create relationships
     */
    public void add(AbstractComponent component) {
       component.add(this);
       _components.add(component);
        //call observer
    }

    public void add(Composite composite)
    {
        composite.setParent(this);
        _components.add(composite);
    }

    /**
     * remove component from list and release relationship
     * @param component component to be removed
     */
    public void remove(AbstractComponent component) {
        _components.remove(component);
        //call observer
    }

    public void remove(Composite composite){
        _components.remove(composite);
        composite.setParent(null);
    }
    /**
     * used to check for composite
     * @return null or composite component
     */
    @Override
    public AbstractComponent getComposite() {
        return this;
    }

    /**
     * recursive algorithm to find desired component in composite tree
     * @param component component searching for.
     * @return component
     */
    public AbstractComponent find(ComponentType component) {
        boolean found = false;
        AbstractComponent search = null;
        while (!found) {
            System.out.println(found);
            for (AbstractComponent n : _components) {
                System.out.println("Current Component: " + n.getName().toString());
                if (n.getComposite() != null) {
                    Composite m = (Composite) n;
                    search = m.find(component);
                    found = true;
                    break;
                } else if (n.getName() == component) {
                    search = n;
                    found = true;
                    break;
                } else {
                    continue;
                }
            }
        }
        return search;
    }

    void setParent(Composite parent)
    {
        _parent = parent;
    }

}
