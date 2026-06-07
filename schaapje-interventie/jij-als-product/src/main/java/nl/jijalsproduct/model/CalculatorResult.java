package nl.jijalsproduct.model;

public class CalculatorResult {

    // Tijd
    private double hoursPerDay;
    private int daysPerYear;
    private double lifeYearsLost;

    // Advertentie-inkomsten
    private String adRevenueRange;

    // Gedragsbepaling
    private int behaviourNudgesPerDay;        // keer per dag gedrag beïnvloed
    private int behaviourNudgesPerYear;       // per jaar
    private int behaviourNudgesLifetime;      // rest leven
    private String behaviourExampleSocial;    // voorbeeld social
    private String behaviourExampleMusic;     // voorbeeld muziek
    private String behaviourExampleMaps;      // voorbeeld maps/uber

    // Alternatieven
    private int booksPerYear;
    private double languageFactor;
    private int realConversations;
    private int runSessions;

    // Data verzameling
    private long locationPoints;
    private int adProfiles;
    private long screenEvents;

    // Warning
    private boolean showWarning;
    private String warningText;

    public double getHoursPerDay() { return hoursPerDay; }
    public void setHoursPerDay(double v) { this.hoursPerDay = v; }

    public int getDaysPerYear() { return daysPerYear; }
    public void setDaysPerYear(int v) { this.daysPerYear = v; }

    public double getLifeYearsLost() { return lifeYearsLost; }
    public void setLifeYearsLost(double v) { this.lifeYearsLost = v; }

    public String getAdRevenueRange() { return adRevenueRange; }
    public void setAdRevenueRange(String v) { this.adRevenueRange = v; }

    public int getBehaviourNudgesPerDay() { return behaviourNudgesPerDay; }
    public void setBehaviourNudgesPerDay(int v) { this.behaviourNudgesPerDay = v; }

    public int getBehaviourNudgesPerYear() { return behaviourNudgesPerYear; }
    public void setBehaviourNudgesPerYear(int v) { this.behaviourNudgesPerYear = v; }

    public int getBehaviourNudgesLifetime() { return behaviourNudgesLifetime; }
    public void setBehaviourNudgesLifetime(int v) { this.behaviourNudgesLifetime = v; }

    public String getBehaviourExampleSocial() { return behaviourExampleSocial; }
    public void setBehaviourExampleSocial(String v) { this.behaviourExampleSocial = v; }

    public String getBehaviourExampleMusic() { return behaviourExampleMusic; }
    public void setBehaviourExampleMusic(String v) { this.behaviourExampleMusic = v; }

    public String getBehaviourExampleMaps() { return behaviourExampleMaps; }
    public void setBehaviourExampleMaps(String v) { this.behaviourExampleMaps = v; }

    public int getBooksPerYear() { return booksPerYear; }
    public void setBooksPerYear(int v) { this.booksPerYear = v; }

    public double getLanguageFactor() { return languageFactor; }
    public void setLanguageFactor(double v) { this.languageFactor = v; }

    public int getRealConversations() { return realConversations; }
    public void setRealConversations(int v) { this.realConversations = v; }

    public int getRunSessions() { return runSessions; }
    public void setRunSessions(int v) { this.runSessions = v; }

    public long getLocationPoints() { return locationPoints; }
    public void setLocationPoints(long v) { this.locationPoints = v; }

    public int getAdProfiles() { return adProfiles; }
    public void setAdProfiles(int v) { this.adProfiles = v; }

    public long getScreenEvents() { return screenEvents; }
    public void setScreenEvents(long v) { this.screenEvents = v; }

    public boolean isShowWarning() { return showWarning; }
    public void setShowWarning(boolean v) { this.showWarning = v; }

    public String getWarningText() { return warningText; }
    public void setWarningText(String v) { this.warningText = v; }
}
