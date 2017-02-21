/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import vendingmachine.dao.VendingMachinePersistenceException;

/**
 *
 * @author apprentice
 */
public class Application {

    public static void main(String[] args) throws VendingMachinePersistenceException {

//        VendingMachineIO myIO = new VendingMachineIOImpl();

//        VendingMachineView io = new VendingMachineView(myIO);

//        VendingMachineDao myDao = new VendingMachineDaoImpl();

//        VendingMachineAuditDaoFileImpl myAuditDao = new VendingMachineAuditDaoFileImpl();

//        VendingMachineServiceLayer vmsl = new VendingMachineServiceLayerImpl(myDao, myAuditDao);

//        VendingMachineController vmv = new VendingMachineController(vmsl, io);

//        vmv.run();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}
