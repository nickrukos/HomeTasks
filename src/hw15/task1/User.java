package hw15.task1;

import java.util.HashMap;

public class User {
    private HashMap<String, String> mainContacts;
    private HashMap<String, String> additionalContacts;
    private boolean agreeWithAdditional;

    public User(boolean agreeOnAdditional) {
        this.agreeWithAdditional = agreeOnAdditional;
        mainContacts = new HashMap<>();
        additionalContacts = new HashMap<>();
    }

    public void changeAgreement(){
        agreeWithAdditional = !agreeWithAdditional;
    }

    public void addMain(String key, String value){
        mainContacts.put(key, value);
    }

    public void addAdditional(String key, String value){
        additionalContacts.put(key, value);
    }

    public HashMap<String, String> getMainContacts() {
        return mainContacts;
    }

    public HashMap<String, String> getAdditionalContacts() {
        return additionalContacts;
    }

    public boolean isAgreeWithAdditional() {
        return agreeWithAdditional;
    }
}
