package com.m3.c130.Tom.DVD.DAO;

import com.m3.c130.Tom.DVD.DTO.DVD;

import java.util.List;

public interface DVDDAO {

    DVD addDVD(String title, DVD dvd) throws DVDDAOException;

    List<DVD> getAllDVDs() throws DVDDAOException;

    DVD getDVD(String title) throws DVDDAOException;

    DVD removeDVD(String title) throws DVDDAOException;

    DVD editDVD(String oldTitle, String newTitle, DVD dvd) throws DVDDAOException;


}
