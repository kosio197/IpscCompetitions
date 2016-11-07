package competition.bg.softuni.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import bg.softuni.entity.CategoryModel;
import bg.softuni.entity.ClubModel;
import bg.softuni.entity.CountryModel;
import bg.softuni.entity.HandgunDivisionModel;
import bg.softuni.entity.RifleDivisionModel;
import bg.softuni.entity.RoleModel;
import bg.softuni.entity.ShotgunDivisionModel;
import bg.softuni.entity.UserModel;
import competition.bg.softuni.model.user.User;

@Singleton
public class UsersRepositoryImpl implements UsersRepository {
    private List<User> users;

    @PersistenceContext
    EntityManager em;

    public UsersRepositoryImpl() {
        users = new ArrayList<User>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);

        UserModel userModel = userToEntityModel(em, user);
        em.persist(userModel);
    }

    private UserModel userToEntityModel(EntityManager em, User user) {

        RoleModel roleModel = em.createNamedQuery("roleByName", RoleModel.class)
                .setParameter("roleName", user.getRole().toString()).getSingleResult();

        CategoryModel categoryModel = em.createNamedQuery("categoryByName", CategoryModel.class)
                .setParameter("categoryName", user.getCategory().toString()).getSingleResult();

        ClubModel clubModel = null;
        try {

            clubModel = em.createNamedQuery("clubByName", ClubModel.class)
                    .setParameter("clubName", user.getShootingClub()).getSingleResult();
        } catch (NoResultException nre) {
            clubModel = new ClubModel(user.getShootingClub());
        }

        CountryModel countryModel = em.createNamedQuery("countryByName", CountryModel.class)
                .setParameter("countryName", user.getCountry()).getSingleResult();

        HandgunDivisionModel hdm = em.createNamedQuery("hdmByName", HandgunDivisionModel.class)
                .setParameter("hdmName", user.getDefaultHandgunDevision().toString())
                .setParameter("pfName", user.getDefaultHandgunPowerFactor().toString()).getSingleResult();

        ShotgunDivisionModel sdm = null;
        if (user.getDefaultShotgunDevision() != null) {

            sdm = em.createNamedQuery("sdmByName", ShotgunDivisionModel.class)
                    .setParameter("sdmName", user.getDefaultShotgunDevision().toString()).getSingleResult();
        }

        RifleDivisionModel rdm = null;

        if (user.getDefaultRiffleDevision() != null) {
            rdm = em.createNamedQuery("rdmByName", RifleDivisionModel.class)
                    .setParameter("rdmName", user.getDefaultRiffleDevision().toString())
                    .setParameter("pfName", user.getDefaultRifflePowerFactor().toString()).getSingleResult();
        }

        return new UserModel(user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getUsername(),
                user.getAlias(), user.getPassword(), user.getEmail(), user.getTelephone(), roleModel, clubModel,
                countryModel, categoryModel, hdm, sdm, rdm);

    }

    @Override
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
