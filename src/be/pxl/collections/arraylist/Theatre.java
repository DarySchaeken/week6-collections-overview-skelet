package be.pxl.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	private String theatreName;
	private List<Seat> seats = new ArrayList<>();
	private int seatsPerRow;
	private int numRows;

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		this.seatsPerRow = seatsPerRow;
		this.numRows = numRows;
		// voeg alle stoelen toe in het theater, nummer alle stoelen.
		// de eerste rij stoelen is genummerd vanaf A1, A2,...
		// de tweede rij stoelen is genummerd vanaf B1, B2,...

		char rowLetter = 'A';
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 1; j <= this.seatsPerRow; j++) {
				seats.add(new Seat(String.format("%c%d", rowLetter, j)));
			}
			rowLetter++;
		}
	}

	public void displayMap() {
		int count = 0;
		for (Seat seat : seats) {
			System.out.print(seat + " ");
			count++;
			if (count % seatsPerRow == 0) {
				System.out.println();
			}
		}
	}

	public boolean reservateSeat(String seatNumber) {
		Seat seat = getSeatBySeatNumber(seatNumber);
		if (seat != null) {
			seat.reserve();
			return true;
		}
		return false;
	}

	private Seat getSeatBySeatNumber(String seatNumber) {
		return seats.stream().filter(s -> s.getSeatNumber().equals(seatNumber)).findFirst().orElse(null);
	}

	public String getTheatreName() {
		return theatreName;
	}

	private class Seat {
		private String seatNumber;
		private boolean reserved = false;

		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean reserve() {
			if (isReserved()) {
				System.out.println("Seat " + seatNumber + " already reserved.");
				return false;
			}
			reserved = true;
			return reserved;
		}

		public boolean isReserved() {
			return reserved;
		}

		@Override
		public String toString() {
			return (reserved ? "*" : "") + seatNumber + (reserved ? "*" : "");
		}
	}
}
