/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery2;

import flooringMastery.controller.flooringMasteryController;
import flooringMastery.dao.flooringMasteryPersistenceException;
import flooringMastery.dao.orderDao;
import flooringMastery.dao.orderDaoImpl;
import flooringMastery.dao.productDao;
import flooringMastery.dao.productDaoImpl;
import flooringMastery.dao.taxDao;
import flooringMastery.dao.taxDaoImpl;
import flooringMastery.service.flooringMasteryServiceLayer;
import flooringMastery.service.flooringMasteryServiceLayerImpl;
import flooringMastery.service.invalidProductTypeException;
import flooringMastery.service.invalidStateException;
import flooringMastery.ui.flooringMasteryIO;
import flooringMastery.ui.flooringMasteryIOImpl;
import flooringMastery.ui.flooringMasteryView;

/**
 *
 * @author apprentice
 */
public class Application {

    public static void main(String[] args) throws flooringMasteryPersistenceException, invalidStateException, invalidProductTypeException {
      
        flooringMasteryIO io = new flooringMasteryIOImpl();
        flooringMasteryView view = new flooringMasteryView(io);
        orderDao dao = new orderDaoImpl();
        productDao product = new productDaoImpl();
        taxDao tax = new taxDaoImpl();
        flooringMasteryServiceLayer service = new flooringMasteryServiceLayerImpl(dao, product, tax);
        flooringMasteryController controller = new flooringMasteryController(service, view);
        controller.run();
    }
}
