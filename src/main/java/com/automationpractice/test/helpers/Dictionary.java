package com.automationpractice.test.helpers;

public class Dictionary {
    public static final String STATE_BY_DEFAULT_FLORIDA = "Florida";

    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";

    public static final String SPANISH_CODE_LANGUAGE = "es";
    public static final String COUNTRY_CODE = "CO";

    public static final String EMAIL_DOMAIN = "@sofmail.com";

    public static final String FILE_EVIDENCE_PROPERTY = "files.evidence";
    public static final String APP_URL_PROPERTY = "app.url";

    private static final String PROPERTIES_FILE_BASE_PATH = "src/main/resources/properties/";

    public static final String CONFIGURATION_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH + "configuration.properties";

    public static final String MAIL_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH +"mail.properties";

    public static final String SIZE_S = "1";
    public static final String SIZE_M = "2";
    public static final String SIZE_L = "3";

    public static final String MSG_ALL_OK_INSELECTION  ="01. Summary";
    public static final String MSG_ALL_OK_INSSHOP  ="Your order on My Store is complete.";

    public static final String MSG_TO_SEND = "Mil gracias por la atencion prestada";
    public static final String MSG_ALL_OKMSG_CONTACT_US = "Your message has been successfully sent to our team.";
    public static final String MSG_ALL_NOT_OK_MSG_CONTACT_US = "There is 1 error\n" + "Invalid email address.";
}
