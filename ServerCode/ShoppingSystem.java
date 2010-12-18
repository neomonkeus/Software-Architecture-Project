package ServerCode;

import ServerCode.Factory.Composite.Composite;
import ServerCode.Utilities.*;
import ServerCode.Factory.*;
import ServerCode.State.VatHandler;
import ServerCode.Factory.Composite.AbstractComponent;
import java.util.Observable;
import java.util.Observer;

/*
 */
/**
 *
 * @author User
 */
public class ShoppingSystem implements Observer
{

    private int _nettotal, _numberofcomputers;
    private float _total, _vat, _subtotal;
    private VatHandler _statehandler;
    private AbstractComponent _computer;
    private AbstractFactory helper;

    /**
     *
     */
    public ShoppingSystem() {
        _statehandler = new VatHandler(this);
        _subtotal = 0;
        _total = 0;
        _computer = null;
        
    }

    /**
     *
     * @param type
     * @param config
     */
    public void createComputer(ComputerType type, Configurations config) {
        _computer = CreateComputer(type, config);
    }



    private AbstractComponent CreateComputer(ComputerType type, Configurations config) {
        AbstractComponent computer = null;
        switch (type) {

            case DESKTOP: {
                computer = createDesktop(config);
                break;
            }
            case LAPTOP: {
                computer = createLaptop(config);
                break;
            }
        }
        return computer;
    }

    private AbstractComponent createDesktop(Configurations config) {
        DesktopFactory desktopfactory = new DesktopFactory();
        helper = desktopfactory;
        System.out.println("FactoryCreated");
        AbstractComponent computer = desktopfactory.instantiateComputer(config);
        System.out.println("ConfigCreated");
        return computer;
    }

    private AbstractComponent createLaptop(Configurations config) {
        LaptopFactory laptopfactory = new LaptopFactory();
        helper = laptopfactory;
        System.out.println("FactoryCreated");
        AbstractComponent computer = laptopfactory.instantiateComputer(config);
        System.out.println("ConfigCreated");
        return computer;
    }

    /**
     *
     * @param number
     */
    public void numberOfComputers(int number) {
        _numberofcomputers = number;
        System.out.println(_numberofcomputers);
    }

    /**
     *
     * @return
     */
    public float CalculateTotal() {
        calculateNet();
        calculateVat();
        calculateSubtotal();
        calculateTotal();
        return _total;
    }
    
    /**
     *
     * @param vat
     */
    public void SetVat(Locations vat) {
        _statehandler.setVat(vat);
    }

    private void calculateVat() {
        _vat =  _statehandler.CalculateVat(_nettotal);
    }

    private void calculateNet(){
        _nettotal = _computer.getCost();
    }

    private void calculateSubtotal(){
        _subtotal = _numberofcomputers * _nettotal;
    }

    private void calculateTotal(){
        _total = _subtotal + (_numberofcomputers * _vat);
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void addRam(){
        helper.decorate((Composite) _computer, Decoratable.RAM);
    }

    public void addGraphicsCard(){
        helper.decorate((Composite) _computer, Decoratable.GRAPHICSCARD);

    }

    public void addHardDrive(){
        helper.decorate((Composite) _computer, Decoratable.HARDDRIVE);

    }
    /*public void update(Observable o, Object arg) {

        //customer changes vat type
        if()
        {
            calculateVat();
        }
        //change by user to computer e.g decorate
        if()
        {
            calculateNet();
        }

        //change in number
        if()
        {
            calculateSubtotal();
            calculateTotal();
        }

    }*/
       
}
