package com.m3.c130.Tom.DVD.UI;

import com.m3.c130.Tom.DVD.DTO.DVD;

import java.util.List;

public class DVDView {
    private UserIO io;
    public DVDView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List all DVDs");
        io.print("2. Add New DVD to library");
        io.print("3. Edit existing DVD in library");
        io.print("4. View a DVD");
        io.print("5. Remove a DVD");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter the title");
        String releaseDate = io.readString("Please enter the Release Date");
        String MPAARating = io.readString("Please enter the MPAA Rating");
        String directorsName = io.readString("Please enter the Director's name");
        String studio = io.readString("Please enter the film studio");
        String userRatingOrNote = io.readString("Please enter the user rating or notes");
        DVD currentDVD = new DVD(title);
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAARating(MPAARating);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRatingOrNote(userRatingOrNote);
        return currentDVD;
    }

    public void displayDVDList(List<DVD> DVDList) {
        for (DVD currentDVD : DVDList) {
            io.print(currentDVD.getTitle() + " - " + currentDVD.getReleaseDate() + " - "
                    + currentDVD.getMPAARating() + " - " + currentDVD.getStudio() + " - "
                    + currentDVD.getDirectorsName() + " - " + currentDVD.getUserRatingOrNote());
        }
        io.readString("Please hit enter to continue.");
    }

    public int editMenu(){
        io.print("What would you like to edit?");
        io.print("1. Title");
        io.print("2. release date");
        io.print("3. MPAA Rating");
        io.print("4. Studio");
        io.print("5. Director's Name");
        io.print("6. User Rating Or Notes");
        io.print("7. Nothing and return to menu");
        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD editDVDInfo(DVD dvd) {
        displayDVD(dvd);
        boolean editingMenu = true;
        while (editingMenu) {
            int userInput = editMenu();
            switch (userInput) {
                case 1:
                    String title = io.readString("Please enter the new title");
                    dvd.setTitle(title);
                    break;
                case 2:
                    String releaseDate = io.readString("Please enter the Release Date");
                    dvd.setReleaseDate(releaseDate);
                    break;
                case 3:
                    String MPAARating = io.readString("Please enter the MPAA Rating");
                    dvd.setMPAARating(MPAARating);
                    break;
                case 4:
                    String studio = io.readString("Please enter the film studio");
                    dvd.setStudio(studio);
                    break;
                case 5:
                    String directorsName = io.readString("Please enter the Director's name");
                    dvd.setDirectorsName(directorsName);
                    break;
                case 6:
                    String userRatingOrNote = io.readString("Please enter the user rating or notes");
                    dvd.setUserRatingOrNote(userRatingOrNote);
                    break;
                case 7:
                    io.print("Back to main menu");
                    dvd.getTitle();
                    editingMenu = false;
                    break;
            }
        }
        return dvd;
    }
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created. Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the Title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAARating());
            io.print(dvd.getStudio());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getUserRatingOrNote());
            io.print("");
        } else {
            io.print("DVD not in library.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner () {
        io.print("=== Removed DVD ===");
    }

    public void displayRemovedDVD(DVD DVDRemoved) {
        if(DVDRemoved != null){
            io.print("DVD has been removed.");
        }else{
            io.print("DVD not in library.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye, program is exiting");
    }
    public void displayEditDVDBanner() {
        io.print("Editing existing DVD record");
    }
    public void displayEditDVD(DVD DVDEdit) {
        if (DVDEdit != null) {
            io.print("DVD has been edited.");
        } else {
            io.print("DVD not in library.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayUnknownCommandBanner() {
        io.print("Incorrect selection");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
