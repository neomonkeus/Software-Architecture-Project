package ServerCode.State;

import ServerCode.Utilities.Locations;

/**
 *
 * @author User
 */
public class UKVat implements VatState {

    private float _vat;
    private Locations _name;

    /**
     *
     */
    public UKVat() {
        _name = Locations.UK;
    }

    /**
     *
     * @param cost
     * @return
     */
    public float CalculateVat(int cost) {
        _vat = (float) (cost * 0.4f);
        return _vat;
    }

    public Locations getLocations()
    {
        return _name;
    }

}
