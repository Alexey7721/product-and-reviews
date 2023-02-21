package com.shatrov.interfaces;

import org.hibernate.Session;

/**
 * Интерфейс работы с сессиями
 */
public interface OpeningClosingSessions {
    /**
     * Метод, который открывает новую сессию
     */
    public Session getSession();
    /**
     * Метод, который закрывает сессию
     * @param session - сессия, которую нужно закрыть
     */
    public void sessionClose(Session session);
    /**
     * Метод, который завершает работу с сессиями(закрытие SessionFactory)
     */
    public void sessionFactoryClose();
}
