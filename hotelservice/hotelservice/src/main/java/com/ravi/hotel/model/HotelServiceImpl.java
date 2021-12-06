package com.ravi.hotel.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class HotelServiceImpl implements HotelService {

	HashMap<Integer, Hotel> allHotels = new HashMap<>();
	int currentId = 100;

	HashMap<String, User> allUsers = new HashMap<>();

	public HotelServiceImpl() {
		init();
	}

	private void init() {

		// Hotel 1
		Hotel hotel = new Hotel();
		hotel.setHotelId(currentId++);
		hotel.setHotelName("Taj Banjara");
		hotel.setAddress("Madhapur, Hyderabad, Telangana - 500082");
		hotel.setRating(4.5f);
		hotel.setImage("https://upload.wikimedia.org/wikipedia/commons/c/c5/Taj_banjarahills_hyderabad.jpg");
		ArrayList<RoomInfo> roomList = new ArrayList<RoomInfo>();
		RoomInfo room = new RoomInfo();
		room.setPrice(90.1f);
		room.setrImage("https://upload.wikimedia.org/wikipedia/commons/c/c5/Taj_banjarahills_hyderabad.jpg");
		room.setRoomId(1000 + currentId);
		room.setRoomType("Luxary");
		roomList.add(room);
		room = new RoomInfo();
		room.setPrice(95.1f);
		room.setrImage("https://upload.wikimedia.org/wikipedia/commons/c/c5/Taj_banjarahills_hyderabad.jpg");
		room.setRoomId(1001 + currentId);
		room.setRoomType("Deluxe");
		roomList.add(room);
		hotel.setRoomInfo(roomList);
		allHotels.put(hotel.getHotelId(), hotel);

		hotel = new Hotel();
		hotel.setHotelId(currentId++);
		hotel.setHotelName("Avasa");
		hotel.setAddress("Survey No. 64, Hitech City Rd, Hyderabad, Telangana 500081");
		hotel.setRating(4.2f);
		hotel.setImage("https://pix10.agoda.net/hotelImages/339/339623/339623_131203151721855.jpg");
		roomList = new ArrayList<RoomInfo>();
		room = new RoomInfo();
		room.setPrice(90.1f);
		room.setrImage("https://pix10.agoda.net/hotelImages/339/339623/339623_131203151721855.jpg");
		room.setRoomId(1000 + currentId);
		room.setRoomType("Luxary");
		roomList.add(room);
		room = new RoomInfo();
		room.setPrice(95.1f);
		room.setrImage("https://pix10.agoda.net/hotelImages/339/339623/339623_131203151721855.jpg");
		room.setRoomId(1001 + currentId);
		room.setRoomType("Deluxe");
		roomList.add(room);
		hotel.setRoomInfo(roomList);
		allHotels.put(hotel.getHotelId(), hotel);

		hotel = new Hotel();
		hotel.setHotelId(currentId++);
		hotel.setHotelName("Novotel");
		hotel.setAddress("P.O Bag 1101, near Hitec City, Kondapur, Telangana 500081");
		hotel.setRating(4.5f);
		hotel.setImage("https://www.ahstatic.com/photos/6182_ho_00_p_1024x768.jpg");
		roomList = new ArrayList<RoomInfo>();
		room = new RoomInfo();
		room.setPrice(90.1f);
		room.setrImage("https://www.ahstatic.com/photos/6182_ho_00_p_1024x768.jpg");
		room.setRoomId(1000 + currentId);
		room.setRoomType("Luxary");
		roomList.add(room);
		room = new RoomInfo();
		room.setPrice(95.1f);
		room.setrImage("https://www.ahstatic.com/photos/6182_ho_00_p_1024x768.jpg");
		room.setRoomId(1001 + currentId);
		room.setRoomType("Deluxe");
		roomList.add(room);
		hotel.setRoomInfo(roomList);
		allHotels.put(hotel.getHotelId(), hotel);

		User user = new User();
		user.setUsername("ravi");
		user.setPassword("ravi");
		user.setEmail("dasariraviteja55@gmail.com");
		user.setPhoneNumber("1234567890");
		user.setSecurityAnswer("Dharmavaram");
		allUsers.put(user.getUsername(), user);

		user = new User();
		user.setUsername("sai");
		user.setPassword("sai");
		user.setEmail("pasaiteja1234@gmail.com");
		user.setPhoneNumber("1234567890");
		user.setSecurityAnswer("Kodada");
		allUsers.put(user.getUsername(), user);

	}

	@Override
	public List<Hotel> getHotels() {

		System.out.println("Getting All Hotels...");

		Collection<Hotel> hotels = allHotels.values();
		return new ArrayList<>(hotels);
	}

	@Override
	public Response addHotel(Hotel hotel) {
		hotel.setHotelId(++currentId);
		allHotels.put(hotel.getHotelId(), hotel);
		return Response.ok(hotel).build();
	}

	@Override
	public Response getHotelById(int id) {
		if (allHotels.containsKey(id)) {
			return Response.ok(allHotels.get(id)).build();
		}
		return Response.notModified().build();
	}

	@Override
	public Response updateHotel(Hotel hotel) {
		if (allHotels.containsKey(hotel.getHotelId())) {
			allHotels.put(hotel.getHotelId(), hotel);
			return Response.ok().build();
		}
		return Response.notModified().build();
	}

	@Override
	public Response deleteHotel(int id) {
		if (allHotels.containsKey(id)) {
			allHotels.remove(id);
			return Response.ok().build();
		}
		return Response.notModified().build();
	}

	@Override
	public Status validateUser(String username, String password) {

		System.out.println(allUsers.containsKey(username));

		if (!allUsers.containsKey(username)) {
			return Response.Status.NOT_FOUND;
		}

		User user = allUsers.get(username);
		System.out.println("User >>> " + user.getPassword());
		if (user.getPassword().equals(password)) {
			return Response.Status.ACCEPTED;
		} else {
			return Response.Status.UNAUTHORIZED;
		}
	}

	@Override
	public Response addUser(String content) {

		Gson gson = new Gson();
		User newUser = gson.fromJson(content, User.class);

		allUsers.put(newUser.getUsername(), newUser);

		return Response.ok().build();
	}

}
