package com.epam.service;

import com.epam.core.model.User;
import com.epam.core.utilities.property.PropertyDataReader;

import java.util.Properties;

public final class UsersManager {
    private static Properties properties = PropertyDataReader.getProperties(System.getProperty("tests-data"));

    private UsersManager() {
    }

    public static User getFirstFacebookUser() {
        return FirstFaceBookUserHolder.FIRST_FACE_BOOK_USER;
    }

    public static User getSecondFacebookUser() {
        return SecondFaceBookUserHolder.SECOND_FACEBOOK_USER;
    }

    public static User getCourseraUser() {
        return CourseraUserHolder.COURSERA_USER;
    }

    public static User getUserWithProfileProperties() {
        return UserWithProfilePropertiesHolder.USER_WITH_PROFILE_PROPERTIES;
    }

    public static User getUserEmailU() {
        return UserEmailUHolder.USER_EMAIL_U;
    }

    public static User getGoogleUser() {
        return GoogleUserHolder.GOOGLE_USER;
    }

    private static class FirstFaceBookUserHolder {
        public static final User FIRST_FACE_BOOK_USER = User.newBuilder()
                .setFullName(properties.getProperty("facebook.user.name"))
                .setEmail(properties.getProperty("facebook.email"))
                .setPassword(properties.getProperty("facebook.password"))
                .build();
    }

    private static class SecondFaceBookUserHolder {
        public static final User SECOND_FACEBOOK_USER = User.newBuilder()
                .setFullName(properties.getProperty("facebook2.user.name"))
                .setEmail(properties.getProperty("facebook2.email"))
                .setPassword(properties.getProperty("facebook2.password"))
                .build();
    }

    private static class CourseraUserHolder {
        public static final User COURSERA_USER = User.newBuilder()
                .setEmail(properties.getProperty("coursera.email"))
                .setPassword(properties.getProperty("coursera.password"))
                .setNewPassword(properties.getProperty("new.password"))
                .build();
    }

    private static class UserWithProfilePropertiesHolder {
        public static final User USER_WITH_PROFILE_PROPERTIES = User.newBuilder()
                .setEmail(properties.getProperty("pavelTests.email"))
                .setPassword(properties.getProperty("pavelTests.password"))
                .setEmployedTimeStatus(properties.getProperty("employedTimeStatus"))
                .setIndustry(properties.getProperty("industry"))
                .setEmployer(properties.getProperty("employer"))
                .setOccupation(properties.getProperty("occupation"))
                .setExperiencedLevel(properties.getProperty("experiencedLevel"))
                .setIsItYourCurrentEmployer(properties.getProperty("isItYourCurrentEmployer"))
                .setHighestDegree(properties.getProperty("highestDegree"))
                .setUniversity(properties.getProperty("university"))
                .setEducationMajor(properties.getProperty("educationMajor"))
                .setAreYouCurrentlyStudent(properties.getProperty("areYouCurrentlyStudent"))
                .build();
    }

    private static class UserEmailUHolder {
        public static final User USER_EMAIL_U = User.newBuilder()
                .setEmail(properties.getProperty("emailU"))
                .setPassword(properties.getProperty("passwordU"))
                .setFirstName(properties.getProperty("form.firstname"))
                .setLastName(properties.getProperty("form.lastname"))
                .setPhoneNumber(properties.getProperty("form.phonenumber"))
                .setLocation(properties.getProperty("form.country"))
                .setState(properties.getProperty("form.state"))
                .setTwitterPassword(properties.getProperty("twitter.password"))
                .build();
    }

    private static class GoogleUserHolder {
        public static final User GOOGLE_USER = User.newBuilder()
                .setEmail(properties.getProperty("google.email"))
                .setPassword(properties.getProperty("google.password"))
                .setFirstName(properties.getProperty("confirmation.firstname"))
                .setMiddleName(properties.getProperty("confirmation.middlename"))
                .setLastName(properties.getProperty("confirmation.lastname"))
                .setFullName(properties.getProperty("user.name"))
                .setCourseName(properties.getProperty("course.name"))
                .build();
    }
}


