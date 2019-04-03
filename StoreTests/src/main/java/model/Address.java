package model;

public class Address {
    private String company;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String information;
    private String mobilePhone;
    private String addressAlias;

    public Address(String company, String address, String city, String state, String postalCode, String information, String mobilePhone, String addressAlias) {
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.information = information;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getInformation() {
        return information;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }
}
