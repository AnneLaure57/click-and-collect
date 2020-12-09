package fr.ul.miage.clickandcollect.core.security;

public interface PasswordChecker {

    boolean areEqual(String source, String target);

}
