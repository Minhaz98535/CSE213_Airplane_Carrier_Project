package NonUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class gps implements Serializable {
    private String vesselName;
    private String aisId;
    private double latitude;
    private double longitude;
    private double speed;
    private String heading;
    private double range;
    private String riskLevel;


    public gps() {
        this.vesselName = "USS Enterprise (Self)";
        this.aisId = "AIS-99900";
        this.latitude = 21.4272;   // বঙ্গোপসাগরের কাছাকাছি ডামি লোকেশন
        this.longitude = 91.9702;
        this.speed = 22.5;
        this.heading = "180° S";
        this.range = 0.0;
        this.riskLevel = "No Risk";
    }

    public gps(String vesselName, String aisId, double range, double speed, String heading, String riskLevel) {
        this.vesselName = vesselName;
        this.aisId = aisId;
        this.range = range;
        this.speed = speed;
        this.heading = heading;
        this.riskLevel = riskLevel;
    }


    public String getVesselName() { return vesselName; }
    public String getAisId() { return aisId; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public double getSpeed() { return speed; }
    public String getHeading() { return heading; }
    public double getRange() { return range; }
    public String getRiskLevel() { return riskLevel; }

    public String getFormattedPosition() {
        return String.format("%.4f° N, %.4f° E", latitude, longitude);
    }

    public void updateLivePosition() {
        Random rand = new Random();
        this.latitude += (rand.nextDouble() - 0.5) * 0.05;
        this.longitude += (rand.nextDouble() - 0.5) * 0.05;
        this.speed = 18.0 + rand.nextInt(10); // ১৮ থেকে ২৭ Knots এর মধ্যে স্পিড দেখাবে
    }

    public static String calculateDummyRoute(String destination) {
        Random rand = new Random();
        int distance = 120 + rand.nextInt(400); // ডামি দূরত্ব (km)
        int windSpeed = 10 + rand.nextInt(25);  // ডামি বাতাসের গতি (Knots)
        String waypoint = String.format("%.2f° N, %.2f° E", 20.5 + rand.nextDouble(), 90.5 + rand.nextDouble());

        return distance + " km|" + waypoint + "|" + windSpeed + " Knots";
    }

    public static ArrayList<gps> getDummyNearbyVessels() {
        ArrayList<gps> list = new ArrayList<>();
        list.add(new gps("MV Bengal Star", "AIS-1042", 12.5, 14.2, "045° NE", "Low"));
        list.add(new gps("MT Ocean Titan", "AIS-2089", 4.8, 19.5, "270° W", "High"));
        list.add(new gps("FV Sea Hunter", "AIS-3310", 8.2, 9.0, "110° SE", "Medium"));
        list.add(new gps("MV Padma Express", "AIS-4512", 18.0, 16.4, "320° NW", "Low"));
        return list;
    }
}