package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	public static void main(String[] args) {

		// GPSPoint(int time, double latitude, double longitude, double elevation)
		GPSPoint point1 = new GPSPoint(29839, 6.28882, 5.22222, 50.2);
		GPSPoint point2 = new GPSPoint(28302, 8.82322, 7.01298, 49.9);
		GPSPoint point3 = new GPSPoint(62362, 5.83433, 6.95228, 48.5);

		double s = point1.getLatitude();

		// GPSData(int antall)
		// gpspoints = new GPSPoint[antall];
		GPSData gpspoints = new GPSData(3);

		// Public boolean insert(String time, String latitude, String longitude, String
		// elevation)
		boolean punk1 = gpspoints.insertGPS(point1);
		boolean punk2 = gpspoints.insertGPS(point2);
		boolean punk3 = gpspoints.insertGPS(point3);

		gpspoints.print();
		;

	}
}
