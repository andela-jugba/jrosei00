/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoException extends Exception {

    DVDLibraryDaoException dvds;
    DVDLibraryDaoException writeLibrary();

    public DVDLibraryDaoException(String message) {
        super(message);
    }

    public DVDLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public DVD addDVD(String EIDRNumber, DVD dvd)
            throws DVDLibraryDaoException {
        DVD newStudent = dvds.put(EIDRNumber, dvd);
        writeLibrary();
        return newStudent;
    }

    @Override
    public List<DVD> getAllStudents()
            throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String EIDRNumber)
            throws DVDLibraryDaoException {
        loadLibrary();
        return dvds.get(EIDRNumber);
    }

    @Override
    public DVD removeDVD(String EIDRNumber)
            throws DVDLibraryDaoException {
        DVD removedDVD = dvds.remove(EIDRNumber);
        writeLibrary();
        return removedDVD;
    }
}
