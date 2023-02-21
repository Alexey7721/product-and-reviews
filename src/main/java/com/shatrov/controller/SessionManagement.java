package com.shatrov.controller;

import com.shatrov.interfaces.OpeningClosingSessions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionManagement implements OpeningClosingSessions {
    private SessionFactory sessionFactory;

    public SessionManagement(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }

    @Override
    public void sessionClose(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void sessionFactoryClose() {
        sessionFactory.close();
    }
}
