package ServerCode.Factory.Composite;

import ServerCode.Factory.Composite.Decorator.GraphicsCardDecorator;
import ServerCode.Utilities.ComponentType;
import java.util.List;

/**
 *
 * @author User
 */
public abstract class AbstractGraphicsCard extends AbstractComponent {

    private int _cost;
    private ComponentType _name;
    private List<AbstractComponent> _components;
    private AbstractComponent _parent;
    private GraphicsCardDecorator myGraphicsCardDecorator;

    /**
     * 
     * @param component
     */
    public abstract void add(AbstractComponent component);

    /**
     *
     * @return
     */
    public abstract int getCost();

    /**
     *
     * @return
     */
    public abstract ComponentType getName();

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
    public abstract AbstractComponent getParent();

    /**
     *
     * @param parent
     */
     public abstract void remove(AbstractComponent component);
}
