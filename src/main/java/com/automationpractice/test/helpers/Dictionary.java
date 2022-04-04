package com.automationpractice.test.helpers;

public class Dictionary {
    public static final String STATE_BY_DEFAULT_FLORIDA         = "Florida";

    public static final String EMPTY_STRING                     = "";
    public static final String SPACE_STRING                     = " ";

    public static final String SPANISH_CODE_LANGUAGE            = "es";
    public static final String COUNTRY_CODE                     = "CO";

    public static final String EMAIL_DOMAIN                     = "@sofmail.com";

    public static final String FILE_EVIDENCE_PROPERTY           = "files.evidence";
    public static final String APP_URL_PROPERTY                 = "app.url";

    private static final String PROPERTIES_FILE_BASE_PATH       = "src/main/resources/properties/";

    public static final String CONFIGURATION_PROPERTIES_FILE    = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH + "configuration.properties";

    public static final String MAIL_PROPERTIES_FILE             = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH +"mail.properties";

    public static final String SIZE_S                           = "1";
    public static final String SIZE_L                           = "3";

    public static final String MSG_ALL_OK_INSELECTION           ="01. Summary";
    public static final String MSG_ALL_OK_INSSHOP               ="Your order on My Store is complete.";

    public static final String MSG_TO_SEND                      = "Cordial saludo, me gustarìa mayor "
                                                                    +"informacion Mil gracias por la atencion prestada";

    public static final String MSG_AFTER_SEND_ALL_THE_FIELDS    = "Your message has been "
                                                                   +"successfully sent to our team.";
    public static final String MSG_AFTER_SEND_FORM_NO_EMAIL     = "There is 1 error\n"
                                                                    + "Invalid email address.";

    public static final String ERROR_VALIDATING                 ="Ocurrio un error al intentar validar "
                                                                    +"la creación de un cuenta.";

    public static final String ERROR_TO_CONSULT_PROPERTY        ="Fallo al consultar una propiedad del archivo ";

    public static final String REPORT_INFO                      ="***** HA FINALIZADO LA PRUEBA******";
    public static final String TO_CONCAT                        ="-";
    public static final String MAXIMIZE                         ="start-maximized";

    public static final int SECONDS_TO_TIME_OUT                 = 10;
    public static final int MIN_PHONE_NUMBER                    = 300000000;
    public static final int MAX_PHONE_NUMBER                    = 399999999;
    public static final int MIN_NUMBER                          = 1;
    public static final int MAX_NUMBER                          = 9;
    public static final int DIGITS_PASSWORD                     = 8;
    public static final int MIN_DAY                             = 1;
    public static final int MAX_DAY                             = 28;
    public static final int MIN_MONTH                           = 1;
    public static final int MAX_MONTH                           = 12;
    public static final int MIN_YEAR                            = 1980;
    public static final int MAX_YEAR                            = 2003;
    public static final int SELECT_HEADING_OPTION1              = 1;
    public static final int SELECT_HEADING_OPTION2              = 2;

    public static final boolean SCREENSHOT                      = true;
    public static final boolean NOT_SCREENSHOT                  = false;



}
