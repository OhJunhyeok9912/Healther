package com.example.healtherlogin;

public class User {

    public String email;
    public String password;
    public String old;
    public String tall;
    public String weight;

    public User(){
        // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
    }

    public String getemail(){return email;}
    public String getpassword(){return password;}
    public String getold(){return old;}
    public String gettall(){return tall;}
    public String getweight(){return weight;}


    public void setemail(String email){this.email = email;}
    public void setpassword(String password){this.password = password;}
    public void setold(String old){this.old = old;}
    public void settall(String tall){this.tall = tall;}
    public void setweight(String weight){this.weight = weight;}

    public User(String email, String password,String old, String tall, String weight){
        this.email=email;
        this.password=password;
        this.old=old;
        this.tall=tall;
        this.weight=weight;
    }
}
