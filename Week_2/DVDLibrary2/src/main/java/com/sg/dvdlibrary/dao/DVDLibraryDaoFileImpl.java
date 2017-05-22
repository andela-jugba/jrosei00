/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
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
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();
    public static final String DVD_Library = "DVD_Library.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        DVD newDVD = dvds.put(title, dvd);
        writeList();
        return newDVD; // ID of new DVD and using put method to add
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadList();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadList();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        DVD removedDVD = dvds.remove(title);
        writeList();
        return removedDVD;
    }

    /*@Override
    public DVD editDVDInformation() {
        loadList();
        return editDVDInformation;
    }*/
    private void loadList() throws DVDLibraryDaoException {
        Scanner sc;

        try {
            sc = new Scanner(new BufferedReader(new FileReader(DVD_Library)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("Could not load roster data into memory");
        }
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD(currentTokens[0]);
            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setDate(Integer.parseInt(currentTokens[2]));
            currentDVD.setMpaa(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setDirector(currentTokens[5]);
            currentDVD.setComment(currentTokens[6]);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        sc.close();
    }

    private void writeList() throws DVDLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_Library));
        } catch (IOException e) {
            throw new DVDLibraryException("Could not save DVD data", e);
        }

        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            //write student object to file
            out.print(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getDate() + DELIMITER
                    + currentDVD.getMpaa() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getComment());
            out.flush();
        }
        //clean up
        out.close();
    }
}
