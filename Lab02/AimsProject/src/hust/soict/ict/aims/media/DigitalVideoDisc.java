package hust.soict.ict.aims.media;


import hust.soict.ict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String title, String category,String director,int length, float cost) {
        super(title,category,director,length,cost);
    }

    @Override
    public void play()throws PlayerException {
        if (length > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }
    @Override
    public void toStringItem(int order){
        System.out.println(order + ".CD - " +  this.getCategory()+ " - " + this.getDirector() + " - " + this.getLength()+ " - " + this.getCost() + " $");
    }
    public boolean isMatchTitle(String title){
        return this.getTitle() == title;
    }
    public boolean isMatchItem(DigitalVideoDisc item){
        return this.id == item.id &&
                this.title.equals(item.getTitle())&&
                this.category.equals(item.getCategory()) &&
                this.cost == item.cost &&
                this.director.equals(item.getDirector()) &&
                this.length == item.length;
    }

}