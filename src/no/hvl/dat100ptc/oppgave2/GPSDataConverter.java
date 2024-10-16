package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		// "2017-08-13T08:52:26.000Z"
		// Tallet 08 har posisjon 11-13 - Timer
		// Tallet 52 har posisjon 14-16 - Minutter
		// Tallet 26 har posisjon 17-19 - Sekunder
		
		//bruker substring-metoden i String-klassen. tallet tallet i metoden avgir hvor start og slutt er på tallet du ønker.
		
		int mins = Integer.parseInt(timestr.substring(14, 16))*60;
		int timer = Integer.parseInt(timestr.substring(11, 13))*60*60;
		int sek = Integer.parseInt(timestr.substring(17, 19));
	
		int secs = mins + timer + sek;
	
		return secs;
	}

		// Skal ta inn data og lage et nytt GPS Point objekt med lagret data.
	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		int time = GPSDataConverter.toSeconds(timeStr);
	
		// Konverter latitude, longitude og elevation til double
        double latitude = Double.parseDouble(latitudeStr);
        double longitude = Double.parseDouble(longitudeStr);
        double elevation = Double.parseDouble(elevationStr);

        // Opprett et GPSPoint objekt med String-verdiene.
        return new GPSPoint(time, latitude, longitude, elevation);
		
	}
	
}
