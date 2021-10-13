package com.m3.c130.Tom.DVD.DAO;

import com.m3.c130.Tom.DVD.DTO.DVD;

import java.io.*;
import java.util.*;

public class DVDDAOFileImpl implements DVDDAO {
    public static final String DVD_FILE = "DVDLibrary";
    public static final String DELIMITER = "::";

    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDDAOException {
            loadDVDLibrary();
            DVD newDVD = dvds.put(title, dvd);
            writeDVD();
            return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs()  throws DVDDAOException {
        loadDVDLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String title)  throws DVDDAOException {
        loadDVDLibrary();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title)  throws DVDDAOException {
        loadDVDLibrary();
        DVD removedDVD = dvds.remove(title);
        writeDVD();
        return removedDVD;
    }

    @Override
    public DVD editDVD(String oldTitle, String newTitle, DVD editDVD)  throws DVDDAOException {
        loadDVDLibrary();
        if(!oldTitle.equals(newTitle)){
            getDVD(oldTitle);
            removeDVD(oldTitle);
        }
        DVD replaceDVD = dvds.put(newTitle, editDVD);
        writeDVD();
        return replaceDVD;
    }

    private DVD unmarshallDVD(String DVDAsText){
        String[] DVDTokens = DVDAsText.split(DELIMITER);
        String title = DVDTokens[0];
        DVD DVDFromFile = new DVD(title);
        DVDFromFile.setReleaseDate(DVDTokens[1]);
        DVDFromFile.setMPAARating(DVDTokens[2]);
        DVDFromFile.setStudio(DVDTokens[3]);
        DVDFromFile.setDirectorsName(DVDTokens[4]);
        DVDFromFile.setUserRatingOrNote(DVDTokens[5]);
        return DVDFromFile;
    }

    private void loadDVDLibrary() throws DVDDAOException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDDAOException(
                    "Could not load DVD.txt library data", e);
        }
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVD dvdIn){
        String DVDAsText = dvdIn.getTitle() + DELIMITER;
        DVDAsText += dvdIn.getReleaseDate() + DELIMITER;
        DVDAsText += dvdIn.getMPAARating() + DELIMITER;
        DVDAsText += dvdIn.getStudio() + DELIMITER;
        DVDAsText += dvdIn.getDirectorsName() + DELIMITER;
        DVDAsText += dvdIn.getUserRatingOrNote();
        return DVDAsText;
    }

    private void writeDVD() throws DVDDAOException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDDAOException(
                    "Could not save DVD.txt data to the file.", e);
        }
        String DVDAsText;
        List<DVD> DVDList = this.getAllDVDs();
        for (DVD currentDVD : DVDList) {
            DVDAsText = marshallDVD(currentDVD);
            out.println(DVDAsText);
            out.flush();
        }
        out.close();
    }
}

