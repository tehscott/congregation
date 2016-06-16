package model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Properties;

import util.Util;

public class Name {
    private static String[] maleFirstNames;
    private static String[] femaleFirstNames;
    private static String[] asianLastNames;
    private static String[] blackLastNames;
    private static String[] hispanicLastNames;
    private static String[] whiteLastNames;

    public static void init(Context context) {
        PropertyReader propertyReader = new PropertyReader(context);

        if(maleFirstNames == null) {
            maleFirstNames = propertyReader.get("names.properties").getProperty("MaleFirstNames").split(",");
        }

        if(femaleFirstNames == null) {
            femaleFirstNames = propertyReader.get("names.properties").getProperty("FemaleFirstNames").split(",");
        }

        if(asianLastNames == null) {
            asianLastNames = propertyReader.get("names.properties").getProperty("AsianLastNames").split(",");
        }

        if(blackLastNames == null) {
            blackLastNames = propertyReader.get("names.properties").getProperty("BlackLastNames").split(",");
        }

        if(hispanicLastNames == null) {
            hispanicLastNames = propertyReader.get("names.properties").getProperty("HispanicLastNames").split(",");
        }

        if(whiteLastNames == null) {
            whiteLastNames = propertyReader.get("names.properties").getProperty("WhiteLastNames").split(",");
        }
    }

    public static String generateName(Person person) {
        if(maleFirstNames == null || femaleFirstNames == null || asianLastNames == null || blackLastNames == null || hispanicLastNames == null || whiteLastNames== null ) {
            throw new IllegalStateException("You must call init() first.");
        }

        if(person != null && person.mGender != null && person.mRace != null) {
            String firstName = "";
            String lastName = "";

            if(person.mGender == Gender.MALE) {
                firstName = Name.maleFirstNames[Util.generateRandomIntInRange(0, Name.maleFirstNames.length - 1)];
            } else {
                firstName = Name.femaleFirstNames[Util.generateRandomIntInRange(0, Name.femaleFirstNames.length - 1)];
            }

            if(person.mRace == Race.WHITE) {
                lastName = Name.whiteLastNames[Util.generateRandomIntInRange(0, Name.whiteLastNames.length - 1)];
            } else if(person.mRace == Race.ASIAN) {
                lastName = Name.asianLastNames[Util.generateRandomIntInRange(0, Name.asianLastNames.length - 1)];
            } else if(person.mRace == Race.BLACK) {
                lastName = Name.blackLastNames[Util.generateRandomIntInRange(0, Name.blackLastNames.length - 1)];
            } else if(person.mRace == Race.HISPANIC) {
                lastName = Name.hispanicLastNames[Util.generateRandomIntInRange(0, Name.hispanicLastNames.length - 1)];
            }

            return firstName + " " + lastName;
        } else {
            throw new InvalidParameterException("Gender and Race must be set before calling this.");
        }
    }

    private static class PropertyReader {
        private Context context;
        private Properties properties;

        public PropertyReader(Context context) {
            this.context = context;
            properties = new Properties();
        }

        public Properties get(String file) {
            try {
                AssetManager assetManager = context.getAssets();
                InputStream inputStream = assetManager.open(file);
                properties.load(inputStream);

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }

            return properties;
        }
    }
}