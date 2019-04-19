package model;

public class Contacts {
    private String name;
    private String phoneNo;
    private String email;
    private String address;
    private int imageId;


    public Contacts(String name, String phoneNo,String email, String address, int imageId) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.imageId = imageId;
        this.address=address;
        this.email= email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {this.email = email; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
}
