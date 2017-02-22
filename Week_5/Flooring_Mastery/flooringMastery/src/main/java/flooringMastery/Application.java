/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery;

/**
 *
 * @author apprentice
 */
public class Application {

    public static void main(String[] args) {

        flooringMasteryIO myIO = new flooringMasteryIOImpl();

        flooringMasteryView io = new flooringMasteryView(myIO);

        flooringMasteryDao myDao = new flooringMasteryDaoImpl();

        flooringMasteryServiceLayer fmsl = new flooringMasteryServiceLayerImpl();

        flooringMasteryController fmc = new flooringMasteryController(fmsl, io);
    }
}
