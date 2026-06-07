package nl.jijalsproduct.model;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculatorResult calculate(CalculatorInput input) {
        CalculatorResult result = new CalculatorResult();

        int totalMinutes = input.getSocialMinutes() + input.getVideoMinutes()
                         + input.getMusicMinutes() + input.getMapsMinutes();
        double hoursPerDay  = totalMinutes / 60.0;
        double hoursPerYear = hoursPerDay * 365;
        int daysPerYear     = (int) Math.round(hoursPerYear / 24.0);
        int lifeLeft        = Math.max(0, 80 - input.getAge());
        double lifeYearsLost = Math.round((hoursPerYear * lifeLeft / 8760.0) * 10.0) / 10.0;

        result.setHoursPerDay(Math.round(hoursPerDay * 10.0) / 10.0);
        result.setDaysPerYear(daysPerYear);
        result.setLifeYearsLost(lifeYearsLost);

        // --- Advertentie-inkomsten (op basis van CPM & ARPU bronnen) ---
        // Social (Meta/TikTok): ~€0.015/min gebruik
        // Video (YouTube):      ~€0.010/min gebruik
        // Music (Spotify):      ~€0.004/min gebruik (lager, geen display ads)
        // Maps/Uber:            ~€0.020/min gebruik (hoge locatiewaarde)
        double revPerYear = (input.getSocialMinutes() * 0.015
                           + input.getVideoMinutes()  * 0.010
                           + input.getMusicMinutes()  * 0.004
                           + input.getMapsMinutes()   * 0.020) * 365;
        double revLow  = Math.round(revPerYear * 0.7 * 10.0) / 10.0;
        int    revHigh = (int) Math.round(revPerYear * 1.3);
        result.setAdRevenueRange("€" + revLow + " – €" + revHigh);

        // --- Gedragsbepaling ---
        // Elke aanbeveling (feed, autoplay, route, song) = 1 nudge
        // Social feed: 1 nudge per 30 sec scrollen
        // Video autoplay: 1 nudge per video (~8 min gem.)
        // Music aanbeveling: 1 nudge per 3 nummers (~10 min)
        // Maps/Uber: 1 nudge per sessie + gesponsorde routes
        double nudgesPerDay = (input.getSocialMinutes() * 2.0)          // elke 30 sec
                            + (input.getVideoMinutes() / 8.0)            // per video
                            + (input.getMusicMinutes() / 10.0)           // per 3 songs
                            + (input.getMapsMinutes() * 1.5)             // per sessie+route
                            + (input.getPhonePicks() * 0.3);             // notificatie-nudges

        int nudgesDay      = (int) Math.round(nudgesPerDay);
        int nudgesYear     = (int) Math.round(nudgesPerDay * 365);
        int nudgesLifetime = (int) Math.round(nudgesPerDay * 365 * lifeLeft);

        result.setBehaviourNudgesPerDay(nudgesDay);
        result.setBehaviourNudgesPerYear(nudgesYear);
        result.setBehaviourNudgesLifetime(nudgesLifetime);

        // Contextuele voorbeelden
        result.setBehaviourExampleSocial(
            "Jouw feed toont ~" + (int)(input.getSocialMinutes() * 2) +
            " posts per dag. Allemaal handmatig geselecteerd door een algoritme."
        );
        result.setBehaviourExampleMusic(
            "Spotify bepaalt ~" + Math.max(1, (int)(input.getMusicMinutes() / 3.5)) +
            " nummers per dag voor jou."
        );
        result.setBehaviourExampleMaps(
            "Google Maps stuurt je bewust langs gesponsorde locaties."
        );

        // --- Alternatieven ---
        result.setBooksPerYear((int) Math.round(hoursPerYear / 6.0));
        result.setLanguageFactor(Math.round((hoursPerYear / 500.0) * 10.0) / 10.0);
        result.setRealConversations((int) Math.round(hoursPerYear / 2.0));
        result.setRunSessions((int) Math.round(hoursPerYear / 0.75));

        // --- Data verzameling ---
        double sessionsPerDay = input.getPhonePicks()
                + (input.getSocialMinutes() / 5.0)
                + (input.getVideoMinutes()  / 20.0)
                + (input.getMusicMinutes()  / 30.0)
                + (input.getMapsMinutes()   / 5.0);

        result.setLocationPoints(Math.round(sessionsPerDay * 30 * 365));
        result.setAdProfiles((int) Math.round(200 + sessionsPerDay * 2));
        result.setScreenEvents(Math.round(sessionsPerDay * 120 * 365));

        return result;
    }
}
