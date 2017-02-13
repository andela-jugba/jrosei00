package dvdlibrary.controller;

import dvdlibrary.dao.DVDLibraryAuditDao;
import dvdlibrary.dao.DVDLibraryAuditDaoFileImpl;
import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dao.DVDLibraryDaoImpl;
import dvdlibrary.dao.DVDLibraryPersistenceException;
import dvdlibrary.dto.DVD;
import dvdlibrary.service.DVDLibraryDataValidationException;
import dvdlibrary.service.DVDLibraryDuplicateIdException;
import dvdlibrary.service.DVDLibraryServiceLayer;
import dvdlibrary.service.DVDLibraryServiceLayerImpl;
import dvdlibrary.ui.DVDIO;
import dvdlibrary.ui.DVDIOImpl;
import dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class DVDLibraryController {

    private DVDIO io = new DVDIOImpl(); //please explain line
    DVDLibraryView view;
    private DVDLibraryServiceLayer service;

    DVDLibraryDao dao = new DVDLibraryDaoImpl();

    DVDLibraryController newDVD;
    DVDLibraryController getEIDRNumber;
    DVDLibraryController ListDVD;
    DVDLibraryAuditDao auditDao = new DVDLibraryAuditDaoFileImpl();

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
        service = new DVDLibraryServiceLayerImpl(dao, auditDao);
    }

    public DVDLibraryController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }

            exitMessage();
        } catch (DVDLibraryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryPersistenceException {
        view.displayCreateDVDBanner();
        boolean hasErrors = false;
        do {
            DVD currentDVD = view.getNewDVDInfo();
            try {
                service.createDVD(currentDVD);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (DVDLibraryDuplicateIdException | DVDLibraryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);

    }

    private void listDVDs() throws DVDLibraryPersistenceException {
        List<DVD> DVDList = service.getAllDVDs();

        view.displayDVDList(DVDList);
    }

    private void viewDVD() throws DVDLibraryPersistenceException {
        String EIDRNumber = view.getEIDRNumberChoice();
        DVD dvd = service.getDVD(EIDRNumber);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDLibraryPersistenceException {
        view.displayRemoveDVDBanner();
        String EIDRNumber = view.getEIDRNumberChoice();
        service.removeDVD(EIDRNumber);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
