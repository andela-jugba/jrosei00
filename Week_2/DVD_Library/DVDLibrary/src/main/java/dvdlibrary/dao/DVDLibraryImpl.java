/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class DVDLibraryImpl implements DVDLibraryDao {
    
    DVDLibraryImpl currentDVD;

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> DVDs = new HashMap<>();

    @Override
    public DVD addDVD(String EIDRNumber, DVD dvd) {
        DVD newDVD = DVDs.put(EIDRNumber, dvd);
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVD() {
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
    
private void writeLibrary() throws DVDLibraryDaoException {

    PrintWriter out;
    
    try {
        out = new PrintWriter(new FileWriter(ROSTER_FILE));
    } catch (IOException e) {
        throw new DVDLibraryDaoException(
                "Could not save student data.", e);
    }

    List<DVD> DVDLibrary = this.getAllDVDs();
    for (DVD currentStudent : DVDLibrary) {
        // write the Student object to the file
        out.println(currentDVD.getEIDRNumber() + DELIMITER
                + currentDVD.getTitle() + DELIMITER 
                + currentDVD.getreleaseDate() + DELIMITER
                + currentDVD.getRating();
        out.flush();
    }
    // Clean up
    out.close();
}
}
