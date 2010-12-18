package ServerCode.Factory.Composite.Decorator;

import ServerCode.Factory.Composite.AbstractComponent;
import ServerCode.Factory.Composite.AbstractGraphicsCard;
import ServerCode.Utilities.ComponentType;

/**
 *
 * @author User
 */
public class GraphicsCardDecorator extends AbstractGraphicsCard {

    private GraphicsCard _graphicscardreference;

    /**
     *
     * @param basereference
     */
    public GraphicsCardDecorator(GraphicsCard basereference) {
        _graphicscardreference = basereference;
    }

    @Override
    public void add(AbstractComponent component) {
        throw new UnsupportedOperationException("Graphics Card Decorator Add:");
    }

    @Override
    public int getCost() {
        return _graphicscardreference.getCost();
    }

    @Override
    public ComponentType getName() {
        return _graphicscardreference.getName();
    }

    @Override
    public AbstractComponent getParent() {
        return _graphicscardreference.getParent();
    }

    /**
     *
     */
    public void remove(AbstractComponent component) {
        throw new UnsupportedOperationException("Graphics Card Decorator Remove:");
    }

}
