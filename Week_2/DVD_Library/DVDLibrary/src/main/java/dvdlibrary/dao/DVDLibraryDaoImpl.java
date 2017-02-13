/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoImpl implements DVDLibraryDao {

    DVDLibraryDaoImpl currentDVD;

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> DVDs = new HashMap<>();

    @Override
    public DVD addDVD(String EIDRNumber, DVD dvd) {
        DVD newDVD = DVDs.put(EIDRNumber, dvd);
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(DVDs.values());
    }

    @Override
    public DVD getDVD(String EIDRNumber) {
        return DVDs.get(EIDRNumber);
    }

    @Override
    public DVD removeDVD(String EIDRNumber) {
        DVD removedDVD = DVDs.remove(EIDRNumber);
        return removedDVD;
    }

    private void loadLibrary() throws DVDLibraryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD(currentTokens[0]);
            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setreleaseDate(currentTokens[2]);
            currentDVD.setRating(currentTokens[3]);
            currentDVD.setDirector(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            currentDVD.setNotes(currentTokens[6]);
            

            DVDs.put(currentDVD.getEIDRNumber(), currentDVD);
        }
        scanner.close();
    }

    private void writeLibrary() throws DVDLibraryPersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DVDLibraryPersistenceException(
                    "Could not save student data.", e);
        }

        List<DVD> DVDLibrary = this.getAllDVDs();
        for (DVD currentDVD : DVDLibrary) {

            out.println(currentDVD.getEIDRNumber() + DELIMITER
                    + currentDVD.getTitle() + DELIMITER
                    + currentDVD.getreleaseDate() + DELIMITER
                    + currentDVD.getRating() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getNotes());
            out.flush();
        }
        out.close();
    }

    @Override
    public List<DVD> DVDsWithDirector(String director) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> DVDsWithMPAARating(String mPAARating) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> DVDsFromLastNYears(int years) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
