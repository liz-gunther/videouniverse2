//package jpa.models;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "wishlist")
//public class Wishlist {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private long userid;
//    private Date createdDate;
//    @OneToMany(targetEntity = Movies.class)
//    private List<Movies> moviesList;
//
//    public Wishlist() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getUserid() {
//        return userid;
//    }
//
//    public void setUserid(long userid) {
//        this.userid = userid;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public List<Movies> getMoviesList() {
//        return moviesList;
//    }
//
//    public void setMoviesList(List<Movies> moviesList) {
//        this.moviesList = moviesList;
//    }
//}
