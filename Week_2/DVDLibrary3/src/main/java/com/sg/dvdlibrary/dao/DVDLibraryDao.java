/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryDao {
      
    DVD addDVD(DVD dvd);

    DVD addUpdatedDVD(DVD dvd);

    List<DVD> getAllDVDs();

    List<DVD> getAllDVDTitles();

    ArrayList<DVD> getDVD(String title);

    DVD removeDVD(int dvdID);

    DVD editDVD(int dvdID);
}
