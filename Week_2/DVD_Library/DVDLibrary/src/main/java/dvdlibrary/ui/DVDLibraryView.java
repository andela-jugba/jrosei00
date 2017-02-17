/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.ui;

import dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryView {

    private DVDIO io;

    public DVDLibraryView(DVDIO io) {
        this.io = io;
    }

    public DVD getNewDVDInfo() {
        String EIDRNumber = io.readString("Please enter EIDR Number");
        String Title = io.readString("Please enter Title");
        String releaseDate = io.readString("Please enter the Release Date");
        String Rating = io.readString("Please enter the MPAA Rating");
        String Director = io.readString("Please enter the Director's Name");
        String Studio = io.readString("Please enter Studio Name");
        String Notes = io.readString("Please enter any additional notes or comments.");
        DVD currentDVD = new DVD(EIDRNumber);
        currentDVD.setTitle(Title);
        currentDVD.setreleaseDate(releaseDate);
        currentDVD.setRating(Rating);
        currentDVD.setDirector(Director);
        currentDVD.setStudio(Studio);
        currentDVD.setNotes(Notes);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created.  Please hit enter to continue");
    }

    public int printMenuAndGetSelection() {
        io.print("=== Menu ===");
        io.print("1 = List DVDs");
        io.print("2 = Create DVD");
        io.print("3 = View DVD");
        io.print("4 = Remove DVD");
        io.print("5 = Exit");
        
        return io.readInt("Please select from the above items.");
    }

    public void displayDVDList(List<DVD> DVDList) {
        for (DVD currentDVD : DVDList) {
            io.print(currentDVD.getEIDRNumber() + ": "
                    + currentDVD.getTitle() + " "
                    + currentDVD.getreleaseDate());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getEIDRNumber());
            io.print(dvd.getTitle() + " " + dvd.getreleaseDate());
            io.print(dvd.getRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayDisplayDVDBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEIDRNumberChoice() {
        return io.readString("Please enter the EIDR Number for the DVD you wish to see.");
            }

    public void displayExitBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayUnknownCommandBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
