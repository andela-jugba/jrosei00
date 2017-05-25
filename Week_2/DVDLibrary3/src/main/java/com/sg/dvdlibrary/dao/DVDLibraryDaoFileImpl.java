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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static final String DVD_LIBRARY_FILE = "DVD_LIBRARY.txt";
    public static final String DELIMITER = "::";
    private Map<Integer, DVD> DVDs = new HashMap<>();

    private void loadDVDLibrary() {
        Scanner sc = null;
        try {
            sc = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
        }
        String currentLine;
        String[] currentTokens;
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD();
            currentDVD.setdvdId(Integer.parseInt(currentTokens[0]));
            currentDVD.setTitle(currentTokens[1]);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate releaseDate = LocalDate.parse(currentTokens[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            currentDVD.setReleaseDate(releaseDate);
            currentDVD.setMpaaRating(currentTokens[3]);
            currentDVD.setDirector(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            currentDVD.setUserNotes(currentTokens[6]);

            DVDs.put(currentDVD.getdvdID(), currentDVD);
        }
        sc.close();
    }

    private void writeDVDLibrary() {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        } catch (IOException e) {
           
        }
        List<DVD> DVDList = this.getAllDVDs();
        for (DVD currentDVD : DVDList) {
            out.println(currentDVD.getdvdID() + DELIMITER
                    + currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getMpaaRating() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getUserNotes());
            out.flush();
        }
        out.close();
    }

    @Override
    public DVD addDVD(DVD dvd) {
        int newID = getUniqueID();
        dvd.setdvdId(newID);
        DVD newDVD = DVDs.put(newID, dvd);
        writeDVDLibrary();
        return newDVD;
    }
    
    @Override
    public DVD addUpdatedDVD(DVD dvd) {
        DVD updatedDVD = DVDs.put(dvd.getdvdID(), dvd);
        writeDVDLibrary();
        return updatedDVD;
    }

    @Override
    public List<DVD> getAllDVDs() {
        loadDVDLibrary();
        return new ArrayList<>(DVDs.values());
    }

    @Override
    public ArrayList<DVD> getDVD(String title) {
        loadDVDLibrary();
        ArrayList<DVD> matches = new ArrayList<>();
        for (DVD temp : DVDs.values()) {
            if (title.equals(temp.getTitle())) {
                matches.add(temp);
            }
        }
        return matches;
    }

    @Override
    public DVD removeDVD(int dvdID) {
        DVD removedDVD = DVDs.remove(dvdID);
        writeDVDLibrary();
        return removedDVD;
    }

    @Override
    public DVD editDVD(int dvdID) {
        loadDVDLibrary();
    }

    @Override
    public List<DVD> getAllDVDTitles() {
        loadDVDLibrary();
        return new ArrayList<>(DVDs.values());
    }

    private int getUniqueID()  {
        int newID = getHighestID();
        return newID;
    }

    private int getHighestID()  {
        int highestID = 0;
        List<DVD> DVDs = new ArrayList<>();
        DVDs = getAllDVDs();
        for (DVD dvd : DVDs) {
            int currentID = dvd.getdvdID();
            if (highestID < currentID) {
                highestID = currentID;
            }

        }
        return highestID + 1;
    }
}
