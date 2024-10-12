package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {

		GPSPoint point1 = new GPSPoint(29839, 6.28882, 5.22222, 50.2);
		GPSPoint point2 = new GPSPoint(28302, 8.82322, 7.01298, 49.9);
		
		GPSData gpspoints = new GPSData(2);
		
		String p1 = point1.toString();
		
		
		
		System.out.print(p1);
		
		
	}
}
