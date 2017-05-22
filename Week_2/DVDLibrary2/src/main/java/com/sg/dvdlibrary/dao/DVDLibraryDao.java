/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryDao {
    
    DVD addDVD (String title, DVD dvd) throws DVDLibraryDaoException; // obj for DVD with title identifier
    
    List<DVD>getAllDVDs() throws DVDLibraryDaoException; //hashmap for getting all DVDs with method
        
    DVD getDVD (String title) throws DVDLibraryDaoException; //method to get single DVD with title identifier
    
    DVD removeDVD (String title) throws DVDLibraryDaoException; //method with title identifier
    
}
