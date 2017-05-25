/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {

    DVDLibraryView view;

    /**
     * constructor in DVDLibraryController object calls to Dao and View. the App
     * is specifying which implementation of each to implement.
     *
     * @param dao
     * @param view
     */
    public DVDLibraryController(DVDLibraryView view) {
        this.view = view;
    }

    /**
     * below booleans instantiated for while loops in main menu and edit menu
     * ints instantiated for menu option choices from user for switch statement
     * case
     */
    private boolean runMainMenu;
    private boolean runEditMenu;
    private int mainMenuOption;
    private int editMenuOption;

    public void run() {
        runMainMenu = true;
        try {
            while (runMainMenu) {
                displayMainMenuBanner();
                mainMenuOption = getMainMenuOptionChoice();
                switch (mainMenuOption) {
                    case 1:
                        runEditMenu = true;
                        displayAddEditRemove();
                        try {
                            while (runEditMenu) {
                                editMenuOption = getEditMenuChoice();
                                switch (editMenuOption) {
                                    case 1:
                                        addDVD();
                                        break;
                                    case 2:
                                        editDVD();
                                        break;
                                    case 3:
                                        removeDVD();
                                        break;
                                    case 4:
                                        runEditMenu = exitToMain();
                                        break;
                                    default:
                                        unknownCommand();
                                }
                            }
                        } catch {
                            view.displayErrorMessage(e.getMessage());
                        }
                        break;
                    case 2:
                        listAllDvds();
                        break;
                    case 3:
                        searchToDisplay();
                        break;
                    case 4:
                        runMainMenu = exit();
                        break;
                    default:
                        unknownCommand();
                }
            }

            /**
             * catch for any errors that may occur in read write process for any
             * methods called to within the run method
             */
        } catch (DVDLibraryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    /**
     * calls to view to get user input and return for switch case
     *
     * @return
     */
    private int getMainMenuOptionChoice() {
        return view.getMainMenuChoice();
    }

    /**
     * calls to view to get user input and return for switch case
     *
     * @return
     */
    private int getEditMenuChoice() {
        return view.getEditMenuChoice();
    }

    /**
     * calls to Dao for a list of all DVD objects and returns a list<> of all
     * stored DVD objects then passes to View to print to screen the object
     * values in the specified order in the method in view
     *
     * @throws DVDLibraryPersistenceException
     */
    private void listAllDvds() throws DVDLibraryPersistenceException {
        view.displayListAllBanner();
        listTitlesForReference();
    }

    /**
     * FOR USER REFERENCE calls to Dao for a list<> of all DVD objects then
     * creates a new List of all the DVD object titles using an enhanced for
     * loop then passes the new list of titles to view so they can be displayed
     * on screen.
     *
     * @throws DVDLibraryPersistenceException
     */
    private void listTitlesForReference() {
        List<String> titleList = new ArrayList<>();
        List<DVD> DVDsList = service.getAllDVDs();
        for (DVD temp : DVDsList) {
            titleList.add(temp.getdvdID() + ": " + temp.getTitle());
        }
        view.displayTitleList(titleList);
    }

    /**
     * ... @throws DVDLibraryPersistenceException
     */
    private void searchToDisplay() {
        view.displaySearchBanner();
        listTitlesForReference();
        String title = view.getTitleToSearch();
        List<DVD> matches = new ArrayList<>();
        matches = service.getDVD(title);
        if (matches.size() >= 1) {
            for (DVD temp : matches) {
                view.displayDVDMatch(temp);
            }
        } else {
            view.displayNoMatchesFound();
        }
        view.displayPauseForEnter();
    }

    private void addDVD() {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        service.createDVD(newDVD);
        view.displayActionComplete();
    }

    private void removeDVD() {
        view.displayRemoveBanner();
        listTitlesForReference();
        int dvdID = view.getIDToChange();
        service.removeDVD(dvdID);
        view.displayActionComplete();
    }

    private void editDVD() {
        view.displayEditDVDBanner();
        listTitlesForReference();
        int dvdID = view.getIDToChange();
        DVD DVDToEdit = service.removeDVD(dvdID);
        DVD changedDVD = view.editDVDInfo(DVDToEdit);
        service.updateDVD(changedDVD);
        view.displayDVDMatch(changedDVD);
        view.displayActionComplete();
    }

    /**
     * below three methods display content to screen for better user experience
     */
    private void displayAddEditRemove() {
        view.displayAddEditRemoveBanner();
    }

    private void displayMainMenuBanner() {
        view.displayMainMenuBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
        view.displayPauseForEnter();
    }

    /**
     * below two methods are exit options for the switch statements in run
     * method which return boolean false breaking the while loop to exit menu if
     * chosen by user
     *
     * @return
     */
    private boolean exitToMain() {
        return false;
    }

    private boolean exit() {
        view.displayExitBanner();
        return false;
    }
}
