
package hust.soict.ict.aims.media;
import java.util.Comparator; 
import java.util.ArrayList;
public class Media implements Comparable<Media> {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media(int id, String title, String category, float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(String title, String category, float  cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
    }


    public int getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public void toStringItem(int order) {
        System.out.println(order + ".Media - " + title + " - " + category + " - " + cost + " $");
    }
    public boolean isMatchItem(Media item){
        return this.id == item.id &&
                this.title == item.title &&
                this.category == item.category &&
                this.cost == item.cost;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) throw new NullPointerException("Object is null");
        if (!(o instanceof Media)) throw new ClassCastException("Object is not a Media");
        Media media = (Media) o;
        return title.equals(media.title);
    }
    @Override
    public int compareTo(Media other) {
        // Sắp xếp theo tiêu đề sau đó giá
        if (other == null) {
            throw new NullPointerException("object compare is null");
        }
        int result = this.title.compareTo(other.title);
        if (result == 0) {
            result = Float.compare(other.cost, this.cost);
        }
        return result;
    }

    // Comparator để sắp xếp theo giá sau đó tiêu đề
    public static Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
        @Override
        public int compare(Media media1, Media media2) {
            int result = Float.compare(media2.cost, media1.cost);
            if (result == 0) {
                result = media1.title.compareTo(media2.title);
            }
            return result;
        }
    };

    // Comparator để sắp xếp theo tiêu đề sau đó giá
    public static Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        @Override
        public int compare(Media media1, Media media2) {
            int result = media1.title.compareTo(media2.title);
            if (result == 0) {
                result = Float.compare(media2.cost, media1.cost);
            }
            return result;
        }
    };

}
