package net.cpbgroup.Saucier;

import java.util.Vector;

public class RequestBuffer<Request> extends Vector<Request> {
	
	/**
	 * Filters the RequestBuffer by the given hostname
	 * @param hostname
	 * @return
	 */
	public RequestBuffer<Request> filterBy(String hostname) {
		RequestBuffer<Request> filteredList = new RequestBuffer<Request>();
//		for(Request r : this) {
//			if(! r.uri.getHost().contains(hostname)) {
//				filteredList.add(r);
//			}
//		}
		return filteredList;
	}

	/**
	 * Filters the RequestBuffer by the given statusCode
	 * @param statusCode
	 * @return
	 */
	public RequestBuffer<Request> filterBy(int statusCode) {
		RequestBuffer<Request> filteredList = new RequestBuffer<Request>();
//		for(Request r : this) {
//			if(! r.uri.getHost().contains(hostname)) {
//				filteredList.add(r);
//			}
//		}
		return filteredList;
	}
}
