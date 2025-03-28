package no.hvl.dat100ptc.oppgave5;

import no.hvl.dat100ptc.TODO;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import javax.swing.JOptionPane;

public class ShowProfile extends EasyGraphics {

	private static final int MARGIN = 50; // margin on the sides

	private static final int MAXBARHEIGHT = 500; // assume no height above 500 meters

	private GPSPoint[] gpspoints;

	public ShowProfile() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn (uten .csv): ");
		GPSComputer gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length; // number of data points

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + MAXBARHEIGHT);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + MAXBARHEIGHT);
	}

	public void showHeightProfile(int ybase) {

		setColor(0, 0, 250);

		int x = MARGIN; // første høyde skal tegnes ved MARGIN
		int y;
		int height = 0;

		for (int i = 0; i < gpspoints.length; i++) {

			// Hent høyden til hvert GPS-punkt, hvis høyden er over 0.
			if (gpspoints[i].getElevation() > 0)
				height = (int) gpspoints[i].getElevation();

			// Beregn y-koordinatet for toppen av søylen (høyere høyde tilsvarer lavere
			// y-verdi)
			y = ybase - height;

			drawLine(x, ybase, x, y);

			// Øk x-koordinatet for neste søyle
			x += 3;
		}
	}

}
