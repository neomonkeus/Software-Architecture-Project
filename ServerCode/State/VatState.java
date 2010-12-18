package ServerCode.State;
import ServerCode.Utilities.Locations;

/**
 *
 * @author User
 */
public interface VatState {

    /**
     * calculate vat
     * @param nettotal net cost on which vat will be calculated
     * @return computed vat
     */
    public float CalculateVat(int nettotal);

    public Locations getLocations();
}
