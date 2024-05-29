package hust.soict.ict.aims.media;

import hust.soict.ict.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }
    public Track(String title){
        this.title = title;
    }

    public void play()throws PlayerException {
        if (length > 0) {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive");
        }
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public boolean isMatch(Track itemSong){
        return this.getTitle() == itemSong.getTitle() && this.getLength() == itemSong.getLength();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return length == track.length && title.equals(track.title);
    }
}