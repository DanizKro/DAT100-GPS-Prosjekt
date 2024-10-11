package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		int mins = Integer.parseInt(timestr.substring(14, 16))*60;
		int timer = Integer.parseInt(timestr.substring(11, 13))*60*60;
		int sek = Integer.parseInt(timestr.substring(17, 19));
	
		int secs = mins + timer + sek;
	
		return secs;
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
}
