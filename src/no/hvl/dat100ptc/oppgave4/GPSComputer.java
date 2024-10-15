package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;
		
		// Variabel
		// kalle metode for avstand
		// Avstand (i) og i+1
		// repeter til < tab.length-1 (-1 fordi siste elementet i tabellen er en indeks lavere enn i)
		
		for (int i = 0; i < gpspoints.length-1; i++) {
			double lengde = GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			distance += lengde;
		} 
		return distance;
	}

	public double totalElevation() {

		double elevation = 0;

		// Variabel
		// Kalle metode for høyde i en repeterende for-løkke
		// Ta høyden minus forrige høyde for å sjekke om høyden har økt (må starte i = 1 for å sjekke om den kommer til å øke)
		
	    for (int i = 1; i < gpspoints.length; i++) {
	    	
	        double hoydeForskjell = gpspoints[i].getElevation() - gpspoints[i-1].getElevation();
	        
	        if (hoydeForskjell > 0) {
	            elevation += hoydeForskjell;
	        }
	    }
	    return elevation;
	}

	public int totalTime() {
		
		// Litt usikker på forklaring, fik hjelp fra chatt

		int startTid = gpspoints[0].getTime();
		int sluttTid = gpspoints[gpspoints.length-1].getTime();
		int totalTid = sluttTid-startTid;
			
		return (totalTid);
		
		} 
		

	public double[] speeds() {
		
		// speed tabell = bruke GPSUtils speed metode

		double[] speeds = new double[gpspoints.length-1];
		
		for (int i = 0; i < speeds.length; i ++) {
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}
		
		return speeds;
	} 
	
	public double maxSpeed() {
		
		// Ta inn tabellen speeds, sjekke om hvert element i den er større en forrige, hvis ja, endre verdi på maxspeed
		
		double maxspeed = 0;
		double neste = 0;
		
		double[] speeds = speeds();
		
		for (int i = 0; i < speeds.length-1; i ++) {
			
			maxspeed = speeds[i];
			neste = speeds[i+1];
			
			if (maxspeed < neste) {
				maxspeed = neste;
			}
			
		} return maxspeed;
	}

	public double averageSpeed() {
		
		// m/s = meter totalt / tid totalt
		// bruker metoden total distanse og total tid 

		double average = 0;
		
		double distanse = totalDistance();
		int totalTid = totalTime();
		
		average = (distanse/totalTid);
	
		return average;
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		
		double met = 0;		
		double speedmph = speed * MS;
		double t = secs/60/60;
		
		if (speedmph > 10 && speedmph < 12){		
			met = 6.0;
		} else if (speedmph > 12 && speedmph < 14) {
			met = 8.0;
		}else if (speedmph > 14 && speedmph < 16) {
			met = 10.0;
		}else if (speedmph > 16 && speedmph < 20) {
			met = 12.0;
		}
		
		double kcal = met * weight * t;
		
		return kcal;
	}

	public double totalKcal(double weight) {
		
		// usikker på hvilke verier som skal brukes?

		double totalkcal = 0;
		double[] speed = speeds();
		
		for (int i = 0; i < speed.length; i++) {
			
			int sekunder = gpspoints[i+1].getTime() - gpspoints[i].getTime();
			
			totalkcal += kcal(weight,sekunder,speed[i]);
			
		} return totalkcal;
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {
		
		int totalTid = totalTime();
		String totalFormatert = GPSUtils.formatTime(totalTid);
		double totalDistanse = totalDistance()/1000;
		double totalHoyde = totalElevation();
		double maxSpeed = maxSpeed();
		double gjHastighet = averageSpeed();
		double kcal = totalKcal(WEIGHT);
		
		
		System.out.println("===================================");
		System.out.println("Total time      :" + totalFormatert);
		System.out.println("Total distance 	:" + "  " + String.format("%.2f", totalDistanse) + " km");
		System.out.println("Total elevation :" + " " + String.format("%.2f", totalHoyde) + " m");
		System.out.println("Max speed       :" + "   " +String.format("%.2f", maxSpeed) + " km/t");
		System.out.println("Average speed   :" + "   " +String.format("%.2f", gjHastighet) + " km/t");
		System.out.println("Energy          :" + "   " +String.format("%.2f", kcal) + " kcal");
		System.out.println("===================================");
		
		
	}

}
