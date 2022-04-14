package com.epam.service;

import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.Folder;
import javax.mail.Flags;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import java.util.Properties;

public final class GmailMailChecker {
    private static final String IMAP_HOST = "mail.imap.host";
    private static final String IMAP_GMAIL = "imap.gmail.com";
    private static final String IMAP_PORT = "mail.imap.port";
    private static final String IMAP_PORT_NUMBER = "993";
    private static final String MAIL_STORE_TYPE = "imap";
    private static final String MAIL_IMAP_STARTTLS_ENABLE = "mail.imap.starttls.enable";
    private static final String SSL_TRUST = "mail.imap.ssl.trust";
    private static final String PROTOCOL = "imaps";
    private static final Logger LOGGER = LogManager.getRootLogger();

    private GmailMailChecker() {
    }

    public static boolean check(final String host, final String storeType,
                                final String user, final String password, final String
                                        subjectToSearch) {
        LOGGER.info("checking inbox for gmail");
        boolean inboxHasMailWithSubject = false;
        WaitersService.threadSleep();
        try {
            Session emailSession = Session.getDefaultInstance(setSessionProperties());
            Store store = emailSession.getStore(PROTOCOL);
            store.connect(host, user, password);
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                if (message.getSubject().contains(subjectToSearch)) {
                    inboxHasMailWithSubject = true;
                }
            }
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Error connecting to gmail:" + e.getMessage());
        }
        return inboxHasMailWithSubject;
    }

    public static Properties setSessionProperties() {
        Properties properties = new Properties();
        properties.put(IMAP_HOST, IMAP_GMAIL);
        properties.put(IMAP_PORT, IMAP_PORT_NUMBER);
        properties.put(MAIL_IMAP_STARTTLS_ENABLE, "true");
        properties.put(SSL_TRUST, IMAP_GMAIL);
        return properties;
    }

    public static boolean emailReceived(final String username, final String password, final String subject) {
        return GmailMailChecker.check(IMAP_GMAIL, MAIL_STORE_TYPE, username, password, subject);
    }
}
