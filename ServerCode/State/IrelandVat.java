package ServerCode.State;

import ServerCode.Utilities.Locations;

/**
 *
 * @author User
 */
public class IrelandVat implements VatState {

  private Float _vat;
  private Locations _name;

  /**
   * Initialise location
   */
  public IrelandVat()
  {
   _name = Locations.IRELAND;
   _vat = 0.2f;
  }
  
  /**
   *
   * @param cost net total to be computed on
   * @return computed vat
   */
  public float CalculateVat(int cost) {
    return (float)(cost * _vat);
  }

    public Locations getLocations()
    {
        return _name;
    }
}