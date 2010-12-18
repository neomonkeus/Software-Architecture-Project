package ClientCode;

import ServerCode.Utilities.ComputerType;
import ServerCode.Utilities.Configurations;
import ServerCode.Utilities.Locations;
import ServerCode.ShoppingSystem;
import java.util.Observable;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Client extends Observable {

    /**
     *
     * @param args
     */
    private static ShoppingSystem processsystem;

    public Client(){
        System.out.println("Constructor");
    }

    
        //
    
    public static void main(String[] args) {       
        processsystem = new ShoppingSystem();
        String[] computers = {"Laptop", "Desktop"};
        String[] specifications = {"Gaming", "Standard"};
        boolean isfinished = true;

        int type = JOptionPane.showOptionDialog(null, "What type of computer would you like", "User Choice Panel", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, computers, "Desktop");
        int spec = JOptionPane.showOptionDialog(null, "What spec would you like", "User Choice Panel", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, specifications, "Standard");
        System.out.print(type);
        System.out.print(spec);
        if (type == 0) {
            if (spec == 0) {
                processsystem.createComputer(ComputerType.LAPTOP, Configurations.GAMING);
            } else {
                processsystem.createComputer(ComputerType.LAPTOP, Configurations.STANDARD);
            }
        } else {
            if (spec == 0) {
                processsystem.createComputer(ComputerType.DESKTOP, Configurations.GAMING);
            } else {
                processsystem.createComputer(ComputerType.DESKTOP, Configurations.STANDARD);
            }
        }

            String[] choices = {"Input Number of Units", "Change Vat","Decorate", "Exit"},locations = {"United Kingdom", "Ireland"}, changable = {"Ram", "Hard-Drive", "Graphics-Card"};

            while(isfinished){
                int message = JOptionPane.showOptionDialog(null, "What would you like to do?", "Service User Choice Panel", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "Input Value");
                switch (message)
                {
                    case 0:
                    {
                        int value = Integer.parseInt(JOptionPane.showInputDialog(null,"Please input a Integer Value"));
                        processsystem.numberOfComputers(value);
                        JOptionPane.showMessageDialog(null, processsystem.CalculateTotal());
                        break;
                    }
                    case 1:
                    {

                        int option = JOptionPane.showOptionDialog(null, "Which Vat Type would you like to use", "Vat Type", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, locations, "Ireland");
                        switch(option){
                            case 0:{
                                 
                                 processsystem.SetVat(Locations.UK);
                                 System.out.println("Uk set");
                                 break;
                            }
                             case 1:{
                                 
                                 processsystem.SetVat(Locations.IRELAND);
                                 System.out.println("Ireland set");
                                 break;
                             }
                        }
                        JOptionPane.showMessageDialog(null, processsystem.CalculateTotal());
                        break;
                    }
                    case 2:{
                        int decorator = JOptionPane.showOptionDialog(null, "What would you like to add?", "Service User Choice Panel", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, changable, "Ram");
                        switch(decorator){
                            case 0:{
                                 processsystem.addRam();
                                 System.out.println("Ram added");
                                 break;
                            }
                             case 1:{

                                 processsystem.addGraphicsCard();
                                 System.out.println("GraphicsCard added");
                                 break;
                             }
                             case 2:{
                                 processsystem.addHardDrive();
                                 System.out.println("HardDrive added");
                                 break;
                             }
                        }
                        JOptionPane.showMessageDialog(null, processsystem.CalculateTotal());
                        break;
                    }
                    case 3:
                    {
                        isfinished = false;
                    }
                }
}
}
}
