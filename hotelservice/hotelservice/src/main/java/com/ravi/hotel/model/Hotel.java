package com.ravi.hotel.model;

import java.util.ArrayList;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class Hotel {

	private int hotelId;
	private String hotelName;
	private String image;
	private String address;
	private float rating;
	private ArrayList<RoomInfo> roomInfo;

	public int getHotelId() {
		return hotelId;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the roomInfo
	 */
	public ArrayList<RoomInfo> getRoomInfo() {
		return roomInfo;
	}

	/**
	 * @param roomInfo the roomInfo to set
	 */
	public void setRoomInfo(ArrayList<RoomInfo> roomInfo) {
		this.roomInfo = roomInfo;
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

}
