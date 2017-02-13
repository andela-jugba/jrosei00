/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.service;

import dvdlibrary.dao.DVDLibraryPersistenceException;
import dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryServiceLayer {

    void createDVD(DVD dvd) throws
            DVDLibraryDuplicateIdException,
            DVDLibraryDataValidationException,
            DVDLibraryPersistenceException;

    List<DVD> getAllDVDs() throws
            DVDLibraryPersistenceException;

    DVD getDVD(String EIDRNumber) throws
            DVDLibraryPersistenceException;

    DVD removeDVD(String EIDRNumber) throws
            DVDLibraryPersistenceException;

}
