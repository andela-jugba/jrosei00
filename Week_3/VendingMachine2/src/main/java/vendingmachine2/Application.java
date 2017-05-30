/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine2;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoImpl;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.service.VendingMachineServiceLayerImpl;
import vendingmachine.ui.VendingMachineIO;
import vendingmachine.ui.VendingMachineIOImpl;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author apprentice
 */
public class Application {
    
    public static void main(String[] args) throws VendingMachinePersistenceException {

        VendingMachineIO myIO = new VendingMachineIOImpl();

        VendingMachineView io = new VendingMachineView(myIO);

        VendingMachineDao myDao = new VendingMachineDaoImpl();

        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(myDao);

        VendingMachineController view = new VendingMachineController(service, io);

        view.run();
    }
}
