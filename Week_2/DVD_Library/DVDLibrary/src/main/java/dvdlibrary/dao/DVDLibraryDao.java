/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryDao {
    
    List<DVD> DVDsWithDirector (String director)
     throws DVDLibraryPersistenceException;
    
    List<DVD> DVDsWithMPAARating(String mPAARating)
     throws DVDLibraryPersistenceException;
    
    List<DVD> DVDsFromLastNYears(int years)
     throws DVDLibraryPersistenceException;

    DVD addDVD(String EIDRNumber, DVD dvd)
     throws DVDLibraryPersistenceException;

    List<DVD> getAllDVDs()
     throws DVDLibraryPersistenceException;

    DVD getDVD(String EIDRNumber)
     throws DVDLibraryPersistenceException;

    DVD removeDVD(String EIDRNumber)
     throws DVDLibraryPersistenceException;
}
