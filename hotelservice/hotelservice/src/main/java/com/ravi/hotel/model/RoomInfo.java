/**
 * 
 */
package com.ravi.hotel.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

/**
 * @author Raviteja
 *
 */
@Component
public class RoomInfo {

	private int roomId;
	private String roomType;
	private String rImage;
	private float price;

	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * @return the rImage
	 */
	public String getrImage() {
		return rImage;
	}

	/**
	 * @param rImage the rImage to set
	 */
	public void setrImage(String rImage) {
		this.rImage = rImage;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

}
