package nl.jijalsproduct.model;

public class CalculatorInput {

    private int age = 25;
    private int socialMinutes = 60;    // Instagram / TikTok
    private int videoMinutes = 45;     // YouTube / Netflix
    private int musicMinutes = 40;     // Spotify / Apple Music
    private int mapsMinutes = 10;      // Google Maps / Uber
    private int phonePicks = 60;

    public int getAge() { return age; }
    public void setAge(int v) { this.age = v; }

    public int getSocialMinutes() { return socialMinutes; }
    public void setSocialMinutes(int v) { this.socialMinutes = v; }

    public int getVideoMinutes() { return videoMinutes; }
    public void setVideoMinutes(int v) { this.videoMinutes = v; }

    public int getMusicMinutes() { return musicMinutes; }
    public void setMusicMinutes(int v) { this.musicMinutes = v; }

    public int getMapsMinutes() { return mapsMinutes; }
    public void setMapsMinutes(int v) { this.mapsMinutes = v; }

    public int getPhonePicks() { return phonePicks; }
    public void setPhonePicks(int v) { this.phonePicks = v; }
}
