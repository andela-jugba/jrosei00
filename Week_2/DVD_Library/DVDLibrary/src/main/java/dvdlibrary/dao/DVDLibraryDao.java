/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import static dvdlibrary.dao.DVDLibraryImpl.DELIMITER;
import static dvdlibrary.dao.DVDLibraryImpl.ROSTER_FILE;
import dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryDao {
    
    DVDLibraryDao DVDs;

    DVD addDVD(String EIDRNumber, DVD dvd)
     throws DVDLibraryDaoException;

    List<DVD> getAllDVDs()
     throws DVDLibraryDaoException;

    DVD getDVD(String EIDRNumber)
     throws DVDLibraryDaoException;

    DVD removeDVD(String EIDRNumber)
     throws DVDLibraryDaoException;



    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
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

            DVDs.put(currentDVD.getEIDRNumber(), currentDVD);
        }
        scanner.close();
    }
}
