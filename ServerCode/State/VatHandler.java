package ServerCode.State;

import ServerCode.Utilities.Locations;
import ServerCode.ShoppingSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author User
 */
public class VatHandler extends Observable {

    private List<VatState> StateList;
    private VatState _currentvat;

    /**
     * set the vat location
     * @param Vat set the country's vat to use
     */
    public void setVat(Locations Vat) {
        for (VatState vat : StateList) {
            if (vat.getLocations() == Vat) {
                _currentvat = vat;
                break;
            }
        }
        this.setChanged();

    }

    /**
     * Initialise the handler
     * @param system used to create observer connection
     */
    public VatHandler(ShoppingSystem system) {
        StateList = new ArrayList<VatState>();
        StateList.add(new IrelandVat());
        StateList.add(new UKVat());
        _currentvat = StateList.get(0);
        //this.addObserver(system);

    }

    public VatHandler()
    {
        StateList = new ArrayList<VatState>();
        StateList.add(new IrelandVat());
        StateList.add(new UKVat());
        _currentvat = StateList.get(0);

    }

    /**
     * calculate vat
     * @param nettotal net cost on which vat will be calculated
     * @return computed vat
     */
    public float CalculateVat(int nettotal) {
        float vat = _currentvat.CalculateVat(nettotal);
        return vat;

    }

    /**
     * check the current vat location
     * @return the current vat
     */
    public VatState getVatState() {
        this.setChanged();
        return _currentvat;
    }
}
