public class Song
{
    String name, artist, genre = "";

    // length is in seconds will have a method to convert to minutes
    int year, secLength = 0;
    

    Song(String name, String artist, int year, int secLength, String genre)
    {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.secLength = secLength;
        this.genre = genre;
    }

    public String getArtist()
    {
        return artist;
    }
    public String getName()
    {
        return name;
    }
    public String getGenre()
    {
        return genre;
    }
    public int getYear()
    {
        return year;
    }
    public int getLengthSec()
    {
        return secLength;
    }

    public String getLengthMin()
    {
        String minSec = (secLength/60) + "";
        minSec += ":";
        minSec += (secLength%60) + "";
        return minSec;
    }
}