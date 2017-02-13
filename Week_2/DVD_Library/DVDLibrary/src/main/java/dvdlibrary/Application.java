package dvdlibrary;

import dvdlibrary.controller.DVDLibraryController;
import dvdlibrary.dao.DVDLibraryAuditDao;
import dvdlibrary.dao.DVDLibraryAuditDaoFileImpl;
import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dao.DVDLibraryDaoImpl;
import dvdlibrary.service.DVDLibraryServiceLayer;
import dvdlibrary.service.DVDLibraryServiceLayerImpl;
import dvdlibrary.ui.DVDIO;
import dvdlibrary.ui.DVDIOImpl;
import dvdlibrary.ui.DVDLibraryView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class Application {

public static void main(String[] args) {
    // Instantiate the UserIO implementation
    DVDIO myIo = new DVDIOImpl();
    // Instantiate the View and wire the UserIO implementation into it
    DVDLibraryView myView = new DVDLibraryView(myIo);
    // Instantiate the DAO
    DVDLibraryDao myDao = new DVDLibraryDaoImpl();
    // Instantiate the Audit DAO
    DVDLibraryAuditDao myAuditDao = new DVDLibraryAuditDaoFileImpl();
    // Instantiate the Service Layer and wire the DAO and Audit DAO into it
    DVDLibraryServiceLayer myService = new DVDLibraryServiceLayerImpl(myDao, myAuditDao);
    // Instantiate the Controller and wire the Service Layer into it
    DVDLibraryController controller = new DVDLibraryController(myDao, myView);
    // Kick off the Controller
    controller.run();
};
}

