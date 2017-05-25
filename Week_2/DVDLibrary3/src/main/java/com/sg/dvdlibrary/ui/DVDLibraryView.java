/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryView {
    
      private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please give the title of the dvd you'd like to add.");
        LocalDate releaseDate = io.readLocalDate("What is the release date?");
        String mpaaRating = io.readString("what is the MPAA rating?");
        String director = io.readString("Who directed this film?");
        String studio = io.readString("Which Studio produced this film?");
        String userNotes = io.readString("Please give any notes you might have or press enter");
        DVD currentDVD = new DVD();
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNotes(userNotes);
        return currentDVD;
    }

    public String makeChange(String currentInfo, String infoField) {
        io.print("Current "+infoField+": "+currentInfo);
        String input = io.readString("Press enter to go to next field or enter change then press enter");
        if (input.length() < 1) {
            return currentInfo;
        } else {
            return input;
        }
    }
    
    public LocalDate makeChangeReleaseDate(LocalDate current, String infoField) {
        io.print("Current "+infoField+": "+current);
        LocalDate input = io.readLocalDate("Press enter to go to next field or enter change then press enter");
        if (input.equals(0)) {
            return current;
        } else {
            return input;
        }
    }

    public DVD editDVDInfo(DVD DVDToEdit) {
        int dvdID = DVDToEdit.getdvdID();
        String title = makeChange(DVDToEdit.getTitle(),"Title");
        LocalDate releaseDate =  makeChangeReleaseDate(DVDToEdit.getReleaseDate(),"Release date");     
        String mpaaRating = makeChange(DVDToEdit.getMpaaRating(), "MPAA rating");        
        String director = makeChange(DVDToEdit.getDirector(), "Director");        
        String studio = makeChange(DVDToEdit.getStudio(), "Studio");      
        String userNotes = makeChange(DVDToEdit.getUserNotes(), "User Notes");       
        DVD updatedDVD = new DVD();
        updatedDVD.setdvdId(dvdID);
        updatedDVD.setTitle(title);
        updatedDVD.setReleaseDate(releaseDate);
        updatedDVD.setMpaaRating(mpaaRating);
        updatedDVD.setDirector(director);
        updatedDVD.setStudio(studio);
        updatedDVD.setUserNotes(userNotes);
        return updatedDVD;
    }

    public int getMainMenuChoice() {
        int choice = io.readInt("Please select one of the following options:\n"
                + "\n1. Add, Edit, or Remove DVD "
                + "\n2. List all DVD's by Title"
                + "\n3. Search for DVD(s) to display info"
                + "\n4. EXIT", 1, 4);
        return choice;
    }

    public int getEditMenuChoice() {
        int choice = io.readInt("Please select one of the following options:\n"
                + "\n1. Add DVD to Library"
                + "\n2. Edit DVD info"
                + "\n3. Remove DVD from Library"
                + "\n4. Exit to Main Menu.", 1, 4);
        return choice;
    }

    public String getUniqueDVDid() {
        String id;
        id = io.readString("Please give me a unique ID for our DVD Library entry");
        return id;
    }

    public String getTitleToSearch() {
        String title = io.readString("Please give a title from the list above");
        return title;
    }

    public int getIDToRemove() {
        int inputID = io.readInt("Please give the ID of the DVD you would like to remove\n"
                + "\n*All titles and ID's listed above for reference*");
        return inputID;
    }

    public int getIDToChange() {
        int inputID = io.readInt("Please give the ID of the DVD you would like to change\n"
                + "\n*All titles and ID's listed above for reference*");
        return inputID;
    }

    public void displayDVDList(List<DVD> DVDsList) {
        for (DVD currentDVD : DVDsList) {
            io.print("\n" + currentDVD.getdvdID() + " :");
            io.print(currentDVD.getTitle() + " directed by " + currentDVD.getDirector());
            io.print("Realeased: " + currentDVD.getReleaseDate() + " through " + currentDVD.getStudio());
            io.print("MPAA rating: " + currentDVD.getMpaaRating());
            io.print("Personal notes: " + currentDVD.getUserNotes());
        }
        displayPauseForEnter();
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("===ERROR===");
        io.print(errorMsg);
    }

    public void displayTitleList(List<String> titlesList) {
        io.print("--------Here is a list of all titles on file---------");
        for (String currentTitle : titlesList) {
            io.print(currentTitle);
        }
        io.print("\n-----------------------------------------------------");
    }

    public void displayActionComplete() {
        io.print("\n===SUCCESSFULLY COMPLETED===\n");
    }

    public void displayExitBanner() {
        io.print("\n== PEACE OUT! ==\n");
    }

    public void displayPauseForEnter() {
        io.readString("\nPress Enter to Continue.\n");
    }

    public void displayListAllBanner() {
        io.print("\n=== List of all DVDs in Collection ===\n");
    }

    public void displayAddEditRemoveBanner() {
        io.print("\n========= Add, Edit, Remove =========\n");
    }

    public void displayRemoveBanner() {
        io.print("=!=!= REMOVE DVD =!=!=");
    }

    public void displaySearchBanner() {
        io.print("\n=== Search for DVD by Title to Display Info ===\n");
    }

    public void displayMainMenuBanner() {
        io.print("========== DVD LIBRARY MAIN MENU ==========");
    }

    public void displayExistsError() {
        io.print("\nwhoops... looks like that ID already exists\n");
    }

    public void displayAddDVDBanner() {
        io.print("\n==== ADD NEW DVD ====\n");
    }

    public void displayDVDMatch(DVD currentDVD) {
        io.print("\n" + currentDVD.getdvdID() + " :\n");
        io.print(currentDVD.getTitle() + " directed by " + currentDVD.getDirector());
        io.print("Realeased: " + currentDVD.getReleaseDate() + " through " + currentDVD.getStudio());
        io.print("MPAA rating: " + currentDVD.getMpaaRating());
        io.print("Personal notes: " + currentDVD.getUserNotes());
    }

    public void displayNoMatchesFound() {
        io.print("whoops look like that title isn't on record");
    }

    public void displayEditDVDBanner() {
        io.print("===== Edit existing DVD =====");
    }

    public void displayUnknownCommand() {
        io.print("unknownCommand");
    }
}
