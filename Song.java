import java.io.Serializable;

public class Song implements Serializable
{
    private String name, artist, genre = "";

    // length is in seconds will have a method to convert to minutes
    private int year, secLength = 0;

    /**
     * Creates a song object that is to be added into a playlist
     * @param name the name of the song
     * @param artist the artist who created the song
     * @param year the year the song was released
     * @param secLength the song length in seconds
     * @param genre the genre of the song
     */
    Song(String name, String artist, int year, int secLength, String genre)
    {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.secLength = secLength;
        this.genre = genre;
    }

    /**
     * Returns the name of the artist
     * @return artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Returns the name of the song
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the genre of the song
     * @return genre
     */
    public String getGenre()
    {
        return genre;
    }
    /**
     * Returns the year the song was released
     * @return year
     */
    public int getYear()
    {
        return year;
    }
    /**
     * Gets the length of the song in seconds
     * @return secLength
     */
    public int getLengthSec()
    {
        return secLength;
    }

    /**
     * Returns the length of the song in minutes
     * @return minSec
     */
    public String getLengthMin()
    {
        String minSec = (secLength/60) + "";
        minSec += ":";
        if(secLength%60 == 0)
        {
            minSec += (secLength%60) + "0";
        }
        else
        {
            minSec += (secLength%60) + "";
        }

        return minSec;
    }
}