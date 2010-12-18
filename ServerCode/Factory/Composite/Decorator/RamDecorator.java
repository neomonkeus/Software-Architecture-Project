package ServerCode.Factory.Composite.Decorator;

import ServerCode.Factory.Composite.AbstractComponent;
import ServerCode.Factory.Composite.AbstractRam;
import ServerCode.Utilities.ComponentType;

/**
 *
 * @author User
 */
public class RamDecorator extends AbstractRam {

    private Ram _ramreference;

    /**
     *
     * @param _ramreference
     */
    public RamDecorator(Ram _ramreference) {
        this._ramreference = _ramreference;
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(AbstractComponent component) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCost() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ComponentType getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AbstractComponent getParent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(AbstractComponent parent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param parent
     */
    public void setParent(AbstractComponent parent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
