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

		double[] speeds = new double[gpspoints.length-1];
		
		// TODO
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO 
		throw new UnsupportedOperationException(TODO.method());
	
	}

	public double averageSpeed() {

		double average = 0;
		
		// TODO
		throw new UnsupportedOperationException(TODO.method());
		
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;		
		double speedmph = speed * MS;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
