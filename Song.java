public class Song
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
     * @return the name of the artist 
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Returns the name of the song 
     * @return the name of the song 
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the genre of the song 
     * @return the genre of the song 
     */
    public String getGenre()
    {
        return genre;
    }
    /**
     * Returns the year the song was released 
     * @return the year the song was released
     */
    public int getYear()
    {
        return year;
    }
    /**
     * Gets the length of the song in seconds 
     * @return the length of the song in seconds 
     */
    public int getLengthSec()
    {
        return secLength;
    }

    /**
     * Returns the length of the song in minutes 
     * @return the length of the song
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