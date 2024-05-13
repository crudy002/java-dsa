package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MeetingRoomProblem {

	/*
	There is one meeting room in a firm. 
	
	There are N meetings in the form of (S[i], F[i]) where S[i] is
	the start time of meeting i and F[i] is finish time of meeting i. 
	
	The task is to find the maximum
	number of meetings that can be accommodated in the meeting room. Print all meeting
	numbers 
	*/
	
	public static void main(String args[]) {
		
		MeetingRoomProblem mrp = new MeetingRoomProblem();
		mrp.runProblem();

	}

	public void runProblem() {
		// Edge case(s):
		// Start times and finish times arrays aren't the same length

		//ArrayList<Integer> startTimes = new ArrayList<>(Arrays.asList(1, 3, 0, 5, 8, 5));
		//ArrayList<Integer> finishTimes = new ArrayList<>(Arrays.asList(2, 4, 6, 7, 9, 9));
		
		ArrayList<Integer> startTimes = new ArrayList<>(Arrays.asList(75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924));
		ArrayList<Integer> finishTimes = new ArrayList<>(Arrays.asList(112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252));

		ArrayList<Meeting> allMeetings = new ArrayList<>();

		for (int i = 0; i < startTimes.size(); i++) {
			Meeting mtg = new Meeting(i, startTimes.get(i), finishTimes.get(i));
			System.out.println(mtg);
			allMeetings.add(mtg);
		}
		
		System.out.println("\n");
		Collections.sort(allMeetings);
		
		ArrayList<Meeting> viableMeetings = new ArrayList<>();
		
		Meeting prevMeeting = allMeetings.get(0);
		viableMeetings.add(prevMeeting);
		for (Meeting meeting : allMeetings) {
			System.out.println("Prev Meeting: " + prevMeeting);
			System.out.println("Cur Meeting: " + meeting);
			
			if (meeting.startTime >= prevMeeting.finishTime) {
				System.out.println("Meeting Added: " + (meeting.index + 1));
				viableMeetings.add(meeting);
				prevMeeting = meeting;
			}
		}
		
		System.out.println("\nSolution:");
		
		for (Meeting meeting : viableMeetings) {
			System.out.println(meeting.index + 1);
		}
		
		
	}

	class Meeting implements Comparable<Meeting>{
		int index;
		int startTime;
		int finishTime;
		
		public Meeting(int ind, int st, int ft) {
			this.index = ind;
			this.startTime = st;
			this.finishTime = ft;
		}
		
		@Override
		public String toString() {
			return "Meeting No. " + this.index + " Start: " + this.startTime + " Finish: " + this.finishTime;
		}
		
		@Override
		public int compareTo(Meeting meeting) {
		  return Integer.compare(this.finishTime, meeting.finishTime);
		}
	}

}