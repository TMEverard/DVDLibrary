package com.m3.c130.Tom.DVD.controller;

import com.m3.c130.Tom.DVD.DAO.DVDDAO;
import com.m3.c130.Tom.DVD.DAO.DVDDAOException;
import com.m3.c130.Tom.DVD.DTO.DVD;
import com.m3.c130.Tom.DVD.UI.DVDView;
import java.util.List;

public class DVDController {
    private DVDView view;
    private DVDDAO dao;
    public DVDController(DVDDAO dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        viewDVD();
                        break;
                    case 5:
                        removeDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDDAOException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDDAOException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DVDDAOException{
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }

    private void viewDVD() throws DVDDAOException{
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDDAOException{
            view.displayRemoveDVDBanner();
            String title = view.getTitleChoice();
            DVD DVDRemoved = dao.removeDVD(title);
            view.displayRemovedDVD(DVDRemoved);
    }

    private void editDVD() throws DVDDAOException{
        view.displayEditDVDBanner();
        String oldTitle = view.getTitleChoice();
        DVD oldVersion = dao.getDVD(oldTitle);
        if (oldVersion != null) {
            DVD newVersion = view.editDVDInfo(oldVersion);
            String newTitle = newVersion.getTitle();
            dao.editDVD(oldTitle, newTitle, newVersion);
            view.displayEditDVD(oldVersion);
        } else {
            view.displayEditDVD(null);
        }
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }


}
