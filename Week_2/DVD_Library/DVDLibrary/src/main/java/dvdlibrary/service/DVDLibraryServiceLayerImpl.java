/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.service;

import dvdlibrary.dao.DVDLibraryAuditDao;
import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dao.DVDLibraryPersistenceException;
import dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryServiceLayerImpl implements
        DVDLibraryServiceLayer {

    private DVDLibraryDao dao;
    private DVDLibraryAuditDao auditDao;

    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    public DVDLibraryServiceLayerImpl() {
    }

    @Override
    public void createDVD(DVD dvd) throws
            DVDLibraryPersistenceException, DVDLibraryDataValidationException, DVDLibraryDuplicateIdException {

        if (dao.getDVD(dvd.getEIDRNumber()) != null) {
            throw new DVDLibraryDuplicateIdException(
                    "ERROR: Could not create DVD. EIDR Number "
                    + dvd.getEIDRNumber()
                    + " already exists");

        }

        validateDVDData(dvd);

        dao.addDVD(dvd.getEIDRNumber(), dvd);

        auditDao.writeAuditEntry(
                "DVD " + dvd.getEIDRNumber() + " CREATED.");
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dao.getAllDVDs();
    }

    @Override
    public DVD getDVD(String EIDRNumber) throws DVDLibraryPersistenceException {
        return dao.getDVD(EIDRNumber);
    }

    @Override
    public DVD removeDVD(String EIDRNumber) throws DVDLibraryPersistenceException {
        DVD removedDVD = dao.removeDVD(EIDRNumber);
        // Write to audit log
        auditDao.writeAuditEntry("DVD " + EIDRNumber + " REMOVED.");
        return removedDVD;
    }

    private void validateDVDData(DVD dvd) throws
            DVDLibraryDataValidationException {

        if (dvd.getTitle() == null
                || dvd.getTitle().trim().length() == 0
                || dvd.getEIDRNumber() == null
                || dvd.getEIDRNumber().trim().length() == 0
                || dvd.getreleaseDate() == null
                || dvd.getreleaseDate().trim().length() == 0
                || dvd.getRating() == null
                || dvd.getRating().trim().length() == 0
                || dvd.getDirector() == null
                || dvd.getDirector().trim().length() == 0
                || dvd.getStudio() == null
                || dvd.getStudio().trim().length() == 0
                || dvd.getNotes() == null
                || dvd.getNotes().trim().length() == 0) {
            throw new DVDLibraryDataValidationException("ERROR: All fields [Title, EIDRNumber, releaseDate, Rating, Director, Studio, Notes] are required.");
        }
    }
}
