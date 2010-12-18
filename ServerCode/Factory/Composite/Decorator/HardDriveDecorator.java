package ServerCode.Factory.Composite.Decorator;

import ServerCode.Factory.Composite.AbstractComponent;
import ServerCode.Factory.Composite.AbstractHardDrive;
import ServerCode.Utilities.ComponentType;

/**
 *
 * @author User
 */
public class HardDriveDecorator extends AbstractHardDrive {

  private HardDrive _harddrivereference;

  /**
   *
   * @param _harddrivereference
   */
  public HardDriveDecorator(HardDrive _harddrivereference)
          {
                 this._harddrivereference = _harddrivereference;
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
    public void remove(AbstractComponent component) {
        throw new UnsupportedOperationException("HardDrive Remove().");
    }

    /**
     *
     * @param parent
     */
    public void setParent(AbstractComponent parent)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

