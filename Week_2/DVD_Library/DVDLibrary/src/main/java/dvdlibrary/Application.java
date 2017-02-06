package dvdlibrary;

import dvdlibrary.controller.DVDLibraryController;
import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dao.DVDLibraryImpl;
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

    DVDIOImpl DVDIO;
    DVDLibraryImpl DVDLibraryDao;

    public static void main(String[] args) {
        DVDIO myIo = new DVDIOImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryImpl();
        DVDLibraryController controller
                = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
