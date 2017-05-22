/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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

    @Override
    public DVD addDVD(String title, DVD dvd) {
        DVD newDVD = dvds.put(title, dvd);
        writeList();
        return newDVD; // ID of new DVD and using put method to add
    }

    @Override
    public List<DVD> getAllDVDs() {
        loadList();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) {
        loadList();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) {
        DVD removedDVD = dvds.remove(title);
        writeList();
        return removedDVD;
    }

    private void loadList() {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("DVD_Library")));
        } catch ( "") {
            System.out.println("Could not load roster data into memory");}
            String currentLine;
            String[] currentTokens;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
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
            scanner.close();
        }

    private void writeList() {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("DVD_Library")); } 
        catch ( " ") {
            System.out.println("Could not save DVD data");
            }

            final int DELIMITER;

            List<DVD> dvdList = this.getAllDVDs();
            for (DVD currentDVD : DVD) {
                out.print(currentDVD.getTitle() + DELIMITER
                        + currentDVD.getDate() + DELIMITER
                        + currentDVD.getMpaa() + DELIMITER
                        + currentDVD.getStudio() + DELIMITER
                        + currentDVD.getStudio() + DELIMITER
                        + currentDVD.getDirector() + DELIMITER
                        + currentDVD.getComment());
                out.flush();
            }
            out.close();
        }
    }
