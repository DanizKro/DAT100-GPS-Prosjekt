package no.hvl.dat100ptc.oppgave3;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;
import static javax.swing.JOptionPane.showInputDialog;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];

		for (double e : da) {
			if (e < min) {
				min = e;
			}
		}
		return min;

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitude = new double[gpspoints.length];

		for (int i = 0; i < latitude.length; i++) {

			latitude[i] = gpspoints[i].getLatitude();
		}
		return latitude;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];

		for (int i = 0; i < longitudes.length; i++) {

			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;
	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double latitude1 = gpspoint1.getLatitude();
		double longitude1 = gpspoint1.getLongitude();
		double latitude2 = gpspoint2.getLatitude();
		double longitude2 = gpspoint2.getLongitude();

		double phi1 = latitude1 * (Math.PI) / 180.0;
		double phi2 = latitude2 * (Math.PI) / 180.0;
		double deltaphi = ((latitude2 - latitude1) * Math.PI) / 180.0;
		double deltadelta = ((longitude2 - longitude1) * Math.PI) / 180.0;

		double a = compute_a(phi1, phi2, deltaphi, deltadelta);
		double c = compute_c(a);
		double d = R * c;

		return d;
	}

	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {

		double a = Math.pow(Math.sin((deltaphi / 2.0)), 2.0)
				+ (Math.cos(phi1) * Math.cos(phi2) * (Math.pow((Math.sin(deltadelta) / 2), 2)));

		return a;
	}

	private static double compute_c(double a) {

		double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt((1 - a)));

		return c;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		// tiden fra punkt 2 minus punkt 1
		// distanse fra punkt 1 til punkt 2
		// distansen / tiden

		int t1 = gpspoint1.getTime();
		int t2 = gpspoint2.getTime();
		int tid = t2 - t1;

		double distanse = distance(gpspoint1, gpspoint2);
		double speed = distanse / tid;

		return speed;

	}

	public static String formatTime(int secs) {

		int hour = (secs / 60 / 60);
		int min = (secs / 60 % 60);
		int sec = secs % 60;

		String formatertTid = String.format("%02d:%02d:%02d", hour, min, sec);

		return String.format("%10s", formatertTid); // Metoden String.format(kode, objekt) kan man gjøre mye med.

	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String desimal = String.format("%.2f", d); // metoden String.format og koden "%.2f" kutter desimaler til 2.

		return String.format("%" + TEXTWIDTH + "s", desimal); // (% - antall - S= stringlength, objekt)
	}
}
