package com.serdarormanli.goeuro.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class City {

	@SerializedName("_id")
	@Expose
	private Integer Id;
	@Expose
	private Object key;
	@Expose
	private String name;
	@Expose
	private String fullName;
	@SerializedName("iata_airport_code")
	@Expose
	private String iataAirportCode;
	@Expose
	private String type;
	@Expose
	private String country;
	@SerializedName("geo_position")
	@Expose
	private GeoPosition geoPosition;
	@Expose
	private Object locationId;
	@Expose
	private Boolean inEurope;
	@Expose
	private String countryCode;
	@Expose
	private Boolean coreCountry;
	@Expose
	private Object distance;

	/**
	 * 
	 * @return The Id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * 
	 * @param Id
	 *            The _id
	 */
	public void setId(Integer Id) {
		this.Id = Id;
	}

	/**
	 * 
	 * @return The key
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * 
	 * @param key
	 *            The key
	 */
	public void setKey(Object key) {
		this.key = key;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 
	 * @param fullName
	 *            The fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * 
	 * @return The iataAirportCode
	 */
	public String getIataAirportCode() {
		return iataAirportCode;
	}

	/**
	 * 
	 * @param iataAirportCode
	 *            The iata_airport_code
	 */
	public void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 *            The country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return The geoPosition
	 */
	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	/**
	 * 
	 * @param geoPosition
	 *            The geo_position
	 */
	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	/**
	 * 
	 * @return The locationId
	 */
	public Object getLocationId() {
		return locationId;
	}

	/**
	 * 
	 * @param locationId
	 *            The locationId
	 */
	public void setLocationId(Object locationId) {
		this.locationId = locationId;
	}

	/**
	 * 
	 * @return The inEurope
	 */
	public Boolean getInEurope() {
		return inEurope;
	}

	/**
	 * 
	 * @param inEurope
	 *            The inEurope
	 */
	public void setInEurope(Boolean inEurope) {
		this.inEurope = inEurope;
	}

	/**
	 * 
	 * @return The countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * 
	 * @param countryCode
	 *            The countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * 
	 * @return The coreCountry
	 */
	public Boolean getCoreCountry() {
		return coreCountry;
	}

	/**
	 * 
	 * @param coreCountry
	 *            The coreCountry
	 */
	public void setCoreCountry(Boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	/**
	 * 
	 * @return The distance
	 */
	public Object getDistance() {
		return distance;
	}

	/**
	 * 
	 * @param distance
	 *            The distance
	 */
	public void setDistance(Object distance) {
		this.distance = distance;
	}

}
