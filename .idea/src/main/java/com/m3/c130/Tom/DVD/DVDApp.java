package com.m3.c130.Tom.DVD;

import com.m3.c130.Tom.DVD.DAO.DVDDAO;
import com.m3.c130.Tom.DVD.DAO.DVDDAOFileImpl;
import com.m3.c130.Tom.DVD.UI.DVDView;
import com.m3.c130.Tom.DVD.UI.UserIO;
import com.m3.c130.Tom.DVD.UI.UserIOConsoleImpl;
import com.m3.c130.Tom.DVD.controller.DVDController;

public class DVDApp {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDView myView = new DVDView(myIo);
        DVDDAO myDao = new DVDDAOFileImpl();
        DVDController controller = new DVDController(myDao, myView);
        controller.run();
    }
}
